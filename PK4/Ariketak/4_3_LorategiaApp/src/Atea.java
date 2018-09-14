
class Atea extends Thread {
	Kontagailua kont;
	String atea;
	Pantaila p;

	public Atea(String zeinAte, Kontagailua k, Pantaila p) {
		kont = k;
		atea = zeinAte;
		this.p = p;
	}

	public void run() {
		try {
			for (int i = 1; i <= LorategiaApp.MAX; i++) {
				sleep((long) (Math.random() * 1000));
				// ausazko denbora itxaron (0 eta 1 segunduren tartean)
				
				// Imprimazioa
				p.imprimatu(atea, i, LorategiaApp.MAX);
				//
				
				kont.gehitu();
			}
		} catch (InterruptedException e) {
		}
	}
}
