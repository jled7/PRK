
public class Kotxea extends Thread {
	String ikurra;
	int abiadura;
	Pantaila pantaila;

	public Kotxea(String ikurra, int abiadura, Pantaila p) {
		this.ikurra = ikurra;
		this.abiadura = abiadura;
		this.pantaila = p;
	}

	public void run() {
		while (true) {
			for (int x = 0; x < 100; x++) {
				pantaila.margotu(x, ikurra);
				try {
					sleep(1000 / abiadura);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
