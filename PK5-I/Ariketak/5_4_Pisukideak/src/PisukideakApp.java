/*
 * PK5.pdf Ariketak
 * 		4. Ikasle jator batzuen pisuan gastuetarako bote bat dute.
 *		   Norberak ahal duen heinean botean dirua sartzen du,
 *		   eta behar duen neurrian hartu.
 *
 * Egilea: Jon Led
 * Data: 2017-10-10
 */

public class PisukideakApp {
	final static int TXANPON_KOPURUA = 10;
	final static int IKASLE_KOPURUA = 3;
	
	public static void main(String[] args) {
		Pantaila pantaila = new Pantaila(TXANPON_KOPURUA, IKASLE_KOPURUA);
		Botea botea = new Botea(TXANPON_KOPURUA, pantaila);
		pantaila.hasieratu();
		Ikaslea b[] = new Ikaslea[IKASLE_KOPURUA];
		
		for(int i=0; i<IKASLE_KOPURUA; i++) {
			b[i] = new Ikaslea(i, botea, pantaila);
		}
		for(int i=0; i<IKASLE_KOPURUA; i++) {
			b[i].start();
		}
	}
}
