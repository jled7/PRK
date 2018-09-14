
public class LIFO {
	public int ilararenEgoera = 0;
	public int N = LIFOApp.ILARA_TAMAINA;
	public String[] array = new String[N];
	public int MAX = LIFOApp.PROZESU_HUSKETA;
	public int x = 0;
	
	public LIFO() {
		for (int i = 0;i < N;i++) {
			array[i] = "  ";
		}
	}
	
	//  when(i<PT && x<MAX) sartu[i]  -> LIFO[i+1][x+1]
	synchronized int sartu(int id) throws InterruptedException {
		while(!(ilararenEgoera<N && x<MAX)) wait();
		
		int sartutakoa = ilararenEgoera;
		array[sartutakoa] = "P"+id;
		Pantaila.margotu(id, "sartu:"+sartutakoa, array, x);
		ilararenEgoera++;
		x++;
		
		notifyAll();

		return sartutakoa;
	}
	//  when(i>0)           atera[i-1]->if(i==1) then LIFO[i-1][ 0 ]
	//											 else LIFO[i-1][ x ]
	synchronized void atera(int id, int sartuta) throws InterruptedException {
		while (!(sartuta == ilararenEgoera-1)) wait();
		array[sartuta] = "  ";
		Pantaila.margotu(id, "atera:"+sartuta, array, x);
		if(ilararenEgoera==1) {
			x = 0;
		}
		ilararenEgoera--;
		
		notifyAll();

	}
}
