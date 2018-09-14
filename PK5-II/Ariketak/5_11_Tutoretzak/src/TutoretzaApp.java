import java.io.IOException;

/*
 * PK5.pdf Ariketak
 * 		LIFO ilara batean prozesuak 
 *		sartu eta ateratzen dira.
 *
 * Egilea: Jon Led
 * Data: 2017-10-31
 */

public class TutoretzaApp {
	public static int IKASLE_KOPURUA = 3;	// Ikasle< Kopurua

	public static void main (String[] args) throws IOException {
		
		Bulegoa bulegoa = new Bulegoa();
		Pantaila.hasieratu();
		Ikaslea ikasleak[] = new Ikaslea[IKASLE_KOPURUA];
		Irakaslea irakaslea = new Irakaslea(bulegoa);
		irakaslea.start();
		for (int i = 0; i < IKASLE_KOPURUA; i++) {
			ikasleak[i] = new Ikaslea(i, bulegoa);
		}
		for (int i = 0; i < IKASLE_KOPURUA; i++) {
			ikasleak[i].start();
		}
	}

}