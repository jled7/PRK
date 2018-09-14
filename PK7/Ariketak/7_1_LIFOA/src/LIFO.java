
public class LIFO {
	public int ilararenEgoera = 0;
	public int N = LIFOApp.ILARA_TAMAINA;
	public String[] array = new String[N];
	
	public LIFO() {
		for (int i = 0;i < N;i++) {
			array[i] = "  ";
		}
	}
	
	//  when(i<PT) sartu[i]->LIFO[i+1]
	synchronized int sartu(int id) throws InterruptedException {
		while(!(ilararenEgoera<N)) wait();
		
		int sartutakoa = ilararenEgoera;
		array[sartutakoa] = "P"+id;
		Pantaila.margotu(id, "sartu:"+sartutakoa, array);
		ilararenEgoera++;
		
		notifyAll();

		return sartutakoa;
	}
	//  			atera[i-1]->LIFO[i-1]
	synchronized void atera(int id, int sartuta) throws InterruptedException {
		while (!(sartuta == ilararenEgoera-1)) wait();
		array[sartuta] = "  ";
		Pantaila.margotu(id, "atera:"+sartuta, array);
		ilararenEgoera--;
		
		notifyAll();

	}
}