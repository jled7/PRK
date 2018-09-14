
public class Lapikoa {
	private int puskaKopurua, puskaMaximoa;

	private Pantaila pantaila;
	
	public Lapikoa(int puskaMaximoa, Pantaila pantaila) {
		this.puskaKopurua = 0;
		this.puskaMaximoa = puskaMaximoa;
		this.pantaila = pantaila;
	}
	
	// when(i==0) 	s.bete	   ->LAPIKOA[MK]
	synchronized void bete() throws InterruptedException {
		while(!(puskaKopurua==0)) wait();
		puskaKopurua = puskaMaximoa;
		pantaila.bete(puskaKopurua);
		notifyAll();
	}
	
	// when(i>0)	b[BR].hartu->LAPIKOA[i-1]
	synchronized void hartu(int id) throws InterruptedException {
		while(!(puskaKopurua>0)) wait();
		--puskaKopurua;
		pantaila.hartu(id, 1, puskaKopurua);
		notifyAll();
	}
	
	public int getPuskaKopurua() {
		return puskaKopurua;
	}
	
	public int getPuskaMaximoa() {
		return puskaMaximoa;
	}
}
