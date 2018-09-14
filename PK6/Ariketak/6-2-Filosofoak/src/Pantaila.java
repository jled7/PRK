
public class Pantaila {
	private int MAX = FilosofoApp.FilosoMax;
	
	public synchronized void eseri(String tartea, int zenbatDira) {
		System.out.println(tartea + " eseri(" + zenbatDira +")");
		printEseritakoak(zenbatDira);
	}
	
	public synchronized void altxatu(String tartea, int zenbatDira) {
		System.out.println(tartea + " altxatu");
		printEseritakoak(zenbatDira);
	}
	
	public synchronized void printEseritakoak(int f) {
		System.out.print("\t\t\t\t\t\t\t\t\t\t[");
		for(int j=0;j<f; j++) {
			System.out.print("*");
		}
		for(int i=0;i<(MAX-f);i++) {
			System.out.print(" ");
		}
		System.out.println("]");
	}
}
