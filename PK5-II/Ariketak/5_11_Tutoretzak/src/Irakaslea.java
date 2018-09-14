public class Irakaslea extends Thread {
	public Bulegoa bulegoa;

	public Irakaslea(Bulegoa fifo) {
		this.bulegoa = fifo;
	}

	// IKASLEA = (bulegoraSartu->galderaEgin->erantzunaJaso->bulegotikAtera->IKASLEA).
	public void run() {
		while (true) {
			try {
				sleep((int) (Math.random() * 1000));
				bulegoa.galderaEntzun();
				sleep((int) (Math.random() * 1000));
				bulegoa.pentsatzen(); //Pantaila.margotu(-1, "Pentsatzen");
				sleep((int) (Math.random() * 1000));
				bulegoa.galderaErantzun();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}