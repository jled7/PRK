
class Kotxea extends Thread {
	private int kotxea;
	private int abiadura;
	private int denbora;
	private int azelerazioa;
	private Framea framea;
	
	public Kotxea(int kotx, int abiad, int azelerazioa, Framea f){
		kotxea=kotx;
		abiadura=abiad;
		framea=f;
		this.azelerazioa = azelerazioa;
	}
	
	public void run() {
		try {sleep(1000);}
		catch (InterruptedException e) {}
		for (int x=0;x<540;x++) {
			framea.panela.setX(kotxea,x);
			
			denbora=(int)(1000/abiadura);
			try {sleep(denbora);}
			catch (InterruptedException e) {}
			
			abiadura += azelerazioa;
			if(abiadura < 30) 
				abiadura = 30;
			if(abiadura > 100) 
				abiadura = 100;
			
			/*
			 * if(kotxea > 1)
			 * 		System.out.print("\t");
			 * System.out.println(kotxea + ": " +abiadura);
			 * */
		}
		System.out.println(" Bukatuta ("+kotxea+")");
	}
}