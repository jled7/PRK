public class Lehoia extends Thread {
	public int id;
	public Jangela jangela;

	public Lehoia(int id, Jangela jangela) {
		this.jangela = jangela;
		this.id = id;
	}

	// LEHOIA = (sartu->begiratu[a:HR]->if(a>0) then (jan->askatu->atera->LEHOIA)
	 //											else (askatu     ->atera->LEHOIA)).
	public void run() {
		while (true) {
			try {
				
				sleep((int) (Math.random() * 1000));
				jangela.sartuL(id);
				sleep((int) (Math.random() * 1000));
				int begiratua = jangela.begiratu(id);
				sleep((int) (Math.random() * 1000));
				if(begiratua > 0) {
					jangela.jan(id);
					sleep((int) (Math.random() * 1000));
					jangela.askatu(id);
					sleep((int) (Math.random() * 1000));
					jangela.ateraL(id);
				} else {
					jangela.askatu(id);
					sleep((int) (Math.random() * 1000));
					jangela.ateraL(id);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}