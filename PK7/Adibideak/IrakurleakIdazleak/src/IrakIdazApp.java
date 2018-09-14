/*
 * PK7.pdf Adibidea
 * Irakurleak/Idazleak - Idazlearen lehentasuna
 *
 * Data: 2017-11-27
 */

public class IrakIdazApp {

	public static void main(String args[]) {
		IrakurriIdatziLehentasuna blokeoa = new IrakurriIdatziLehentasuna();
		int IdKop = 3;
		int IrKop = 5;
		String tabul = "";

		for (int i = 1; i <= IrKop; i++) {
			System.out.print(i + ".irak\t");
		}
		for (int i = 1; i <= IdKop; i++) {
			System.out.print("\t" + i + ".idaz");
		}
		System.out
				.println("\n==========================================================\n");

		Irakurlea ir[] = new Irakurlea[IrKop];
		Idazlea id[] = new Idazlea[IdKop];

		for (int i = 0; i < IrKop; i++) {
			ir[i] = new Irakurlea(blokeoa, tabul, 1, 3);
			ir[i].start();
			tabul = tabul + "\t";
		}

		for (int i = 0; i < IdKop; i++) {
			tabul = tabul + "\t";
			id[i] = new Idazlea(blokeoa, tabul, 1, 3);
			id[i].start();
		}
	}
}