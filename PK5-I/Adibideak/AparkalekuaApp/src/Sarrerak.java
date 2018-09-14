public class Sarrerak extends Thread {
	Kontrolatzailea aparkalekua;

	Sarrerak(Kontrolatzailea k) {
		aparkalekua = k;
	}

	public void run() {
		try {
			while (true) {
				sleep((long) (Math.random() * 1000));
				aparkalekua.sartu();
			}
		} catch (InterruptedException e) {
		}
	}
}
