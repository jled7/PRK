class Filosofoa extends Thread {
	int zenb;
	Sardeska ezkerrekoa, eskubikoa;
	String tartea;
	Maiordomoa maiordomoa;

	Filosofoa(int i, Sardeska sar1, Sardeska sar2, String tab, Maiordomoa maiordomoa) {
		zenb = i;
		ezkerrekoa = sar1;
		eskubikoa = sar2;
		tartea = tab;
		this.maiordomoa = maiordomoa;
	}

	// FIL = (eseri->eskubi.get->ezker.get->jan->eskubi.put->ezker.put->altxatu->FIL).
	public void run() {
		try {
			while (true) {
				// eseri
				sleep((int) (3000 * Math.random()));				
				maiordomoa.eseri(tartea);
				
				
				System.out.println(tartea + " pentsatzen");
				sleep((int) (1000 * Math.random()));
				System.out.println(tartea + " gose");
				eskubikoa.get();
				System.out.println(tartea + " eskub.hartu");
				sleep(5000);
				ezkerrekoa.get();
				System.out.println(tartea + " ezker.hartu");
				System.out.println(tartea + " JATEN");
				sleep((int) (500 * Math.random()));
				eskubikoa.put();
				System.out.println(tartea + " eskubi.utzi");
				ezkerrekoa.put();
				System.out.println(tartea + " ezker.utzi");
				
				// altxatu
				sleep((int) (3000 * Math.random()));
				maiordomoa.altxatu(tartea);
			}
		} catch (java.lang.InterruptedException e) {
		}
	}
}