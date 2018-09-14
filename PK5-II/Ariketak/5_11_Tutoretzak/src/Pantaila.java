import java.io.IOException;

public class Pantaila {
	public static int kopurua;

	public static void hasieratu() throws IOException {
		System.out
				.println("============================================================================================================================");
		for (int i = 0; i < TutoretzaApp.IKASLE_KOPURUA; i++) {
			System.out.print("Ikasle[" + i + "]\t");
		}
		System.out.println("Irakaslea\tIkasleSartuta\tGalderaEginda\tGalderaErantzunda");
		for (int i = 0; i < TutoretzaApp.IKASLE_KOPURUA; i++) {
			System.out.print("=================");
		}
		System.out.print("=========================================================================");
		System.out.println();
	}

	public synchronized static void margotu(int id, String string) {
		if(id < 0) {
			for (int i = 0; i < TutoretzaApp.IKASLE_KOPURUA; i++) {
				System.out.print("\t\t");
			}
		}
		for (int i = 1; i < id + 1; i++) {
			System.out.print("\t\t");
		}
		System.out.print(string + "\t\t");
		for (int i = 0; i < TutoretzaApp.IKASLE_KOPURUA - (id + 1); i++) {
			System.out.print("\t\t");
		}
		System.out.println();
	}
}