
public class Maiordomoa {
	private int f = 0;
	private int MAX = FilosofoApp.FilosoMax;
	private Pantaila pantaila;
	
	public Maiordomoa (Pantaila p) {
		this.pantaila = p;
	}
	
	//when (f<MAX) eseri  -> MAIORDOMO[f+1]
	public synchronized void eseri(String tartea) throws InterruptedException{
		while(!(f<MAX)) wait();
		f++;
		pantaila.eseri(tartea, f);
		notifyAll();
	}
	
	//when (f > 0)	altxatu-> MAIORDOMO[f-1]
	public synchronized void altxatu(String tartea) throws InterruptedException{
		while(!(f > 0)) wait();
		f--;
		pantaila.altxatu(tartea, f);
		notifyAll();
	}

}
