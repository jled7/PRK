
public class Sukaldaria extends Thread {
	Lapikoa lapikoa;
	Pantaila pantaila;
	
	public Sukaldaria(Lapikoa k, Pantaila p) {
		this.lapikoa = k;
		this.pantaila = p;
	}

	// SUKALDARIA	= (begiratu[k:MR]->
	// if (k<MK) then (random[r:1..MK-k] ->bota[r]->SUKALDARIA)
	//		     else					   (askatu->SUKALDARIA)).

	public void run() {
		while(true) {
			try {
				int puskaKopurua = lapikoa.begiratu();
				pantaila.margotu(-1, "begir:"+puskaKopurua, puskaKopurua);
				int puskaMaximoa = lapikoa.getPuskaMaximoa();
				if(puskaKopurua < puskaMaximoa) {
					int erabaki = (int)(Math.random() * (puskaMaximoa - puskaKopurua)) +1;
					lapikoa.bota(erabaki);
				} else {
					lapikoa.askatu(-1);
				}
				sleep((int) (Math.random() * 1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
