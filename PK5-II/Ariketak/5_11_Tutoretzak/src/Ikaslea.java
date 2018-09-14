public class Ikaslea extends Thread {
	public int id;
	public Bulegoa bulegoa;

	public Ikaslea(int id, Bulegoa fifo) {
		this.bulegoa = fifo;
		this.id = id;
	}

	// IKASLEA = (bulegoraSartu->galderaEgin->erantzunaJaso->bulegotikAtera->IKASLEA).
	public void run() {
		while (true) {
			try {
				sleep((int) (Math.random() * 1000));
				bulegoa.bulegoraSartu(id);
				sleep((int) (Math.random() * 1000));
				bulegoa.galderaEgin(id);
				sleep((int) (Math.random() * 1000));
				bulegoa.erantzunaJaso(id);
				sleep((int) (Math.random() * 1000));
				bulegoa.bulegotikAtera(id);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}