import java.io.IOException;

public class Pantaila {
	public static int kopurua;

	public static void hasieratu() throws IOException {
		System.out
				.println("================================================================================================================================================");
		for (int i = 0; i < LIFOApp.PROZESU_MAX; i++) {
			System.out.print("Prozesu[" + i + "]\t");
		}
		System.out.println("PILA");
		for (int i = 0; i < LIFOApp.PROZESU_MAX; i++) {
			System.out.print("================");
		}
		System.out.print("================");
		System.out.println();
	}

	public synchronized static void margotu(int id, String string, String[] array) {

		for (int i = 1; i < id + 1; i++) {
			System.out.print("\t\t");
		}
		System.out.print(string + "\t\t");
		for (int i = 0; i < LIFOApp.PROZESU_MAX - (id + 1); i++) {
			System.out.print("\t\t");
		}
		printArray(array);
	}

	public static void printArray(String[] array) {

		System.out.print("|");
		for (String i : array) {
			if (i != null) {
				System.out.print(i);
				System.out.print("|");
			}
			
		}
		System.out.println();
	}
}