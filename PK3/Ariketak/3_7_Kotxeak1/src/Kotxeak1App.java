/*
 * PK3.pdf Ariketak
 * 		Bi kotxe (bi hari) izango ditugu. Kotxeak “+” eta “*” 
 *		ikurrekin adieraziko dira eta ezkerretik eskuinera
 *		mugituko dira, bakoitza abiadura desberdinean.
 *
 * Egilea: Jon Led
 * Data: 2017-09-24
 */

public class Kotxeak1App {

	public static void main(String[] args) {
		Pantaila p = new Pantaila();
		Kotxea k1 = new Kotxea("+", 7, p);
		Kotxea k2 = new Kotxea("*", 4, p);
		k1.start();
		k2.start();
	}

}
