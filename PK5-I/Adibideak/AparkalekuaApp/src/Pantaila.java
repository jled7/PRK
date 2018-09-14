
public class Pantaila {
	private int plazak;
	public Pantaila(int p) {
	plazak=p;
	}
	synchronized public void sartu(int k) {
	int kop=k;
	System.out.print("sartu\t\t");
	margotuKotxeak(kop);
	}
	synchronized public void irten(int k) {
	int kop=k;
	System.out.print("\tirten\t");
	margotuKotxeak(kop);
	}
	synchronized public void margotuKotxeak(int k) {
	System.out.print("[");
	for (int i=0; i<k;
	++i) { System.out.print("*"); }
	for (int i=k; i<plazak; ++i) { System.out.print(" "); }
	System.out.println("]");
	}
}
