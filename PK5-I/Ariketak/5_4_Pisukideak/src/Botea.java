public class Botea {
	private int txanponKopurua, txanponMaximoa;
	private boolean block = false;

	private Pantaila pantaila;
	
	public Botea(int txanponMaximoa, Pantaila pantaila) {
		this.txanponKopurua = 0;
		this.txanponMaximoa = txanponMaximoa;
		this.pantaila = pantaila;
	}
	
	// when(n<TM)	sartu[r:1..TM-n] ->BOTEA[n+r][0]
	synchronized void sartu(int i, int kantitatea) throws InterruptedException {
		while (!(txanponKopurua < txanponMaximoa))
			wait();
		txanponKopurua += kantitatea;
		pantaila.margotu(i, "sartu["+kantitatea+"]", txanponKopurua);
		block = false;
		notifyAll();
	}
	
	// when(n>0) 	hartu[r:1..n]	 ->BOTEA[n-r][0]
	synchronized void hartu(int i, int kantitatea) throws InterruptedException {
		while (!(txanponKopurua > 0))
			wait();
		txanponKopurua -= kantitatea;
		block = false;
		pantaila.margotu(i, "hartu["+kantitatea+"]", txanponKopurua);
		notifyAll();
	}
	
	// when(s==0)	begiratu[n]  	 ->BOTEA[ n ][1]
	synchronized int begiratu() throws InterruptedException {
		while (!(block == false))
			wait();
		block = true;
		notifyAll();
		return txanponKopurua;
	}

	//        		askatu->BOTEA[ n ][0]
	synchronized void askatu() throws InterruptedException {
		block = false;
		notifyAll();
	}
	
	public int getTxanponKopurua() {
		return txanponKopurua;
	}
	
	public int getTxanponMaximoa() {
		return txanponMaximoa;
	}
}
