
public class Sukaldaria extends Thread {
	Lapikoa lapikoa;
	Pantaila pantaila;
	int id;
	int pusketak;
	
	public Sukaldaria(int id, Lapikoa k, Pantaila p, int pusketak) {
		this.lapikoa = k;
		this.pantaila = p;
		this.id = id;
		this.pusketak = pusketak;
	}

	// SUKALDARIA	= (begiratu[m:MR][h:HR][l:LR] -> 
	//										moztuEdoLapikoanSartu[x:Aukera]->
	//								if(x==0) then	// Moztu
	//										if(HT>=h+Puska && m>0) then
	//													(akatu->botaHozkailura->SUKALDARIA)
	//										else
	//													(askatu->SUKALDARIA)
	//								else
	//										if (h>0 && l<LT) then
	//												if (h < LT -l) then
	//													(random[r:1..h] 	->botaLapikora[r]->SUKALDARIA)
	//												else
	//													(random[r:1..LT-l]	->botaLapikora[r]->SUKALDARIA) 
	//										else
	//													(askatu->SUKALDARIA)).

	public void run() {
		while(true) {
			try {
				sleep((int) (Math.random() * 1000));
				int[] puskaKopurua = lapikoa.begiratuSukaldatzeko(id);
				int m = puskaKopurua[0];
				int h = puskaKopurua[1];
				int l = puskaKopurua[2];
				
				double Aukera = Math.random();
				sleep((int) (Math.random() * 1000));
				if(Aukera < 0.5) {	// Moztu
					if(BasatienFestaApp.HOZKAILUAREN_TAMAINA >= h+pusketak && m > 0) {
						pantaila.margotu(id, "akatu", -1, -1, -1);
						sleep((int) (Math.random() * 1000));
						lapikoa.botaHozkailura(id);
					} else {
						lapikoa.askatu(id);
					}
				} else {
					sleep((int) (Math.random() * 1000));
					pantaila.margotu(id, "lapikoratu", -1, -1, -1);
					int puskaMaximoa = BasatienFestaApp.PUSKA_MAXIMOAK;
					if(h > 0 && l < puskaMaximoa) {
						sleep((int) (Math.random() * 1000));
						if(h < puskaMaximoa - l) {
							int erabaki = (int)(Math.random() * h) +1;
							pantaila.margotu(id, "zenbat[" + erabaki + "]", -1, -1, -1);
							lapikoa.botaLapikora(id, erabaki);
						} else {
							int erabaki = (int)(Math.random() * (puskaMaximoa - l)) +1;
							pantaila.margotu(id, "zenbat[" + erabaki + "]", -1, -1, -1);
							lapikoa.botaLapikora(id, erabaki);
						}
					} else {
						lapikoa.askatu(id);
					}
				}
				sleep((int) (Math.random() * 1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
