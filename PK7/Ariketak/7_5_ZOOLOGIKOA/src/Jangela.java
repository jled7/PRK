
public class Jangela {

	public int haragiKopurua = 0;
	public int haragiKopuruaMax = ZoologikoaApp.HARAGI_KOPURUA_MAX;
	public int lehoiKopurua = 0;
	public boolean ateaItxita = false;
	public boolean block = false;
	
	public Jangela() {

	}
	
	//	when(a==0 && h>0)	 lehoia[LID].sartu	 	->JANGELA[l+1][ h ][ a ][ b ]
	public synchronized void sartuL(int id) throws InterruptedException {
		while(!(haragiKopurua > 0 && ateaItxita == false)) wait();
		
		lehoiKopurua++;
		
		Pantaila.margotu(id, "sartu");
		Pantaila.margotuDatuak(id, haragiKopurua, lehoiKopurua,ateaItxita,  block);
		
		notifyAll();
	}

	
	//	when(b==0)			 lehoia[LID].begiratu[h]->JANGELA[ l ][ h ][ a ][ 1 ]
	public synchronized int begiratu(int id) throws InterruptedException {
		while(!(block == false)) wait();
		
		block = true;
		Pantaila.margotu(id, "begi:" + haragiKopurua);
		Pantaila.margotuDatuak(id, haragiKopurua, lehoiKopurua,ateaItxita,  block);
		
		notifyAll();
		return haragiKopurua;
	}
	
	//					 lehoia[LID].jan	 	->JANGELA[ l ][h-1][ a ][ b ]
	public synchronized void jan(int id) throws InterruptedException {
		
		haragiKopurua--;
		Pantaila.margotu(id, "jan");
		Pantaila.margotuDatuak(id, haragiKopurua, lehoiKopurua,ateaItxita,  block);

		notifyAll();
	}
	
	//					 lehoia[LID].askatu		->JANGELA[ l ][ h ][ a ][ 0 ]
	public synchronized void askatu(int id) throws InterruptedException {
		
		block = false;
		Pantaila.margotu(id, "askatu");	
		Pantaila.margotuDatuak(id, haragiKopurua, lehoiKopurua,ateaItxita,  block);

		notifyAll();
	}
	
	//					 lehoia[LID].atera	 	->JANGELA[l-1][ h ][ a ][ b ]
	public synchronized void ateraL(int id) throws InterruptedException {
		
		lehoiKopurua--;
		Pantaila.margotu(id, "atera");		
		Pantaila.margotuDatuak(id, haragiKopurua, lehoiKopurua,ateaItxita,  block);

		notifyAll();
	}
	
	//	when (h==0 && l==0) langilea.sartu		 	->JANGELA[ 0 ][ 0 ][ 1 ][ b ]
	public synchronized void sartu(int id) throws InterruptedException {
		while(!(haragiKopurua == 0 && lehoiKopurua == 0)) wait();
		
		haragiKopurua = 0;
		lehoiKopurua = 0;
		ateaItxita = true;
		
		Pantaila.margotu(id, "sartu");
		Pantaila.margotuDatuak(id, haragiKopurua, lehoiKopurua,ateaItxita,  block);
		
		notifyAll();
	}
	
	
	//					 langilea.janariaBota	->JANGELA[ 0 ][ 10][ 1 ][ b ]
	public synchronized void janariaBota(int id) throws InterruptedException {
		
		haragiKopurua = haragiKopuruaMax;
		Pantaila.margotu(id, "bota");	
		Pantaila.margotuDatuak(id, haragiKopurua, lehoiKopurua,ateaItxita,  block);

		notifyAll();
	}

	//					 langilea.atera		 	->JANGELA[ 0 ][ h ][ 0 ][ b ]
	public synchronized void atera(int id) throws InterruptedException {
		
		ateaItxita = false;
		Pantaila.margotu(id, "atera");
		Pantaila.margotuDatuak(id, haragiKopurua, lehoiKopurua,ateaItxita,  block);

		notifyAll();
	}
}