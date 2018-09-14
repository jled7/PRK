/*
 * PK4.pdf Ariketak
 * 		Lorategiaren programa egokitu,
 * 		izartxo bat idazten den bakoitzean,
 * 		HWInterrupt dei bat egiten.
 * 		Ikusi gertatzen den interferentzia.
 *
 * Egilea: Jon Led
 * Data: 2017-10-01
 */

class LorategiaApp {
	public final static int MAX = 6;

	public static void main(String args[]) {
		System.out.println("LORATEGIA: return sakatu hasteko");
		try {
			int c = System.in.read();
		} catch (Exception ex) {
		}
		System.out.println("Aurre \t\tAtze \t\tGuztira");
		Kontagailua k = new Kontagailua();
		Atea aurrekoa = new Atea("", k);
		Atea atzekoa = new Atea("\t\t", k);
		aurrekoa.start();
		atzekoa.start();
	}
}