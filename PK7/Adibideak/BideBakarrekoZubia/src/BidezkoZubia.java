public class BidezkoZubia extends Zubia {
	private int kGorria = 0; // kotxe gorrien kopurua zubian;
	private int kUrdina = 0; // kotxe urdinen kopurua zubian;
	private int zaiGorria = 0; // sartzeko zai dauden kotxe gorrien kopurua
	private int zaiUrdina = 0; // sartzeko zai dauden kotxe urdinen kopurua
	private boolean urdinTx = true;

	synchronized void sartuGorria() throws InterruptedException {
		++zaiGorria;
		while (!(kUrdina == 0 && (zaiUrdina == 0 || !urdinTx)))
			wait();
		--zaiGorria;
		++kGorria;
	}

	synchronized void irtenGorria() {
		--kGorria;
		urdinTx = true;
		if (kGorria == 0)
			notifyAll();
	}

	synchronized void sartuUrdina() throws InterruptedException {
		++zaiUrdina;
		while (!(kGorria == 0 && (zaiGorria == 0 || urdinTx)))
			wait();
		--zaiUrdina;
		++kUrdina;
	}

	synchronized void irtenUrdina() {
		--kUrdina;
		urdinTx = false;
		if (kUrdina == 0)
			notifyAll();
	}
}