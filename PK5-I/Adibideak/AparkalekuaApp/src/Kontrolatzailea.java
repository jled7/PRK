public class Kontrolatzailea {
	private int kop;
	private int plazak;
	private Pantaila pantaila;

	Kontrolatzailea(int pl, Pantaila pant) {
		plazak = pl;
		pantaila = pant;
		kop = 0;
	}

	synchronized void sartu() throws InterruptedException {
		while (!(kop < plazak))
			wait();
		++kop;
		pantaila.sartu(kop);
		notify();
	}

	synchronized void irten() throws InterruptedException {
		while (!(kop > 0))
			wait();
		--kop;
		pantaila.irten(kop);
		notify();
	}
}
