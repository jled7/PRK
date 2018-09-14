
class Kotxea extends Thread {
	private int kotxea;
	private int abiadura;
	private int denbora;
	private int azelerazioa;
	private Framea framea;
	private int x = 600;
	
	public Kotxea(int kotx, int abiad, int azelerazioa, Framea f){
		kotxea=kotx;
		abiadura=abiad;
		framea=f;
		this.azelerazioa = azelerazioa;
	}
	
	public void run() {
		
		while(framea.panela.stillPlaying) {
			framea.panela.setX(kotxea,x);
			framea.panela.checkCollision(kotxea);
			denbora=(int)(1000/abiadura);
			try {sleep(denbora);}
			catch (InterruptedException e) {}
			
			abiadura += azelerazioa;
			if(abiadura < 50) 
				abiadura = 50;
			if(abiadura > 200) 
				abiadura = 100;
			x--;
			if(x < -180) {
				x = 600;
				framea.panela.setY(kotxea,(int) (Math.random() * 400));
				abiadura = (int) (Math.random() * 200);
			}
		}
	}
}