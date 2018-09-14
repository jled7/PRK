
public class Kontadorea {
	
	private int kont = 0;
	
	public int gehitu() {
		kont++;
		return kont;
	}

	public void show() {
		System.out.println("\t\t"+kont);
		
	}
	
}
