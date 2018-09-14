public class ZubiaApp {

	public static void main(String args[]) {
		int maxg = 4;
		int maxu = 3;
		int zabalera = 9;
		int zubezk = zabalera / 2;
		int zubesk = (zabalera / 2) + 1;
		KotxeGorria[] gorria = new KotxeGorria[maxg];
		KotxeUrdina[] urdina = new KotxeUrdina[maxu];
		Pantaila p = new Pantaila(maxg, maxu, zabalera, zubezk, zubesk);
		Zubia z;
		// z = new Zubia();
		//z = new ZubiSegurua();
		z = new BidezkoZubia();

		for (int i = 0; i < maxg; i++) {
			gorria[i] = new KotxeGorria(z, p, i);
			gorria[i].start();
		}
		for (int i = 0; i < maxu; i++) {
			urdina[i] = new KotxeUrdina(z, p, i);
			urdina[i].start();
		}
	}
}