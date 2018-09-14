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
	// FIL = (pentsatzen->gose->eskubi.get->ezker.get->jaten->eskubi.put->ezker.put->FIL).
	public void run() {
		try {
			while (true) {
				System.out.println(tartea + " pentsatzen");
				sleep((int) (1000 * Math.random()));
				System.out.println(tartea + " gose");
				if(eskubikoa.get()) {
					System.out.println(tartea + " eskub.hartu");
					eskubikoa.printSardeska();
					sleep(1000);
					if(ezkerrekoa.get()) {
						System.out.println(tartea + " ezker.hartu");
						ezkerrekoa.printSardeska();
						System.out.println(tartea + " JATEN");
						sleep((int) (500 * Math.random()));
						eskubikoa.put();
						System.out.println(tartea + " eskubi.utzi");
						eskubikoa.printSardeska();
						ezkerrekoa.put();
						System.out.println(tartea + " ezker.utzi");
						ezkerrekoa.printSardeska();
					} else {
						System.out.println(tartea + " ezker.ezHartu");
						ezkerrekoa.printSardeska();
						eskubikoa.put();
						System.out.println(tartea + " eskub.utzi");
						eskubikoa.printSardeska();
					}
				} else {
					System.out.println(tartea + " eskub.ezHartu");
					eskubikoa.printSardeska();
				}		
			}
		} catch (java.lang.InterruptedException e) {
		}
	}
}