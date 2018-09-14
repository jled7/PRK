public class Prozesua extends Thread {
	public int id;
	public Buffer buffer;
	int z[];
	int haundiena;

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
				haundiena = ((z[1] > z[0]) ? z[1] : z[0]);
				Pantaila.margotu(id, "Konparatu", buffer.array);
				sleep((int) (Math.random() * 500));
				buffer.sartu(id, haundiena);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}