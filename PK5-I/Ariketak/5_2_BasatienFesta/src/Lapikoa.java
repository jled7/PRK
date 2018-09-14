
public class Lapikoa {
	private int puskaKopurua, puskaMaximoa;

	private Pantaila pantaila;
	
	public Lapikoa(int puskaMaximoa, Pantaila pantaila) {
		this.puskaKopurua = 0;
		this.puskaMaximoa = puskaMaximoa;
		this.pantaila = pantaila;
	}
	
	// when(i<=MK-3)	s.bota->LAPIKOA[i+3]
	synchronized void bota() throws InterruptedException {
		while(!(puskaKopurua<=puskaMaximoa-3)) wait();
		puskaKopurua += 3;
		pantaila.bota(3, puskaKopurua);
		notifyAll();
	}
	
	// when(i>0)	b[BR].hartu->LAPIKOA[i-1]
	synchronized void hartu(int id) throws InterruptedException {
		while(!(puskaKopurua>0)) wait();
		--puskaKopurua;
		pantaila.hartu(id, puskaKopurua);
		notifyAll();
	}
	
	public int getPuskaKopurua() {
		return puskaKopurua;
	}
	
	public int getPuskaMaximoa() {
		return puskaMaximoa;
	}
}
