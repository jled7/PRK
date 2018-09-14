public class Idazlea extends Thread {
	private String baiEz;
	private int denbora, kopurua;
	private Pantaila p;

	public Idazlea(String s, int i, int j, Pantaila pant) {
		baiEz = s;
		denbora = i;
		kopurua = j;
		p = pant;
	}

	public void run() {
		int i;
		for (i = 0; i < kopurua; i++) {
			p.margotu(baiEz);
			try {
				sleep(denbora);
			} catch (InterruptedException e) {
			}
		}
		p.margotu(baiEz + " bukatu da");
	}
}
