public class Prozesua extends Thread {
	public int id;
	public LIFO fifo;

	public Prozesua(int id, LIFO fifo) {
		this.fifo = fifo;
		this.id = id;
	}

	// Prozesua = (sartu[j:0..PT-1]->atera[j]->Prozesua).
	public void run() {
		while (true) {
			try {
				sleep((int) (Math.random() * 1000));
				int sartuta = fifo.sartu(id);
				sleep((int) (Math.random() * 1000));
				fifo.atera(id, sartuta);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}