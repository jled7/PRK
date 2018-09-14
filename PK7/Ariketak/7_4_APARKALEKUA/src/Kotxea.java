public class Kotxea extends Thread {
	public int id;
	public Aparkalekua aparkalekua;

	public Kotxea(int id, Aparkalekua zebrabidea) {
		this.aparkalekua = zebrabidea;
		this.id = id;
	}

	// IBILGAILUA = (iritsi->pasabideraSartuKanpotik->aparkatu->pasabideraSartuBarrutik->joan->IBILGAILUA).
	public void run() {
		while (true) {
			try {
				sleep((int) (Math.random() * 1000));
				aparkalekua.iritsiK(id);
				sleep((int) (Math.random() * 1000));
				aparkalekua.pasabideraSartuKanpotikK(id);
				sleep((int) (Math.random() * 1000));
				aparkalekua.aparkatuK(id);
				sleep((int) (Math.random() * 20000));
				aparkalekua.pasabideraSartuBarrutikK(id);
				sleep((int) (Math.random() * 1000)); 
				aparkalekua.joanK(id);
				sleep((int) (Math.random() * 20000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}