
public class Atea extends Thread {

	private Kontadorea k;
	private int id;
	private int kont = 0;
	
	public Atea(int id, Kontadorea k) {
		this.k = k;
		this.id = id;
	}
	
	public void sartu() {
		kont++;
		k.gehitu();
	}
	
	public void run() {
		while(true) {
			try {
				sleep((int) (Math.random() * 1000));
			} catch(InterruptedException ex){}
			sartu();
			if(id>1)
				System.out.print("\t");
			System.out.println(id + ">" + kont);
			k.show();
		}
	}
	
}
