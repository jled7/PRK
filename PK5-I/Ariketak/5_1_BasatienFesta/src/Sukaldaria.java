
public class Sukaldaria extends Thread {
	Lapikoa lapikoa;
	
	public Sukaldaria(Lapikoa k) {
		this.lapikoa = k;
	}

	// SUKALDARIA	= (bete->SUKALDARIA).
	public void run() {
		while(true) {
			try {
				lapikoa.bete();		
				sleep((int) (Math.random() * 1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
