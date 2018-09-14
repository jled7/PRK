public class Buffer {

	int kont, tam, in, out;
	char buf[];
	Pantaila pantaila;

	public Buffer(int tamaina, Pantaila pantaila) {
		buf = new char[tamaina];
		for(int i=0;i<tamaina;i++) {
			buf[i] = ' ';
		}
		this.pantaila = pantaila;
		this.tam = tamaina;
		this.kont = 0;
		this.in = 0;
		this.out = 0;
	}

	public synchronized void put(char c) throws InterruptedException {
		while (!(kont < tam))
			wait();
		buf[in] = c;
		++kont;
		in = (in + 1) % tam;
		pantaila.erakutsi(buf);
		notify();
	}

	public synchronized char get() throws InterruptedException {
		while (!(kont > 0))
			wait();
		char c = buf[out];
		buf[out] = ' ';
		--kont;
		out = (out + 1) % tam;
		pantaila.erakutsi(buf);
		notify();
		return (c);
	}
}
