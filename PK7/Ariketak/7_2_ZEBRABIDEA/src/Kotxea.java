public class Kotxea extends Thread {
	public int id;
	public Zebrabidea zebrabidea;

	public Kotxea(int id, Zebrabidea zebrabidea) {
		this.zebrabidea = zebrabidea;
		this.id = id;
	}

	// KOTXEA = (iritxi->sartu->atera->KOTXEA).
	public void run() {
		while (true) {
			try {
				sleep((int) (Math.random() * 1000));
				zebrabidea.iritxiK(id);
				sleep((int) (Math.random() * 1000));
				zebrabidea.sartuK(id);
				sleep((int) (Math.random() * 1000));
				zebrabidea.ateraK(id);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}