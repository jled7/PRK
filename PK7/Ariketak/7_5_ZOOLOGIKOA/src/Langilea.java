public class Langilea extends Thread {
	public int id;
	public Jangela jangela;

	public Langilea(int id, Jangela jangela) {
		this.jangela = jangela;
		this.id = id;
	}

	// JOSEMI 	= (sartu->begiratu[a:AR] ->if (a>=2) then (hartu->atera->JOSEMI)
	//												 else (atera->JOSEMI)).
	public void run() {
		while (true) {
			try {
				sleep((int) (Math.random() * 1000));
				jangela.sartu(id);
				sleep((int) (Math.random() * 1000));
				jangela.janariaBota(id);	
				sleep((int) (Math.random() * 1000));
				jangela.atera(id);	
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}