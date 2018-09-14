public class Irakurlea extends Thread {
	IrakurriIdatzi blok;
	String tab;
	int lo, lan, x;

	Irakurlea(IrakurriIdatzi blokeoa, String tabul, int loegiten, int lanegiten) {
		blok = blokeoa;
		tab = tabul;
		lan = lanegiten;
		lo = loegiten;
		x = 1;
	}

	public void run() {
		try {
			while (true) {
				while (!jarduera("lo"))
					;
				// sekzio kritikoan sartu
				blok.eskuratuIrakurri();
				while (jarduera("aztertu"))
					;
				blok.askatuIrakurri();
			}
		} catch (InterruptedException e) {
		}
	}

	boolean jarduera(String s) {
		System.out.println(tab + s);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		if (x < lo) {
			x = x + 1;
			return false;
		} else if (x < lo + lan) {
			x = x + 1;
			return true;
		} else {
			x = 1;
			return false;
		}
	}
}