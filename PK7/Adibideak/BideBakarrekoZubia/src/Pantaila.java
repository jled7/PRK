public class Pantaila {
	int zab, maxg, maxu, zubezk, zubesk;
	int[] gorriaX, urdinaX;
	String[] tabul;

	public Pantaila(int mg, int mu, int zabalera, int ezk, int esk) {
		maxg = mg;
		maxu = mu;
		zab = zabalera;
		zubezk = ezk;
		zubesk = esk;
		gorriaX = new int[maxg];
		urdinaX = new int[maxu];
		// Kotxe bakoitzaren hasierako posizioa
		for (int i = 0; i < maxg; i++)
			gorriaX[i] = i - maxg;

		for (int i = 0; i < maxu; i++)
			urdinaX[i] = zab - i + maxu - 1;

		// Tabulazioak
		tabul = new String[zab + 1];
		for (int i = 0; i < zab + 1; ++i) {
			tabul[i] = "";
			for (int j = 0; j < i; ++j)
				tabul[i] = tabul[i] + "\t";
		}
		pantailaratu();
	}

	synchronized public void pantailaratu() {
		// for (int x = 0; x<24 ; x++){ System.out.println();}
		for (int i = 0; i < maxg; i++)
			// Gorriak
			if (gorriaX[i] > -1) {
				System.out.println(gorriaX[i] + "|\t" + tabul[gorriaX[i]]
						+ "gorri" + i + ">>");
			} else {
				System.out.println(gorriaX[i] + "|");
			}
		for (int i = 0; i < maxu; i++)
			// Urdinak
			if (urdinaX[i] < zab) {
				System.out.println(urdinaX[i] + "|\t" + tabul[urdinaX[i]]
						+ "<<urdin" + i);
			} else {
				System.out.println(urdinaX[i] + "|");
			}
		System.out.print("\t" + tabul[zubezk]); // zubia
		for (int i = zubezk; i < zubesk + 1; i++)
			System.out.print("********");
		System.out.println();
	}

	synchronized public boolean mugituGorria(int i) throws InterruptedException {
		int X = gorriaX[i];
		if (X == zab && gorriaX[(i + 1) % maxg] != 0)
			X = 0; // Bukaerara iristean
		else if (X != zab && gorriaX[(i + 1) % maxg] != X + 1)
			X = X + 1; // Beste posizioetan
		if (gorriaX[i] != X) {
			gorriaX[i] = X;
			pantailaratu();
		} // Mugitu ahal bada, mugitu eta pantailaratu
		return (X >= zubezk - 1 && X <= zubesk); // Zubira sartzeko edo zubian
													// badago
	}

	synchronized public boolean mugituUrdina(int i) throws InterruptedException {
		int X = urdinaX[i];
		if (X == 0 && urdinaX[(i + 1) % maxu] != zab)
			X = zab;
		else if (X != 0 && urdinaX[(i + 1) % maxu] != X - 1)
			X = X - 1;
		if (urdinaX[i] != X) {
			urdinaX[i] = X;
			pantailaratu();
		}
		return (X >= zubezk && X <= zubesk + 1);
	}

}
