
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
				System.out.println(atea + i);
				kont.gehitu();
			}
		} catch (InterruptedException e) {
		}
	}
}
