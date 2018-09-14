public class Pertsona extends Thread {
	public int id;
	public Konponketak konponketak;
	public boolean emanda = false;
	public int x = 128;
	public int y = 500;
	public int abiadura = 2;
	public boolean geldik = true; 
	public boolean konpontzen = false;
	public int move = 2; // {0:Up, 1:Right, 2: Down, 3:Left}
	public int posizioa;

	public Pertsona(int id, Konponketak konponketak) {
		this.konponketak = konponketak;
		this.id = id;
	}

	// PERTSONA = (iritsi->emanda[emanda:Bool]->if (emanda == 0) then		// Eman gabe
	//														(ordenadoreaEman->atera->PERTSONA)
	//											else
	//														(begiratuEgina[eginda:Bool]->if(eginda == 0) then		// Egin gabe
	//																								(				   askatu->atera->PERTSONA)
	//																					 else
	//																								(ordenadoreaHartu->askatu->atera->PERTSONA))).
	public void run() {
		while (true) {
			try {
				sleep((int) (Math.random() * 1000));				
				konponketak.iritsi(id, emanda);
				iritsi();
				sleep((int) (Math.random() * 1000));
				if(!emanda) {
					sleep((int) (Math.random() * 1000));
					konponketak.ordenadoreaEman(id);
					ordenadoreaEman();
					emanda=true;
					sleep((int) (Math.random() * 1000));
					atera();
					konponketak.atera(id);
				} else {
					boolean eginda = konponketak.begiratuEgina(id);
					if(!eginda) {
						sleep((int) (Math.random() * 1000));
						konponketak.askatu(id);
						sleep((int) (Math.random() * 1000));
						atera();
						konponketak.atera(id);
					} else {
						sleep((int) (Math.random() * 1000));
						ordenadoreaHartu();
						konponketak.ordenadoreaHartu(id);
						emanda = false;
						sleep((int) (Math.random() * 1000));
						konponketak.askatu(id);
						sleep((int) (Math.random() * 1000));
						atera();
						konponketak.atera(id);
					}
				}
				sleep((int) (Math.random() * 20000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void atera() throws InterruptedException {
		int[] posizioak = PCDendaApp.panel.posizioak;
		posizioak[posizioa-1] = 0;
		switch(posizioa) {
		case 1:
			move = 2;
			geldik = false;
			while(y<500) { 
				y+=abiadura;
				sleep(25);
			}
			geldik = true;
			break;
		case 2:
			move = 3;
			geldik = false;
			while(x>128) {
				x-=abiadura;
				sleep(25);
			}
			move = 2;
			while(y<500) { 
				y+=abiadura;
				sleep(25);
			}
			geldik = true;
			break;
		case 3:
			move = 3;
			geldik = false;
			while(x>128) {
				x-=abiadura;
				sleep(25);
			}
			move = 2;
			while(y<500) { 
				y+=abiadura;
				sleep(25);
			}
			geldik = true;
			break;
		case 4:
			move = 1;
			geldik = false;
			while(x<128) {
				x+=abiadura;
				sleep(25);
			}
			move = 2;
			while(y<500) { 
				y+=abiadura;
				sleep(25);
			}
			geldik = true;
			break;
		case 5:
			move = 1;
			geldik = false;
			while(x<128) {
				x+=abiadura;
				sleep(25);
			}
			move = 2;
			while(y<500) { 
				y+=abiadura;
				sleep(25);
			}
			geldik = true;
			break;
		}
		
	}

	private void iritsi() throws InterruptedException {
		posizioa = lortuPosizioLibrea();
		int[] posizioak = PCDendaApp.panel.posizioak;
		for(int i=0; i<posizioak.length; i++) {
			if(posizioak[i] == 0) {
				posizioak[i] = 1;
				break;
			}
		}
		switch(posizioa) {
		case 1:
			move = 0;
			geldik = false;
			while(y>310) { 
				y-=abiadura;
				sleep(25);
			}
			move = 2;
			geldik = true;
			break;
		case 2:
			move = 0;
			geldik = false;
			while(y>310) { 
				y-=abiadura;
				sleep(25);
			}
			move = 1;
			while(x<170) {
				x+=abiadura;
				sleep(25);
			}
			geldik = true;
			break;
		case 3:
			move = 0;
			geldik = false;
			while(y>310) { 
				y-=abiadura;
				sleep(25);
			}
			move = 1;
			while(x<212) {
				x+=abiadura;
				sleep(25);
			}
			geldik = true;
			break;
		case 4:
			move = 0;
			geldik = false;
			while(y>310) { 
				y-=abiadura;
				sleep(25);
			}
			move = 3;
			while(x>100) {
				x-=abiadura;
				sleep(25);
			}
			geldik = true;
			break;
		case 5:
			move = 0;
			geldik = false;
			while(y>310) { 
				y-=abiadura;
				sleep(25);
			}
			move = 3;
			while(x>60) {
				x-=abiadura;
				sleep(25);
			}
			geldik = true;
			break;
		}
	}

	private void ordenadoreaEman() {
		PCDendaApp.panel.nextComputer = id;
		PCDendaApp.panel.hartzeko = id;
	}
	
	private void ordenadoreaHartu() {
		int[] ordenagailuKonponduak = PCDendaApp.panel.ordenagailuKonponduak;

		// 2 1 0		2 1 0	// 0 1 2        0 1 2
		// 2 3 1 --3--> 0 2 1   // 1 3 2 --3--> 1 2 0
		
		for(int i=1; i<=ordenagailuKonponduak.length; i++) {
			if(ordenagailuKonponduak[i-1] == id) {
				ordenagailuKonponduak[i-1] = 0;
				for(int j=i;j<ordenagailuKonponduak.length;j++) {
					ordenagailuKonponduak[j-1] = ordenagailuKonponduak[j];
					ordenagailuKonponduak[j] = 0;
				}
				break;
			}			
		}
	}
	
	private int lortuPosizioLibrea() {
		int[] posizioak = PCDendaApp.panel.posizioak;
		for(int i=0; i<posizioak.length; i++) {
			if(posizioak[i] == 0) {
				return i+1;
			}
		}
		return -1;
	}
}