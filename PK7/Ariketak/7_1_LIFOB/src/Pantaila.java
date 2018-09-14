import java.io.IOException;

public class Pantaila {
	public static int kopurua;

	public static void hasieratu() throws IOException {
		System.out
				.println("======================================================================================================================================================================");
		for (int i = 0; i < LIFOApp.PROZESU_MAX; i++) {
			System.out.print("Prozesu[" + i + "]\t");
		}
		System.out.print("PILA");
		System.out.println("\t\t\tKontagailua(x)");
		for (int i = 0; i < LIFOApp.PROZESU_MAX; i++) {
			System.out.print("================");
		}
		System.out.print("======================================");
		System.out.println();
	}

	public synchronized static void margotu(int id, String string, String[] array, int kontagailua) {

		for (int i = 1; i < id + 1; i++) {
			System.out.print("\t\t");
		}
		System.out.print(string + "\t\t");
		for (int i = 0; i < LIFOApp.PROZESU_MAX - (id + 1); i++) {
			System.out.print("\t\t");
		}
		printArray(array);
		System.out.print("\t");
		printKontagailua(kontagailua);
		System.out.println();
	}

	public static void printArray(String[] array) {

		System.out.print("|");
		for (String i : array) {
			if (i != null) {
				System.out.print(i);
				System.out.print("|");
			}
			
		}
	}
	
	private static synchronized void printKontagailua(int pk) {
		System.out.print('[');
		for (int i = 0; i < pk; i++) {
			System.out.print('*');
		}
		for (int i = 0; i < LIFOApp.PROZESU_HUSKETA - (pk); i++) {
			System.out.print(' ');
		}
		System.out.print(']');
	}
}