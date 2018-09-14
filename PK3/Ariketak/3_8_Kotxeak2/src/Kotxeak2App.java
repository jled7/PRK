/*
 * PK3.pdf Ariketak
 * 		Bi kotxe (bi hari) izango ditugu. Kotxeak “+” eta “*” 
 *		ikurrekin adieraziko dira eta ezkerretik eskuinera
 *		mugituko dira, bakoitza abiadura desberdinean.
 *		Kotxeen ariketa egokitu exekuzioan zehar kotxeen
 *		abiadura aldatzen joateko.
 *
 * Egilea: Jon Led
 * Data: 2017-09-24
 */

public class Kotxeak2App {

	public static void main(String[] args) {
		Pantaila p = new Pantaila();
		Kotxea k1 = new Kotxea("+", 50, -1, p);
		Kotxea k2 = new Kotxea("*", 4, 1, p);
		k1.start();
		k2.start();
	}

}
