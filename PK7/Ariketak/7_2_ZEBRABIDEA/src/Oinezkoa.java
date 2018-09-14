public class Oinezkoa extends Thread {
	public int id;
	public Zebrabidea zebrabidea;

	public Oinezkoa(int id, Zebrabidea zebrabidea) {
		this.zebrabidea = zebrabidea;
		this.id = id;
	}

	// OINEZKOA = (iritxi->sartu->atera->OINEZKOA).
	public void run() {
		while (true) {
			try {
				sleep((int) (Math.random() * 5000));
				zebrabidea.iritxiO(id);
				sleep((int) (Math.random() * 1000));
				zebrabidea.sartuO(id);
				sleep((int) (Math.random() * 1000));
				zebrabidea.ateraO(id);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}