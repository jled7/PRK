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
	synchronized boolean get() throws java.lang.InterruptedException {
		while (hartua) {
			wait(1000);
			if(hartua) return false;
		}
			
		hartua = true;
		return true;
	}
	
	public void printSardeska() {
		System.out.print("\t\t\t\t\t\t\t\t\t\t");
		for(int i=0;i<zenbakia;i++) {
			System.out.print("\t\t");
		}
		String text = hartua ? "hartua" : "utzia";
		System.out.println(text);
	}
}