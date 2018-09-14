public class FIFO {
	public int sartutakoProzesuak = 0;
	public int ateratakoProzesuak = 0;
	public int ilararenEgoera = 0;
	public int PT = FIFOApp.POSIZIO_MAX;
	public String[] array = new String[PT];
	
	public FIFO() {
		for (int i = 0;i < PT;i++) {
			array[i] = "  ";
		}
	}
	
	//  when(i<PT) sartu[s]->FIFO[i+1][     a    ][(s+1)%PT]
	synchronized int sartu(int id) throws InterruptedException {
		while(!(ilararenEgoera<PT)) wait();
		
		int sartutakoa = sartutakoProzesuak;
		array[sartutakoa] = "P"+id;
		Pantaila.margotu(id, "sartu:"+sartutakoa, array);
		ilararenEgoera++;
		sartutakoProzesuak =  (sartutakoProzesuak + 1) % PT;
		
		notifyAll();

		return sartutakoa;
	}
	
	//  when(i>0)  atera[a]->FIFO[i-1][(a+1) % PT][   s    ]
	synchronized void atera(int id, int sartuta) throws InterruptedException {
		while(!(ilararenEgoera>0 && ateratakoProzesuak==sartuta)) wait();
	
		array[sartuta] = "  ";
		Pantaila.margotu(id, "atera:"+sartuta, array);
		ilararenEgoera--;
		ateratakoProzesuak =  (ateratakoProzesuak + 1) % PT;
		
		notifyAll();

	}
	
}