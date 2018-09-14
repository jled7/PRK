class Filosofoa extends Thread {
	int zenb;
	Sardeska ezkerrekoa, eskubikoa;
	String tartea;

	Filosofoa(int i, Sardeska sar1, Sardeska sar2, String tab) {
		zenb = i;
		ezkerrekoa = sar1;
		eskubikoa = sar2;
		tartea = tab;
	}

	// FIL(I=0) = (
	// when (I%2==0)
	// eseri->ezker.get->eskubi.get->jan->ezker.put->eskubi.put->altxatu->FIL|
	// when (I%2==1)
	// eseri->eskubi.get->ezker.get->jan->ezker.put->eskubi.put->altxatu->FIL).
	public void run() {
		try {
			while (true) {
				if (zenb % 2 == 0) {
					System.out.println(tartea + " pentsatzen");
					sleep((int) (1000 * Math.random()));
					System.out.println(tartea + " gose");
					ezkerrekoa.get();
					System.out.println(tartea + " ezker.hartu");
					sleep(5000);
					eskubikoa.get();
					System.out.println(tartea + " eskubi.hartu");
					System.out.println(tartea + " JATEN");
					sleep((int) (500 * Math.random()));
					eskubikoa.put();
					System.out.println(tartea + " eskubi.utzi");
					ezkerrekoa.put();
					System.out.println(tartea + " ezker.utzi");
				} else {
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
				}
			}
		} catch (java.lang.InterruptedException e) {
		}
	}
}