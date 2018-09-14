
public class Oilotegia {

	public int arrautzaKopurua = 0;
	public int oiloKopurua = 0;
	public boolean josemiBarruan = false;
	public boolean block = false;
	public int kontagailua = 0;
	public int kontagailuMax = OilotegiaApp.KONTAGAILUA;
	
	public Oilotegia() {

	}
	
	//	when (j==0 && k<KontM)	oilo[OID].sartu		 ->OILOTEGIA[ a ][o+1][ j ][ b ][k+1]
	public synchronized void sartuO(int id) throws InterruptedException {
		while(!(josemiBarruan == false && kontagailua < kontagailuMax)) wait();
		
		oiloKopurua++;
		kontagailua++;
		
		Pantaila.margotu(id, "sartu");
		Pantaila.margotuDatuak(id, arrautzaKopurua, oiloKopurua, josemiBarruan, block, kontagailua);
		
		notifyAll();
	}

	
	//	when (b==0)			oilo[OID].begiratu[a]->OILOTEGIA[ a ][ o ][ j ][ 1 ][ k ]
	public synchronized int begiratuO(int id) throws InterruptedException {
		while(!(block == false)) wait();
		
		block = true;
		Pantaila.margotu(id, "begir:" + arrautzaKopurua);
		Pantaila.margotuDatuak(id, arrautzaKopurua, oiloKopurua, josemiBarruan, block, kontagailua);
		
		notifyAll();
		return arrautzaKopurua;
	}
	
	//							oilo[OID].jarri		 ->OILOTEGIA[a+1][ o ][ j ][ b ][ k ]
	public synchronized void jarri(int id) throws InterruptedException {
		
		arrautzaKopurua++;
		Pantaila.margotu(id, "jarri");
		Pantaila.margotuDatuak(id, arrautzaKopurua, oiloKopurua, josemiBarruan, block, kontagailua);

		notifyAll();
	}
	
	//							oilo[OID].askatu 	 ->OILOTEGIA[ a ][ o ][ j ][ 0 ][ k ]
	public synchronized void askatu(int id) throws InterruptedException {
		
		block = false;
		Pantaila.margotu(id, "askatu");	
		Pantaila.margotuDatuak(id, arrautzaKopurua, oiloKopurua, josemiBarruan, block, kontagailua);

		notifyAll();
	}
	
	//							oilo[OID].atera		 ->OILOTEGIA[ a ][o-1][ j ][ b ][ k ]
	public synchronized void ateraO(int id) throws InterruptedException {
		
		oiloKopurua--;
		Pantaila.margotu(id, "atera");		
		Pantaila.margotuDatuak(id, arrautzaKopurua, oiloKopurua, josemiBarruan, block, kontagailua);

		notifyAll();
	}
	
	//	when(j==0 && o==0)		josemi.sartu		 ->OILOTEGIA[ a ][ o ][ 1 ][ b ][ 0 ]
	public synchronized void sartuJ(int id) throws InterruptedException {
		while(!(josemiBarruan == false && oiloKopurua == 0)) wait();
		
		josemiBarruan = true;
		kontagailua = 0;
		
		Pantaila.margotu(id, "sartu");
		Pantaila.margotuDatuak(id, arrautzaKopurua, oiloKopurua, josemiBarruan, block, kontagailua);
		
		notifyAll();
	}

	//							josemi.begiratu[a]	 ->OILOTEGIA[ a ][ o ][ 1 ][ b ][ k ]
	public synchronized int begiratuJ(int id) throws InterruptedException {
		
		Pantaila.margotu(id, "begir:" + arrautzaKopurua);
		Pantaila.margotuDatuak(id, arrautzaKopurua, oiloKopurua, josemiBarruan, block, kontagailua);
		
		return arrautzaKopurua;
	}
	
	
	//							josemi.hartu		 ->OILOTEGIA[a-2][ o ][ 1 ][ b ][ k ]
	public synchronized void hartu(int id) throws InterruptedException {
		
		arrautzaKopurua -= 2;
		Pantaila.margotu(id, "hartu");	
		Pantaila.margotuDatuak(id, arrautzaKopurua, oiloKopurua, josemiBarruan, block, kontagailua);

		notifyAll();
	}

	//							josemi.atera		 ->OILOTEGIA[ a ][ o ][ 0 ][ b ][ k ]
	public synchronized void ateraJ(int id) throws InterruptedException {
		
		josemiBarruan = false;
		Pantaila.margotu(id, "atera");
		Pantaila.margotuDatuak(id, arrautzaKopurua, oiloKopurua, josemiBarruan, block, kontagailua);

		notifyAll();
	}
}