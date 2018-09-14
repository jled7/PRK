
class Atea extends Thread {
	Kontagailua kont;
	String atea;

	public Atea(String zeinAte, Kontagailua k) {
		kont = k;
		atea = zeinAte;
	}

	public void run() {
		try {
			for (int i = 1; i <= LorategiaApp.MAX; i++) {
				sleep((long) (Math.random() * 1000));
				// ausazko denbora itxaron (0 eta 1 segunduren tartean)
				
				// Imprimazioa
				System.out.print(atea+"[");
				for(int k = 0;k < i; k++) { 
					System.out.print("*");
					Simulatu.HWinterrupt();
				}	
				for(int j = i; j < LorategiaApp.MAX; j++) 
					System.out.print(" ");				
				System.out.println("]");
				//
				
				kont.gehitu();
			}
		} catch (InterruptedException e) {
		}
	}
}
