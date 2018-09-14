import java.io.IOException;

public class Pantaila {
	public static int kopurua;

	public static void hasieratu() throws IOException {
		System.out
				.println("========================================================================================");
		System.out.print("Informatikaria\t");
		for (int i = 0; i < PCDendaApp.PERTSONA_KOPURUA; i++) {
			System.out.print("P[" + i + "]\t\t");
		}
		System.out.println("");
		for (int i = 0; i < (PCDendaApp.PERTSONA_KOPURUA + PCDendaApp.ORDENAGAILU_MAX); i++) {
			System.out.print("===========");
		}
		System.out.println();
	}

	public synchronized static void margotu(int id, String string) {

		for (int i = 1; i < id + 1; i++) {
			System.out.print("\t\t");
		}
		String post;
		if(string.length() > 6) {
			post = "\t";
		} else {
			post = "\t\t";
		}
		System.out.print(string + post);
		for (int i = 0; i < (PCDendaApp.PERTSONA_KOPURUA + PCDendaApp.ORDENAGAILU_MAX)
				- (id + 1); i++) {
			System.out.print("\t\t");
		}
		// System.out.println();
	}

	public synchronized static void margotuNL(int id, String string) {

		for (int i = 1; i < id + 1; i++) {
			System.out.print("\t\t");
		}
		System.out.print(string +"\t\t");
		for (int i = 0; i < (PCDendaApp.PERTSONA_KOPURUA + PCDendaApp.ORDENAGAILU_MAX)
				- (id + 1); i++) {
			System.out.print("\t\t");
		}
		System.out.println();
	}
}