public class Pertsona extends Thread {
	public int id;
	public Konponketak konponketak;
	public boolean emanda = false;

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
				sleep((int) (Math.random() * 1000));
				if(!emanda) {
					sleep((int) (Math.random() * 1000));
					konponketak.ordenadoreaEman(id);
					emanda=true;
					sleep((int) (Math.random() * 1000));
					konponketak.atera(id);
				} else {
					boolean eginda = konponketak.begiratuEgina(id);
					if(!eginda) {
						sleep((int) (Math.random() * 1000));
						konponketak.askatu(id);
						sleep((int) (Math.random() * 1000));
						konponketak.atera(id);
					} else {
						sleep((int) (Math.random() * 1000));
						konponketak.ordenadoreaHartu(id);
						emanda = false;
						sleep((int) (Math.random() * 1000));
						konponketak.askatu(id);
						sleep((int) (Math.random() * 1000));
						konponketak.atera(id);
					}
				}
				sleep((int) (Math.random() * 20000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}