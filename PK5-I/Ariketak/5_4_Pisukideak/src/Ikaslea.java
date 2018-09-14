public class Ikaslea extends Thread {
	private Botea botea;
	private int id;
	private Pantaila pantaila;

	public Ikaslea(int id, Botea k, Pantaila p) {
		this.botea = k;
		this.id = id;
		this.pantaila = p;
	}

	// IKASLEA = (erabakiHartuEdoBota[a:Aukera]->
	// if(a==0) then (begiratu[b:TR]->
	// 			if(b>0) then (erabaki[r:1..b]->hartu[r]->IKASLEA)
	//	 		else					(askatu->IKASLEA))
	//	else		  (begiratu[b:TR]->
	// 			if(b<TM) then (erabaki[r:1..TM-b]->sartu[r]->IKASLEA)
	//			else					    (askatu->IKASLEA))).
	public void run() {
		while (true) {
			try {
				double Aukera = Math.random();
				if(Aukera < 0.5) {
					pantaila.margotu(id, "hartzera", -1);
					sleep((int) (Math.random() * 1000));
					int txanponKopurua = botea.begiratu();
					pantaila.margotu(id, "begiratu["+txanponKopurua+"]", txanponKopurua);
					sleep((int) (Math.random() * 1000));
					if(txanponKopurua > 0) {			
						int erabaki = (int)(Math.random() * (txanponKopurua)) +1;
						botea.hartu(id, erabaki);
					} else {
						botea.askatu();
						
					}
					pantaila.margotu(id, "askatu\t", -1);
				} else {
					pantaila.margotu(id, "sartzera", -1);
					sleep((int) (Math.random() * 1000));
					int txanponKopurua = botea.begiratu();
					pantaila.margotu(id, "begiratu["+txanponKopurua+"]", txanponKopurua);
					sleep((int) (Math.random() * 1000));
					int txanponMaximoa = botea.getTxanponMaximoa();
					if(txanponKopurua < txanponMaximoa) {
						int erabaki = (int)(Math.random() * (txanponMaximoa - txanponKopurua)) +1;
						botea.sartu(id, erabaki);
					} else {
						botea.askatu();
						
					}
					pantaila.margotu(id, "askatu\t", -1);
				}			
				sleep((int) (Math.random() * 1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
