public class Prozesua extends Thread {
	private Kontrola kontrola;
	private int id;

	public Prozesua(int id, Kontrola k) {
		this.kontrola = k;
		this.id = id;
	}

	// PROZESUA = (iritsi->egin->irten->PROZESUA).
	public void run() {
		while (true) {
			try {
				
				kontrola.iritsi(id);
				sleep((int) (Math.random() * 1000));
				kontrola.egin(id);
				sleep((int) (Math.random() * 1000));
				kontrola.irten(id);
				sleep((int) (Math.random() * 1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
