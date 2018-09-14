public class Basatia extends Thread {
	private Lapikoa lapikoa;
	private int id;
	private Pantaila pantaila;

	public Basatia(int id, Lapikoa k, Pantaila p) {
		this.lapikoa = k;
		this.id = id;
		this.pantaila = p;
	}

	// BASATIA = (hartu->jan->tripazgora->BASATIA).
	public void run() {
		while (true) {
			try {
				lapikoa.hartu(id);
				sleep((int) (Math.random() * 1000));
				pantaila.margotu(id,"jan", -1);
				sleep((int) (Math.random() * 1000));
				pantaila.margotu(id,"tripaz", -1);
				sleep((int) (Math.random() * 1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
