public class Txalupa extends Thread {
	private Lapikoa lapikoa;
	private Pantaila pantaila;

	public Txalupa(Lapikoa k, Pantaila p) {
		this.lapikoa = k;
		this.pantaila = p;
	}

	// TXALUPA = (begiratu[m:MR]->
	//								if (m<MK) then (random[i:1..MK-m]->iritsi[i]->TXALUPA)
	//										  else 						 (askatu->TXALUPA)).
	public void run() {
		while (true) {
			try {
				int hondartzanKopurua = lapikoa.begiratuHondartzan();
				pantaila.margotu(-1, "begir:"+hondartzanKopurua, -1, -1, -1);
				sleep((int) (Math.random() * 1000));
				if(hondartzanKopurua < BasatienFestaApp.MISIOLARI_KOPURUA) {
					int erabaki = (int)(Math.random() * (BasatienFestaApp.MISIOLARI_KOPURUA - hondartzanKopurua)) +1;
					lapikoa.iritxi(erabaki);
					sleep((int) (Math.random() * 1000));
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
