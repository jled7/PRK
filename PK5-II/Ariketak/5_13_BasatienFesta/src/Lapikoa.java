
public class Lapikoa {
	private int puskaKopurua, puskaMaximoa;  // Lapikoa
	private int misiolariKopurua, misiolariMaximoa;
	private int hozkailuarenKopurua, hozkailuarenMaximoa;
	private boolean block = false;

	private Pantaila pantaila;
	
	public Lapikoa(int puskaMaximoa, Pantaila pantaila) {
		this.puskaKopurua = 0;
		this.misiolariKopurua = 0;
		this.hozkailuarenKopurua = 0;
		this.puskaMaximoa = puskaMaximoa;
		this.misiolariMaximoa = BasatienFestaApp.MISIOLARI_KOPURUA;
		this.hozkailuarenMaximoa = BasatienFestaApp.HOZKAILUAREN_TAMAINA;
		this.pantaila = pantaila;
	}
	
	// when(s==0)			t.begiratu[m]		  ->LAPIKOA[ m ][    h    ][ l ][1]
	synchronized int begiratuHondartzan() throws InterruptedException {
		while(!(block == false)) wait();
		block = true;
		notifyAll();
		return misiolariKopurua;
	}
	
	// |when(m<MK)			t.iritsi[r:1..MK-m]	  ->LAPIKOA[m+r][    h    ][ l ][0]
	synchronized void iritxi(int kantitatea) throws InterruptedException {
		while (!(misiolariKopurua < misiolariMaximoa)) wait();
		misiolariKopurua += kantitatea;
		block = false;
		pantaila.margotu(-1, "iritsi:"+kantitatea, misiolariKopurua, hozkailuarenKopurua, puskaKopurua);
		notifyAll();
	}
	
	// t.askatu	  ->LAPIKOA[ m ][    h    ][ l ][0]
	synchronized void txalupaAskatu() {
		block = false;
		notifyAll();
	}
	
	
	// when(s==0)		 	s.begiratu[m][h][l]	  ->LAPIKOA[ m ][    h    ][ l ][1]		
	synchronized int[] begiratuSukaldatzeko(int id) throws InterruptedException {
		while(!(block == false)) wait();
		
		block = true;
		int[] ret = new int[3];
		ret[0]=misiolariKopurua;
		ret[1]=hozkailuarenKopurua;
		ret[2]=puskaKopurua;
		
		pantaila.margotu(id,"b["+misiolariKopurua+"]["+hozkailuarenKopurua+"]["+puskaKopurua+"]", misiolariKopurua, hozkailuarenKopurua, puskaKopurua);
		
		return ret;
	}
	
	// when(h>0)			s.botaLapikora[r:1..h]->LAPIKOA[ m ][   h-r   ][l+r][0]	
	synchronized void botaHozkailura(int id) throws InterruptedException {
		while(!(misiolariKopurua > 0)) wait();
		
		int pusketak = BasatienFestaApp.MOZTEKO_PUSKETAK;
		hozkailuarenKopurua += pusketak;
		misiolariKopurua--;
		block = false;
		
		pantaila.margotu(id,"hozkailura[" + pusketak + "]", misiolariKopurua, hozkailuarenKopurua, puskaKopurua);
		notifyAll();
		
	}
	
	// when(h>0)			s.botaLapikora[r:1..h]->LAPIKOA[ m ][   h-r   ][l+r][0]
	synchronized void botaLapikora(int id, int kantitatea) throws InterruptedException {
		while(!(hozkailuarenKopurua > 0)) wait();
		
		hozkailuarenKopurua -= kantitatea;
		puskaKopurua += kantitatea;
		block = false;
		
		pantaila.margotu(id,"lapikora["+kantitatea+"]", misiolariKopurua, hozkailuarenKopurua, puskaKopurua);
		notifyAll();
		
	}

	
	// when(l>0)		 	b[BR].hartu[r:1..l]	  ->LAPIKOA[ m ][    h    ][l-r][0]
	synchronized void hartu(int id, int kantitatea) throws InterruptedException {
		while (!(puskaKopurua > 0))
			wait();
		puskaKopurua -= kantitatea;
		block = false;
		pantaila.margotu(id, "hartu:"+kantitatea, misiolariKopurua, hozkailuarenKopurua, puskaKopurua);
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
		pantaila.margotu(id, "askatu", misiolariKopurua, hozkailuarenKopurua, puskaKopurua);
		notifyAll();
	}
	
	public int getPuskaKopurua() {
		return puskaKopurua;
	}
	
	public int getPuskaMaximoa() {
		return puskaMaximoa;
	}






}
