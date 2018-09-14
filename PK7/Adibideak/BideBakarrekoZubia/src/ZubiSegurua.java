public class ZubiSegurua extends Zubia {
	private int kGorria = 0; // kotxe gorrien kopurua zubian;
	private int kUrdina = 0; // kotxe urdinen kopurua zubian;

	// Monitoreraren Inbariantea: kGorria>=0 and kUrdina>=0 and
	// not (kGorria>0 and kUrdina>0)

	synchronized void sartuGorria() throws InterruptedException {
		while (!(kUrdina == 0))
			wait();
		++kGorria;
	}

	synchronized void irtenGorria() {
		--kGorria;
		if (kGorria == 0)
			notifyAll();
	}

	synchronized void sartuUrdina() throws InterruptedException {

		while (!(kGorria == 0))
			wait();
		++kUrdina;
	}

	synchronized void irtenUrdina() {
		--kUrdina;
		if (kUrdina == 0)
			notifyAll();
	}
}