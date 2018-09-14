/*
 * PK3.pdf Ariketak
 * 		Lorategi batean bi ate daude. Pertsona bat sartzen
 *		den bakoitzean ate horrek kontagailu bat inkrementatzen
 *	    du jakiteko zenbat sartu diren guztira.Pertsonak sartuko
 *		dira lorategira beteta egon arte. Pertsonak ez dira
 *		aterako, soilik sartu. Java eredua.
 *
 * Egilea: Jon Led
 * Data: 2017-09-24
 */

public class LorategiaApp {
	public static void main(String[] args) {
		System.out.println("Atea 1\tAtea 2\tKontadorea");
		Kontadorea k = new Kontadorea();
		Atea k1 = new Atea(1, k);
		Atea k2 = new Atea(2, k);
		k1.start();
		k2.start();
	}
}
