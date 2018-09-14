public class Pantaila {

	private int x1 = 0, x2 = 0;
	
	public void margotu(int x, String ikurra) {
		garbitu();
		if (ikurra == "*") {
			x1 = x;
		} else {
			x2 = x;
		}
		for (int i = 0; i < x1; i++) {
			System.out.print(' ');
		}
		System.out.println("*");
		for (int j = 0; j < x2; j++) {
			System.out.print(' ');
		}
		System.out.println("+");

	}

	public static void garbitu() {
		for (int i = 0; i < 25; i++) {
			System.out.println(" ");
		}
	}
}
