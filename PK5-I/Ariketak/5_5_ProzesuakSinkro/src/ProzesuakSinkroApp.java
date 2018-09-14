/*
 * PK5.pdf Ariketak
 * 		4. Ikasle jator batzuen pisuan gastuetarako bote bat dute.
 *		   Norberak ahal duen heinean botean dirua sartzen du,
 *		   eta behar duen neurrian hartu.
 *
 * Egilea: Jon Led
 * Data: 2017-10-10
 */

public class ProzesuakSinkroApp {
	final static int PROZESU_KOPURUA = 3;
	
	public static void main(String[] args) {
		Pantaila pantaila = new Pantaila(PROZESU_KOPURUA);
		Kontrola kontrola = new Kontrola(PROZESU_KOPURUA, pantaila);
		pantaila.hasieratu();
		Prozesua b[] = new Prozesua[PROZESU_KOPURUA];
		
		for(int i=0; i<PROZESU_KOPURUA; i++) {
			b[i] = new Prozesua(i, kontrola);
		}
		for(int i=0; i<PROZESU_KOPURUA; i++) {
			b[i].start();
		}
	}
}
