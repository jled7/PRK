public class Oiloa extends Thread {
	public int id;
	public Oilotegia oilotegia;

	public Oiloa(int id, Oilotegia oilotegia) {
		this.oilotegia = oilotegia;
		this.id = id;
	}

	// OILOA   = (sartu->begiratu[a:AR] -> if(a<AK) then (jarri->askatu->atera->OILOA)
	//												else (askatu->atera->OILOA)).
	public void run() {
		while (true) {
			try {
				
				sleep((int) (Math.random() * 1000));
				oilotegia.sartuO(id);
				sleep((int) (Math.random() * 1000));
				int begiratua = oilotegia.begiratuO(id);
				sleep((int) (Math.random() * 1000));
					if(begiratua < OilotegiaApp.ARRAUTZ_KOPURUA_MAX) {
					oilotegia.jarri(id);
					sleep((int) (Math.random() * 1000));
					oilotegia.askatu(id);
					sleep((int) (Math.random() * 1000));
					oilotegia.ateraO(id);
				} else {
					oilotegia.askatu(id);
					sleep((int) (Math.random() * 1000));
					oilotegia.ateraO(id);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}