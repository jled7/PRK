import java.io.IOException;

public class Pantaila {
	public static int kopurua;

	public static void hasieratu() throws IOException {
		System.out
				.println("=============================================================================================================================");
			System.out.print("Josemi\t\t");
		for (int i = 0; i < OilotegiaApp.OILOEN_KOPURUA; i++) {
			System.out.print("Oiloa[" + i + "]\t");
		}
		System.out.println("arrautz\toilotegia\tjosemi\t    begiratzen\tKontagailua");
		for (int i = 0; i < (OilotegiaApp.OILOEN_KOPURUA + OilotegiaApp.OILOEN_KOPURUA); i++) {
			System.out.print("================");
		}
		System.out.print("=============================");
		System.out.println();
	}

	public synchronized static void margotu(int id, String string) {

		for (int i = 1; i < id + 1; i++) {
			System.out.print("\t\t");
		}
		System.out.print(string + "\t\t");
		for (int i = 0; i < (OilotegiaApp.OILOEN_KOPURUA + 1) - (id + 1); i++) {
			System.out.print("\t\t");
		}
		//System.out.println();
	}

	public static void margotuDatuak(int id,int arrautzaKopurua, int oiloKopurua,
			boolean josemiBarruan, boolean block, int kontagailua) {
		
		printMax(arrautzaKopurua, OilotegiaApp.ARRAUTZ_KOPURUA_MAX, "*");

			System.out.print('\t');
		
		if(josemiBarruan) {
			printMax(1, OilotegiaApp.OILOEN_KOPURUA, "j");
		} else {
			printMax(oiloKopurua, OilotegiaApp.OILOEN_KOPURUA, "o");
		}
		

		System.out.print('\t');	System.out.print('\t');
		
		System.out.print(josemiBarruan?"barruan":"kanpoan");	

		System.out.print("\t\t[");

		System.out.print(block?"X":" ");
		
		System.out.print("]\t");
		printMax(kontagailua, OilotegiaApp.KONTAGAILUA, "*");

		System.out.println();
		
		
		//System.out.print(kotxeakItxoiten+"\t"+kotxeakPasatzen+"\t"+oinezkoakItxoiten+"\t"+oinezkoakPasatzen+"\t");
	
	}
	
	private static synchronized void printMax(int pk, int max, String ikurra) {
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