
public class Pantaila {

	public synchronized void erakutsi(char[] buf) {
		System.out.print("\t|");
		for (char c : buf) {
			System.out.print(c);
			System.out.print("|");
		}
		System.out.println();
	}

	public void idatzi(String string) {
		System.out.println(string);
		
	}
}
