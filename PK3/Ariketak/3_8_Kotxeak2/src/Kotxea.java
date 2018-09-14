
public class Kotxea extends Thread {
	String ikurra;
	int abiadura, azelerazioa, hasierakoAbiadura;
	Pantaila pantaila;

	public Kotxea(String ikurra, int abiadura, int azelerazioa, Pantaila p) {
		this.ikurra = ikurra;
		this.hasierakoAbiadura = abiadura;
		this.pantaila = p;
		this.azelerazioa = azelerazioa;
	}

	public void run() {
		while (true) {
			for (int x = 0, abiadura = hasierakoAbiadura; x < 100; x++) {
				pantaila.margotu(x, ikurra);
				try {
					sleep(1000 / abiadura);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				abiadura += azelerazioa;
				if(abiadura < 10) 
					abiadura = 10;
				if(abiadura > 50) 
					abiadura = 50;
			}
		}
	}
}
