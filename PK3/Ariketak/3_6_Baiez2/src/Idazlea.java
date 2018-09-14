public class Idazlea extends Thread {
	private String baiEz;
	private int abiadura, azelerazioa, kopurua;
	private Pantaila p;

	public Idazlea(String s, int i, int j,int k, Pantaila pant) {
		baiEz = s;
		abiadura = i;
		azelerazioa = j;
		kopurua = k;
		p = pant;
	}

	public void run() {
		int i;
		for (i = 0; i < kopurua; i++) {
			try {
				if(abiadura > 0)
					sleep(abiadura);
			} catch (InterruptedException e) {
			}
			p.margotu(baiEz);
			abiadura -= azelerazioa;
		}
		p.margotu(baiEz + " bukatu da");
	}
}
