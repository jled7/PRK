import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Queue;

public class Konponketak {

	// [pk:PR] Dendan dauden pertsona kopurua
	// [at:PR] Atendituta dagoen edo atenditu beharra duen (begiratzen baldin badago egina dagoen
	// [ok:OR] Ordenadoreak konpontzeko daudenak
	// [oe:OR] Ordenadoreak konponketa egina dutenak
	// [esk:Bool] Eskaera egiten dagoen hala ez
	// [k:Bool] Kanpoan (mostradorean) dagoen hala ez
	// [beg:Bool] Sarraila, bi pertsonak batera begira ez dezaten
	public int pertsonaKopurua = 0;
	public int atendituta = 0;
	public int ordenadoreakKonpontzeko = 0;
	public int ordenadoreakEginak = 0;
	public boolean eskatzen = false;
	public boolean kanpoan = false;
	public boolean begiratzen = false;
	public int ordenadoreMax = PCDendaApp.ORDENAGAILU_MAX;
	public int pertsonaMax = PCDendaApp.PERTSONA_KOPURUA;
	public int[] ordenadoreak = new int[pertsonaMax];
	public Queue<Integer> ordena = new LinkedList<Integer>();

	public Konponketak() {
		for(int i=0; i<ordenadoreak.length; i++) {
			ordenadoreak[i] = 0;
		}
	}

	
	// when (pk-at>=0)							i.begiratu[pk-at][ok]		->KONPONKETAK[ pk ][ at ][ ok ][ oe ][esk][ k ][beg]
	public synchronized int[] begiratu() throws InterruptedException{
		while (!(pertsonaKopurua - atendituta >= 0)) wait();
		int[] begir = new int[3];
		begir[0] = pertsonaKopurua-atendituta;
		begir[1] = ordenadoreakKonpontzeko;
		begir[2] = ordenadoreakEginak;
		
		Pantaila.margotuNL(0, "beg["+ pertsonaKopurua + "][" + ordenadoreakKonpontzeko + "]["  + ordenadoreakEginak + "]");
		PCDendaApp.panel.updateData(pertsonaKopurua, atendituta, ordenadoreakKonpontzeko, ordenadoreakEginak, eskatzen, kanpoan, begiratzen);
		
		notifyAll();
		return begir; 

	}

	//											i.mostradorera				->KONPONKETAK[ pk ][ at ][ ok ][ oe ][esk][ 1 ][beg]
	public synchronized void mostradorera() {
		kanpoan = true;
		
		Pantaila.margotuNL(0, "mostradorera");
		PCDendaApp.panel.updateData(pertsonaKopurua, atendituta, ordenadoreakKonpontzeko, ordenadoreakEginak, eskatzen, kanpoan, begiratzen);
		
		notifyAll();
	}

	// when (esk==1)								i.ordenadoreaJaso			->KONPONKETAK[ pk ][ at ][ok+1][ oe ][esk][ k ][beg]
	public synchronized void ordenadoreaJaso() throws InterruptedException{
		while (!(eskatzen == true)) wait();
		
		ordenadoreakKonpontzeko++;
		
		Pantaila.margotuNL(0, "ordenadoreaJaso");
		PCDendaApp.panel.updateData(pertsonaKopurua, atendituta, ordenadoreakKonpontzeko, ordenadoreakEginak, eskatzen, kanpoan, begiratzen);
		
		notifyAll();
	}

	// 											i.barruraJoan				->KONPONKETAK[ pk ][ at ][ ok ][ oe ][ 0 ][ 0 ][beg]
	public synchronized void barruraJoan() {
		eskatzen = false;
		kanpoan = false;
		
		Pantaila.margotuNL(0, "barruraJoan");
		PCDendaApp.panel.updateData(pertsonaKopurua, atendituta, ordenadoreakKonpontzeko, ordenadoreakEginak, eskatzen, kanpoan, begiratzen);
		
		notifyAll();
	}

	// when (ok > 0 && oe<OK)					i.ordenadoreaKonpondu		->KONPONKETAK[ pk ][ at ][ok-1][oe+1][esk][ k ][beg]
	public synchronized void ordenadoreaKonpondu() throws InterruptedException {
		while(!(ordenadoreakKonpontzeko > 0 && ordenadoreakEginak<ordenadoreMax)) wait();
		
		ordenadoreakKonpontzeko--;
		ordenadoreakEginak++;
		
		int id = ordena.poll();
		ordenadoreak[id-1] = 1;
		
		Pantaila.margotuNL(0, "ordenadoreaKonpondu:"+id);
		PCDendaApp.panel.updateData(pertsonaKopurua, atendituta, ordenadoreakKonpontzeko, ordenadoreakEginak, eskatzen, kanpoan, begiratzen);
		
		notifyAll();
	}

	// when(pk < PK)								p[PID].iritsi[i:Bool]  		->	if (i==0) then	
	//																							KONPONKETAK[pk+1][ at ][ ok ][ oe ][esk][ k ][beg]
	//																				else
	//																							KONPONKETAK[pk+1][at+1][ ok ][ oe ][esk][ k ][beg]
	public synchronized void iritsi(int id, boolean emanda) throws InterruptedException {
		while(!(pertsonaKopurua < pertsonaMax)) wait();
		
		if(emanda) {
			atendituta++;
		}
		pertsonaKopurua++;
		
		Pantaila.margotuNL(id, "iritsi");
		PCDendaApp.panel.updateData(pertsonaKopurua, atendituta, ordenadoreakKonpontzeko, ordenadoreakEginak, eskatzen, kanpoan, begiratzen);
		
		notifyAll();
		
	}

	// when(esk==0 && k==1 && ok<OK)				p[PID].ordenadoreaEman		->KONPONKETAK[ pk ][at+1][ ok ][ oe ][ 1 ][ k ][beg]
	public synchronized void ordenadoreaEman(int id) throws InterruptedException {
		while(!(eskatzen==false && kanpoan==true && ordenadoreakKonpontzeko<ordenadoreMax)) wait();
		
		ordena.add(id);
		
		atendituta++;
		eskatzen=true;
		
		Pantaila.margotuNL(id, "ordenadoreaEman");
		PCDendaApp.panel.updateData(pertsonaKopurua, atendituta, ordenadoreakKonpontzeko, ordenadoreakEginak, eskatzen, kanpoan, begiratzen);
		
		notifyAll();
	}

	// 											p[PID].atera				->KONPONKETAK[pk-1][at-1][ ok ][ oe ][esk][ k ][beg]
	public synchronized void atera(int id) throws InterruptedException {
		pertsonaKopurua--;
		atendituta--;
		
		Pantaila.margotuNL(id, "atera");
		PCDendaApp.panel.updateData(pertsonaKopurua, atendituta, ordenadoreakKonpontzeko, ordenadoreakEginak, eskatzen, kanpoan, begiratzen);
		
		notifyAll();
	}


	// when(beg==0)								p[PID].begiratuEgina[oe>0]	->KONPONKETAK[ pk ][ at ][ ok ][ oe ][esk][ k ][ 1 ]
	public synchronized boolean begiratuEgina(int id) throws InterruptedException {
		while(!(begiratzen==false)) wait();
		
		boolean egina = ordenadoreak[id-1] == 1;
		
		begiratzen = true;
		
		Pantaila.margotuNL(id, "begiratuEgina:" + (egina? "Bai": "Ez"));
		PCDendaApp.panel.updateData(pertsonaKopurua, atendituta, ordenadoreakKonpontzeko, ordenadoreakEginak, eskatzen, kanpoan, begiratzen);
		
		notifyAll();
		return egina;
	}

	// 											p[PID].askatu				->KONPONKETAK[ pk ][ at ][ ok ][ oe ][esk][ k ][ 0 ]
	public synchronized void askatu(int id) {
		begiratzen = false;
		
		Pantaila.margotuNL(id, "askatu");
		PCDendaApp.panel.updateData(pertsonaKopurua, atendituta, ordenadoreakKonpontzeko, ordenadoreakEginak, eskatzen, kanpoan, begiratzen);
		
		notifyAll();
	}

	// when(oe>0)								p[PID].ordenadoreaHartu		->KONPONKETAK[ pk ][ at ][ ok ][oe-1][esk][ k ][beg]
	public synchronized void ordenadoreaHartu(int id) throws InterruptedException {
		while(!(ordenadoreakEginak > 0)) wait();
		
		ordenadoreak[id-1] = 0;
		ordenadoreakEginak--;
		
		Pantaila.margotuNL(id, "ordenadoreaHartu");
		PCDendaApp.panel.updateData(pertsonaKopurua, atendituta, ordenadoreakKonpontzeko, ordenadoreakEginak, eskatzen, kanpoan, begiratzen);
		
		notifyAll();
	}
}