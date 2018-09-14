public class Motoa extends Thread {
	public int id;
	public Aparkalekua aparkalekua;

	public Motoa(int id, Aparkalekua zebrabidea) {
		this.aparkalekua = zebrabidea;
		this.id = id;
	}

	// IBILGAILUA = (iritsi->pasabideraSartuKanpotik->aparkatu->pasabideraSartuBarrutik->joan->IBILGAILUA).
	public void run() {
		while (true) {
			try {
				sleep((int) (Math.random() * 1000));
				Pantaila.margotuNL(id, "iritsi");
				sleep((int) (Math.random() * 1000));
				aparkalekua.pasabideraSartuKanpotikM(id);
				sleep((int) (Math.random() * 1000));
				aparkalekua.aparkatuM(id);
				sleep((int) (Math.random() * 20000));
				aparkalekua.pasabideraSartuBarrutikM(id);
				sleep((int) (Math.random() * 1000));
				aparkalekua.joanM(id);
				sleep((int) (Math.random() * 20000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}