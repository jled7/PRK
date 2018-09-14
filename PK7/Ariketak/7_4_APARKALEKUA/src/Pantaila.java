import java.io.IOException;

public class Pantaila {
	public static int kopurua;

	public static void hasieratu() throws IOException {
		System.out
				.println("=================================================================================================================================================================================");
		for (int i = 0; i < AparkalekuaApp.KOTXE_KOPURUA; i++) {
			System.out.print("Kotxe[" + i + "]\t");
		}
		for (int i = 0; i < AparkalekuaApp.MOTOEN_KOPURUA; i++) {
			System.out.print("Motoa[" + i + "]\t");
		}
		System.out.println("  Plazak     Pasabidea\tPasabidean\tKotxeak");
		System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tAparkatzeko\tItxaroten");
		for (int i = 0; i < (AparkalekuaApp.KOTXE_KOPURUA + AparkalekuaApp.MOTOEN_KOPURUA); i++) {
			System.out.print("================");
		}
		System.out.print("=================================================");
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
		for (int i = 0; i < (AparkalekuaApp.KOTXE_KOPURUA + AparkalekuaApp.MOTOEN_KOPURUA)
				- (id + 1); i++) {
			System.out.print("\t\t");
		}
		// System.out.println();
	}

	public static void margotuDatuak(int id, int plazak, int pasabidean, 
			int pasabideanSartzeko, int kotxeakItxaroten) {

		printMax(plazak, AparkalekuaApp.APARKALEKUEN_MAX);

		System.out.print('\t');
		
		printMax(pasabidean, 2);
		
		System.out.print("\t   ");
		
		printMax(pasabideanSartzeko, 2);
		
		System.out.print('\t');
		System.out.print("\t ");
		
		printMax(kotxeakItxaroten, AparkalekuaApp.KOTXE_KOPURUA);

		System.out.println();
	}

	private static synchronized void printMax(int pk, int max) {
		System.out.print('[');
		for (int i = 0; i < pk; i++) {
			System.out.print('*');
		}
		for (int i = 0; i < max - (pk); i++) {
			System.out.print(' ');
		}
		System.out.print(']');
	}
	
	public synchronized static void margotuNL(int id, String string) {

		for (int i = 1; i < id + 1; i++) {
			System.out.print("\t\t");
		}
		System.out.print(string +"\t\t");
		for (int i = 0; i < (AparkalekuaApp.KOTXE_KOPURUA + AparkalekuaApp.MOTOEN_KOPURUA)
				- (id + 1); i++) {
			System.out.print("\t\t");
		}
		System.out.println();
	}
}