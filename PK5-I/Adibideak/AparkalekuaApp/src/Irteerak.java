public class Irteerak extends Thread{
	Kontrolatzailea aparkalekua;

	Irteerak(Kontrolatzailea k) {
		aparkalekua = k;
	}

	public void run() {
		try {
			while (true) {
				sleep((long) (Math.random() * 1000));
				aparkalekua.irten();
			}
		} catch (InterruptedException e) {
		}
	}
}
