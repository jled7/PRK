import java.io.IOException;

public class Pantaila {
	public static int kopurua;

	public static void hasieratu() throws IOException {
		System.out
				.println("====================================================================================================================");
			System.out.print("Langilea\t");
		for (int i = 0; i < ZoologikoaApp.LEHOI_KOPURUA; i++) {
			System.out.print("Lehoi[" + i + "]\t");
		}
		System.out.println("lehoi\tharagi\t\tatea\tbegiratzen");
		for (int i = 0; i < (ZoologikoaApp.LEHOI_KOPURUA + ZoologikoaApp.LEHOI_KOPURUA); i++) {
			System.out.print("================");
		}
		System.out.print("====================");
		System.out.println();
	}

	public synchronized static void margotu(int id, String string) {

		for (int i = 1; i < id + 1; i++) {
			System.out.print("\t\t");
		}
		System.out.print(string + "\t\t");
		for (int i = 0; i < (ZoologikoaApp.LEHOI_KOPURUA + 1) - (id + 1); i++) {
			System.out.print("\t\t");
		}
		//System.out.println();
	}

	public static void margotuDatuak(int id, int haragiKopurua, int lehoiKopurua,
			boolean ateaItxita, boolean block) {
		
		printMax(lehoiKopurua, ZoologikoaApp.LEHOI_KOPURUA);

			System.out.print('\t');
		
		
		printMax(haragiKopurua, ZoologikoaApp.HARAGI_KOPURUA_MAX);

			System.out.print('\t');
		
		System.out.print(ateaItxita?"itxita":"irikita");	

		System.out.print("\t[");

		System.out.print(block?"X":" ");
		
		System.out.println("]\t\t");
		
		
		//System.out.print(kotxeakItxoiten+"\t"+kotxeakPasatzen+"\t"+oinezkoakItxoiten+"\t"+oinezkoakPasatzen+"\t");
	
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
	
}