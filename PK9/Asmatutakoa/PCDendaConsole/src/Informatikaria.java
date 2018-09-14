public class Informatikaria extends Thread {
	public int id;
	public Konponketak konponketak;
	public int OK = PCDendaApp.ORDENAGAILU_MAX;

	public Informatikaria(int id, Konponketak konponketak) {
		this.konponketak = konponketak;
		this.id = id;
	}

	// INFORMATIKARIA = (begiratu[pk:PR][ok:OR][oe:OR]->if(pk > 0 && ok<OK) then
		//															(mostradorera->ordenadoreaJaso->barruraJoan->INFORMATIKARIA)
		//	  												else
		//															if(ok > 0 && oe<OK) then
		//																	(ordenadoreaKonpondu						->INFORMATIKARIA)
		//															else
		//																	(izarreiBegira								->INFORMATIKARIA)).		
	public void run() {
		while (true) {
			try {
				sleep((int) (Math.random() * 1000));
				int[] begir = konponketak.begiratu();
				int pk = begir[0];
				int ok = begir[1];
				int oe = begir[2];
				if(pk > 0 && ok<OK) {
					sleep((int) (Math.random() * 1000));
					konponketak.mostradorera();
					sleep((int) (Math.random() * 1000));
					konponketak.ordenadoreaJaso();
					sleep((int) (Math.random() * 1000));
					konponketak.barruraJoan();
				} else {
					if(ok > 0 && oe<OK) {
						Pantaila.margotuNL(0, "konpontzen...");
						sleep((int) (Math.random() * 10000));
						konponketak.ordenadoreaKonpondu();
					} else {
						Pantaila.margotuNL(0, "izarreiBegira");
						sleep((int) (Math.random() * 2000));
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}