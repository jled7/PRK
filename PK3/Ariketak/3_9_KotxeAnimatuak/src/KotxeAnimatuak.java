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

public class KotxeAnimatuak  {
	
	public static void main (String args[]) {
	
		Framea framea = new Framea();
		framea.setVisible(true);
		
		Kotxea k1 = new Kotxea(1, 100, -1,framea);
		Kotxea k2 = new Kotxea(2, 30 ,  1,framea);
						
		k1.start();
		k2.start();
	}
}



