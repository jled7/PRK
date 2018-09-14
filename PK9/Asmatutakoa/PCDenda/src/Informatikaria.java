public class Informatikaria extends Thread {
	public int id;
	public Konponketak konponketak;
	public int OK = PCDendaApp.ORDENAGAILU_MAX;
	public int x = 160;
	public int y = 64;
	public int abiadura = 2;
	public boolean geldik = true; 
	public boolean konpontzen = false;
	public boolean izarreiBegira = false;
	public int move = 2; // {0:Up, 1:Right, 2: Down, 3:Left}

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
					mostradorera();
					konponketak.mostradorera();
					sleep((int) (Math.random() * 1000));
					konponketak.ordenadoreaJaso();
					sleep((int) (Math.random() * 1000));
					barruraJoan();
					konponketak.barruraJoan();
				} else {
					if(ok > 0 && oe<OK) {
						konpontzen = true;
						sleep((int) (Math.random() * 10000));
						konponketak.ordenadoreaKonpondu();
						ordenadoreaKonpondu();
						konpontzen = false;
					} else {
						izarreiBegira = true;
						sleep((int) (Math.random() * 2000));
						izarreiBegira = false;
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}


	private void ordenadoreaKonpondu() {
		int[] ordenagailuak = PCDendaApp.panel.ordenagailuak;
		int[] ordenagailuKonponduak = PCDendaApp.panel.ordenagailuKonponduak;
		for(int i=0; i<ordenagailuKonponduak.length; i++) {
			if(ordenagailuKonponduak[i] == 0) {
				ordenagailuKonponduak[i] = ordenagailuak[0];
				break;
			}
		}
		ordenagailuak[0] = 0;
		for(int i=1; i<ordenagailuak.length; i++) {
			ordenagailuak[i-1] = ordenagailuak[i];
			ordenagailuak[i] = 0;
		}
	}

	private void mostradorera() throws InterruptedException {
		geldik = false;
		move = 2;
		while(y<240) {
			y+=abiadura;
			sleep(25);
		}
		geldik = true;		
	}
	
	private void barruraJoan() throws InterruptedException {
		PCDendaApp.panel.hartzeko = 0;
		geldik = false;
		move = 0;
		while(y>64) {
			y-=abiadura;
			sleep(25);
		}
		geldik = true;	
		int[] ordenagailuak = PCDendaApp.panel.ordenagailuak;
		for(int i=0; i<ordenagailuak.length; i++) {
			if(ordenagailuak[i] == 0) {
				ordenagailuak[i] = PCDendaApp.panel.nextComputer;
				break;
			}
		}
	}
	
}