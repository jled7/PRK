
public class Lapikoa {
	private int puskaKopurua, puskaMaximoa;
	private boolean block = false;

	private Pantaila pantaila;
	
	public Lapikoa(int puskaMaximoa, Pantaila pantaila) {
		this.puskaKopurua = 0;
		this.puskaMaximoa = puskaMaximoa;
		this.pantaila = pantaila;
	}
	
	// when(i<MK)		s.bota[b:1..MK-i]	 ->LAPIKOA[i+b][0]
	synchronized void bota(int kantitatea) throws InterruptedException {
		while (!(puskaKopurua < puskaMaximoa))
			wait();
		puskaKopurua += kantitatea;
		block = false;
		pantaila.margotu(-1, "bota:"+kantitatea, puskaKopurua);
		notifyAll();
	}
	
	// when (i>0)       b[BR].hartu[r:1..i] -> LAPIKOA[i-r][0]
	synchronized void hartu(int i, int kantitatea) throws InterruptedException {
		while (!(puskaKopurua > 0))
			wait();
		puskaKopurua -= kantitatea;
		block = false;
		pantaila.margotu(i, "hartu:"+kantitatea, puskaKopurua);
		notifyAll();
	}
	
	// when(s==0)		{b[BR],s}.begiratu[i]->LAPIKOA[ i ][1]
	synchronized int begiratu() throws InterruptedException {
		while (!(block == false))
			wait();
		block = true;
		notifyAll();
		return puskaKopurua;
	}

	//                   {b[BR],s}.askatu	 ->LAPIKOA[ i ][0]
	synchronized void askatu(int id) throws InterruptedException {
		block = false;
		pantaila.margotu(id, "askatu", puskaKopurua);
		notifyAll();
	}
	
	public int getPuskaKopurua() {
		return puskaKopurua;
	}
	
	public int getPuskaMaximoa() {
		return puskaMaximoa;
	}
}
