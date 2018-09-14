import java.io.IOException;

public class Pantaila {
	public static int kopurua;

	public static void hasieratu() throws IOException {
		System.out
				.println("=========================================================================================================================================================================");
		for (int i = 0; i < ZebrabideaApp.KOTXE_KOPURUA; i++) {
			System.out.print("Kotxe[" + i + "]\t");
		}
		for (int i = 0; i < ZebrabideaApp.OINEZKOEN_KOPURUA; i++) {
			System.out.print("Oinezko[" + i + "]\t");
		}
		System.out.println("kotxeak\tzebrabide\toinezko\tTxanda");
		for (int i = 0; i < (ZebrabideaApp.KOTXE_KOPURUA + ZebrabideaApp.OINEZKOEN_KOPURUA); i++) {
			System.out.print("================");
		}
		System.out.print("=========================================");
		System.out.println();
	}

	public synchronized static void margotu(int id, String string) {

		for (int i = 1; i < id + 1; i++) {
			System.out.print("\t\t");
		}
		System.out.print(string + "\t\t");
		for (int i = 0; i < (ZebrabideaApp.KOTXE_KOPURUA + ZebrabideaApp.OINEZKOEN_KOPURUA)
				- (id + 1); i++) {
			System.out.print("\t\t");
		}
		// System.out.println();
	}

	public static void margotuDatuak(int id, int kotxeakItxoiten,
			int kotxeakPasatzen, int oinezkoakItxoiten, int oinezkoakPasatzen,
			boolean txanda) {

		printKotxeak(kotxeakItxoiten);

		System.out.print('\t');

		if (kotxeakPasatzen > 0) {
			printOinezkoakEtaKotxeak(kotxeakPasatzen, "k");
			//System.out.print(kotxeakPasatzen);
		} else {
			printOinezkoakEtaKotxeak(oinezkoakPasatzen, "o");
			//System.out.print(oinezkoakPasatzen);
		}
		
		System.out.print('\t');
		System.out.print('\t');
		printOinezkoak(oinezkoakItxoiten);

		System.out.print('\t');

		// System.out.print(kotxeakItxoiten+"\t"+kotxeakPasatzen+"\t"+oinezkoakItxoiten+"\t"+oinezkoakPasatzen+"\t");
		System.out.println(!txanda ? "Kotxeak" : "Oinezkoak");
	}

	private static synchronized void printKotxeak(int pk) {
		System.out.print('[');
		for (int i = 0; i < pk; i++) {
			System.out.print('k');
		}
		for (int i = 0; i < ZebrabideaApp.KOTXE_KOPURUA - (pk); i++) {
			System.out.print(' ');
		}
		System.out.print(']');
	}

	private static synchronized void printOinezkoak(int pk) {
		System.out.print('[');
		for (int i = 0; i < pk; i++) {
			System.out.print('o');
		}
		for (int i = 0; i < ZebrabideaApp.OINEZKOEN_KOPURUA - (pk); i++) {
			System.out.print(' ');
		}
		System.out.print(']');
	}

	private static synchronized void printOinezkoakEtaKotxeak(int pk, String ikurra) {
		int max = ZebrabideaApp.KOTXE_KOPURUA > ZebrabideaApp.OINEZKOEN_KOPURUA ? ZebrabideaApp.KOTXE_KOPURUA
				: ZebrabideaApp.OINEZKOEN_KOPURUA;
		System.out.print('[');
		for (int i = 0; i < pk; i++) {
			System.out.print(ikurra);
		}
		for (int i = 0; i < max - (pk); i++) {
			System.out.print(' ');
		}
		System.out.print(']');
	}
}