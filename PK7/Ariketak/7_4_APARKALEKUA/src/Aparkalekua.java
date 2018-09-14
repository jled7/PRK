public class Aparkalekua {

	public int plazak = 0;
	public int pasabidean = 0;
	public int pasabideanSartzeko = 0;
	public int kotxeakItxaroten = 0;
	public int AparkalekuMax = AparkalekuaApp.APARKALEKUEN_MAX;

	public Aparkalekua() {

	}

	// kotxe[KID].iritsi ->APARKALEKUA[ pl ][ pa ][ ps ][ki+1]
	public synchronized void iritsiK(int id) {
		kotxeakItxaroten++;

		Pantaila.margotu(id, "iritsi");
		Pantaila.margotuDatuak(id, plazak, pasabidean, pasabideanSartzeko,
				kotxeakItxaroten);

		notifyAll();
	}

	// when (pa==0 && pl+3<=AK) kotxe[KID].pasabideraSartuKanpotik ->APARKALEKUA[ pl ][ 2 ][ ps ][ki-1]
	public synchronized void pasabideraSartuKanpotikK(int id)
			throws InterruptedException {
		while (!(pasabidean == 0 && plazak + 3 <= AparkalekuMax))
			wait();

		pasabidean = 2;
		kotxeakItxaroten--;

		Pantaila.margotu(id, "paKanpotik");
		Pantaila.margotuDatuak(id, plazak, pasabidean, pasabideanSartzeko,
				kotxeakItxaroten);

		notifyAll();
	}

	// when (pl<=AK-3) kotxe[KID].aparkatu ->APARKALEKUA[pl+3][pa-2][ ps ][ ki ]
	public synchronized void aparkatuK(int id) throws InterruptedException {
		while (!(plazak <= AparkalekuMax - 3))
			wait();

		plazak += 3;
		pasabidean -= 2;

		Pantaila.margotu(id, "aparkatu");
		Pantaila.margotuDatuak(id, plazak, pasabidean, pasabideanSartzeko,
				kotxeakItxaroten);

		notifyAll();
	}

	// when (pa==0) kotxe[KID].pasabideraSartuBarrutik ->APARKALEKUA[pl-3][ 2 ][ ps ][ ki ]
	public synchronized void pasabideraSartuBarrutikK(int id)
			throws InterruptedException {
		while (!(pasabidean == 0))
			wait();

		plazak -= 3;
		pasabidean = 2;

		Pantaila.margotu(id, "paBarrutik");
		Pantaila.margotuDatuak(id, plazak, pasabidean, pasabideanSartzeko,
				kotxeakItxaroten);

		notifyAll();
	}
	
	// 									kotxe[KID].joan					 	->APARKALEKUA[ pl ][pa-2][ ps ][ ki ]
	public synchronized void joanK(int id) throws InterruptedException{
		pasabidean -= 2;
		
		Pantaila.margotu(id, "joan");
		Pantaila.margotuDatuak(id, plazak, pasabidean, pasabideanSartzeko,
				kotxeakItxaroten);

		notifyAll();
		
	}

	// when (pa<2 && pl+ps<AK && ki==0)	motoa[MID].pasabideraSartuKanpotik 	->APARKALEKUA[ pl ][pa+1][ps+1][ ki ]
	public synchronized void pasabideraSartuKanpotikM(int id)
			throws InterruptedException {
		while (!(pasabidean < 2 && plazak+pasabideanSartzeko< AparkalekuMax && kotxeakItxaroten == 0))
			wait();

		pasabidean += 1;
		pasabideanSartzeko += 1;

		Pantaila.margotu(id, "paKanpotik");
		Pantaila.margotuDatuak(id, plazak, pasabidean, pasabideanSartzeko,
				kotxeakItxaroten);

		notifyAll();
	}

	// when (pl<=AK-1)					motoa[MID].aparkatu		   			->APARKALEKUA[pl+1][pa-1][ps-1][ ki ]
	public synchronized void aparkatuM(int id) throws InterruptedException {
		while (!(plazak <= AparkalekuMax - 1))
			wait();

		plazak += 1;
		pasabidean -= 1;
		pasabideanSartzeko -= 1;

		Pantaila.margotu(id, "aparkatu");
		Pantaila.margotuDatuak(id, plazak, pasabidean, pasabideanSartzeko,
				kotxeakItxaroten);

		notifyAll();
	}

	// when (pa<2)						motoa[MID].pasabideraSartuBarrutik 	->APARKALEKUA[pl-1][pa+1][ ps ][ ki ]
	public synchronized void pasabideraSartuBarrutikM(int id)
			throws InterruptedException {
		while (!(pasabidean < 2))
			wait();

		plazak -= 1;
		pasabidean += 1;

		Pantaila.margotu(id, "paBarrutik");
		Pantaila.margotuDatuak(id, plazak, pasabidean, pasabideanSartzeko,
				kotxeakItxaroten);

		notifyAll();
	}
	
	//									motoa[MID].joan						->APARKALEKUA[ pl ][pa-1][ ps ][ ki ]
	public synchronized void joanM(int id) throws InterruptedException{
		pasabidean -= 1;
		
		Pantaila.margotu(id, "joan");
		Pantaila.margotuDatuak(id, plazak, pasabidean, pasabideanSartzeko,
				kotxeakItxaroten);

		notifyAll();
		
	}


}