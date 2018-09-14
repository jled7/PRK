public class Basatia extends Thread {
	private Lapikoa lapikoa;
	private int id;
	private Pantaila pantaila;

	public Basatia(int id, Lapikoa k, Pantaila p) {
		this.lapikoa = k;
		this.id = id;
		this.pantaila = p;
	}

	// BASATIA 	= (begiratu[k:MR] ->
	//				if (k>0) then (random[r:1..k] ->hartu[r]->BASATIA)
	//						 else					 (askatu->BASATIA)).
	public void run() {
		while (true) {
			try {
				int puskaKopurua = lapikoa.begiratu();
				pantaila.margotu(id, "begir:"+puskaKopurua, -1, -1, -1);
				sleep((int) (Math.random() * 1000));
				if(puskaKopurua > 0) {
					int erabaki = (int)(Math.random() * (puskaKopurua)) +1;
					lapikoa.hartu(id, erabaki);
					sleep((int) (Math.random() * 1000));
					pantaila.margotu(id, "jan", -1, -1, -1);
				} else {
					lapikoa.askatu(id);
				}
				sleep((int) (Math.random() * 1000));
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
