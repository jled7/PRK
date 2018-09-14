import java.io.IOException;

public class Pantaila {
	public static int kopurua;

	public static void hasieratu(int[] array) throws IOException {
		System.out
				.println("=====================================================================================================");
		for (int i = 0; i < MaximoaApp.PROZESU_MAX; i++) {
			System.out.print("Prozesu[" + i + "]\t");
		}
		System.out.println("\t\tARRAY");
		for (int i = 0; i < MaximoaApp.PROZESU_MAX; i++) {
			System.out.print("================");
		}

		System.out.print("=====================");
		System.out.println();
		System.out.print("\t\t\t\t\t\t\t\t\t\t\t");
		printArray(array);
	}

	public synchronized static void margotu(int id, String string, int[] array) {

		for (int i = 1; i < id + 1; i++) {
			System.out.print("\t\t");
		}
		System.out.print(string + "\t\t");
		for (int i = 0; i < MaximoaApp.PROZESU_MAX - (id + 1); i++) {
			System.out.print("\t\t");

		}
		printArray(array);

	}

	public static void printArray(int[] array) {

		// System.out.print("\t\t\t\t\t\t\t\t\t\t");

		System.out.print("|");
		for (int i : array) {
			if (i != -1) {
				System.out.print(i);
			} else {
				System.out.print(" ");
			}
			System.out.print("|");
		}
		System.out.println();
	}
}
