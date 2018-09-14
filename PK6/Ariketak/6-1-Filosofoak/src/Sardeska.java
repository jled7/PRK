class Sardeska {
	private boolean hartua = false;
	private int zenbakia;

	Sardeska(int zenb) {
		zenbakia = zenb;
	}
	
	//when (h==1) put->SARD[0]).
	synchronized void put() throws InterruptedException {
		while (!hartua) wait();
		hartua = false;
		notify();
	}
	//when (h==0) get->SARD[1]
	synchronized void get() throws java.lang.InterruptedException {
		while (hartua)
			wait();
		hartua = true;
	}
}