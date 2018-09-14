/*
 * PK4.pdf Adibidea
 * Lorategiaren problema - Interferentzia eta Elkar-Bazterketa
 *
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
		System.out.println("Aurre \tAtze \tGuztira");
		Kontagailua k = new Kontagailua();
		Atea aurrekoa = new Atea("", k);
		Atea atzekoa = new Atea("\t", k);
		aurrekoa.start();
		atzekoa.start();
	}
}