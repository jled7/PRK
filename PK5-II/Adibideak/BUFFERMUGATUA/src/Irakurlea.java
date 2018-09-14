public class Irakurlea extends Thread {
	Buffer buf;
	Pantaila pantaila;

	Irakurlea(Buffer b, Pantaila pant) {
		buf = b;
		pantaila = pant;
	}

	public void run() {
		try {
			while (true) {
				if (Math.random() < 0.3)
					sleep(1000);
				synchronized (buf) {
					char get = buf.get();
					pantaila.idatzi("\t\t\t>" + get);	
				}
				
			}
		} catch (InterruptedException e) {
		}
	}
}
