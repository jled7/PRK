public class Josemi extends Thread {
	public int id;
	public Oilotegia oilotegia;

	public Josemi(int id, Oilotegia oilotegia) {
		this.oilotegia = oilotegia;
		this.id = id;
	}

	// JOSEMI 	= (sartu->begiratu[a:AR] ->if (a>=2) then (hartu->atera->JOSEMI)
	//												 else (atera->JOSEMI)).
	public void run() {
		while (true) {
			try {
				sleep((int) (Math.random() * 1000));
				oilotegia.sartuJ(id);
				sleep((int) (Math.random() * 1000));
				int begiratua = oilotegia.begiratuJ(id);
				sleep((int) (Math.random() * 1000));
				if(begiratua >= 2) {
					oilotegia.hartu(id);
					sleep((int) (Math.random() * 1000));
					oilotegia.ateraJ(id);
				} else {
					oilotegia.ateraJ(id);	
				}				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}