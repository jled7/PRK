public class Filosofoa extends Thread {
	int zenb;
	Sardeska ezkerrekoa, eskubikoa;
	String tartea;

	Filosofoa(int i, Sardeska sar1, Sardeska sar2, String tab) {
		zenb = i;
		ezkerrekoa = sar1;
		eskubikoa = sar2;
		tartea = tab;
	}

	// FIL =
	// (eseri->eskubi.get->ezker.get->jan->eskubi.put->ezker.put->altxatu->FIL).
	public void run() {
		try {
			while (true) {
				Pantaila.idatzi(tartea + " pentsatzen");
				sleep((int) (1000 * Math.random()));
				Pantaila.idatzi(tartea + " gose");
				eskubikoa.get();
				Pantaila.idatzi(tartea + " eskub.hartu");
				sleep(5000);
				ezkerrekoa.get();
				Pantaila.idatzi(tartea + " ezker.hartu");
				Pantaila.idatzi(tartea + " jaten");
				sleep((int) (500 * Math.random()));
				eskubikoa.put();
				ezkerrekoa.put();
			}
		} catch (java.lang.InterruptedException e) {
		}
	}
}
