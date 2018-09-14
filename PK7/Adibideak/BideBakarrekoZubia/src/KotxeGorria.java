public class KotxeGorria extends Thread {
	Zubia zubia;
	Pantaila pantaila;
	int zenb;

	KotxeGorria(Zubia z, Pantaila p, int zenb) {
		this.zenb = zenb;
		zubia = z;
		pantaila = p;
	}

	public void run() {
		try {
			while (true) {
				while (!pantaila.mugituGorria(zenb))
					// mugitu zubitik kanpoan
					sleep(500 + (int) (2000 * Math.random()));
				zubia.sartuGorria(); // eskatzen du zubiaren atzipena
				while (pantaila.mugituGorria(zenb))
					// mugitu zubiaren barruan
					sleep(500 + (int) (2000 * Math.random()));
				zubia.irtenGorria(); // askatzen du zubiaren atzipena
			}
		} catch (InterruptedException e) {
		}
	}
}