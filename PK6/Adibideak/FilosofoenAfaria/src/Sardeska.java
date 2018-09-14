public class Sardeska {

	private boolean hartua = false;
	private int zenbakia;

	Sardeska(int zenb) {
		zenbakia = zenb;
	}

	public synchronized void put() {
		hartua = false;
		Pantaila.idatzi(zenbakia + " utzia ");
		notify();
	}

	// when (h==0) get ->SARD[1]
	public synchronized void get() throws java.lang.InterruptedException {
		while (hartua)
			wait();
		hartua = true;
		Pantaila.idatzi(zenbakia + " hartua");
	}
}
