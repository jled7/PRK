public class Prozesua extends Thread {
	public int id;
	public Buffer buffer;
	int z[];
	int batura;

	public Prozesua(int i, Buffer buffer) {
		id = i;
		this.buffer = buffer;
	}

	@Override
	// Prozesua = (hartu->konparatu->sartu->Prozesua).
	public void run() {
		while (true) {
			try {
				sleep((int) (Math.random() * 500));
				z = buffer.hartu(id);
				sleep((int) (Math.random() * 1000));
				batura = z[1] + z[0];
				Pantaila.margotu(id, "Batu\t", buffer.array);
				sleep((int) (Math.random() * 500));
				buffer.sartu(id, batura);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}