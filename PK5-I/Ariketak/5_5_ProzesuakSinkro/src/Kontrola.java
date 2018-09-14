
public class Kontrola {
	private int prozesuMaximoa, ateratakoProzesuak, eginikoProzesuak,
			sartutakoProzesuak;

	private Pantaila pantaila;

	public Kontrola(int prozesuMaximoa, Pantaila pantaila) {
		this.prozesuMaximoa = prozesuMaximoa;
		this.ateratakoProzesuak = prozesuMaximoa;
		this.eginikoProzesuak = 0;
		this.sartutakoProzesuak = 0;
		this.pantaila = pantaila;
	}

	// when(a==PK) iritsi->KONTROLA[s+1][ 0 ][ PK]
	public synchronized void iritsi(int id) throws InterruptedException {
		while (!(ateratakoProzesuak == prozesuMaximoa))
			wait();
		sartutakoProzesuak++;
		eginikoProzesuak = 0;
		ateratakoProzesuak = prozesuMaximoa; // Beharrezkoa ez, bainan prozesu
		 									 // pasiboaren kodearen
		 									 // konsistentzia mantentzeko
		pantaila.margotu(id, "iritsi");
		notifyAll();
	}

	// when(s==PK) egin ->KONTROLA[PK ][e+1][ 0 ]
	public synchronized void egin(int id) throws InterruptedException {
		while (!(sartutakoProzesuak == prozesuMaximoa))
			wait();
		eginikoProzesuak++;
		ateratakoProzesuak = 0;
		sartutakoProzesuak = prozesuMaximoa; // Beharrezkoa ez, bainan prozesu
											 // pasiboaren kodearen
											 // konsistentzia mantentzeko
		pantaila.margotu(id, "egin");
		notifyAll();
	}

	// when(e==PK) irten ->KONTROLA[ 0 ][ PK][a+1]
	public synchronized void irten(int id) throws InterruptedException {
		while (!(eginikoProzesuak == prozesuMaximoa))
			wait();
		ateratakoProzesuak++;
		sartutakoProzesuak = 0;
		eginikoProzesuak = prozesuMaximoa; // Beharrezkoa ez, bainan prozesu
										   // pasiboaren kodearen konsistentzia
										   // mantentzeko
		pantaila.margotu(id, "irten");
		notifyAll();
	}

}
