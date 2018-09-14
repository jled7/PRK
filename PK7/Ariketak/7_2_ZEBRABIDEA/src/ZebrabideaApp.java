import java.io.IOException;

/*
 * PK7.pdf Ariketak
 * 		Zebrabide batetara iristean:
 *			- Kotxeak zain geldituko dira oinezkoren bat pasatzen edo pasatzeko zain baldin badago.
 *			- Oinezkoek, ordea, zain geldituko dira une horretan kotxe bat pasatzen ari bada, harrapatuak ez
 *			  izateko.
 *		Gainera ataskorik sor ez dadin, hiru kotxe baino gehiago zain badaude, oinezkoek ere itxarongo
 *		dute.
 *
 *
 * Egilea: Jon Led
 * Data: 2017-11-28
 */

public class ZebrabideaApp {
	public static int KOTXE_KOPURUA = 5;	
	public static int OINEZKOEN_KOPURUA = 3;

	public static void main (String[] args) throws IOException {
		
		Zebrabidea zebrabidea = new Zebrabidea();
		Pantaila.hasieratu();
		Kotxea kotxeak[] = new Kotxea[KOTXE_KOPURUA];
		Oinezkoa oinezkoak[] = new Oinezkoa[OINEZKOEN_KOPURUA];
				
		for (int i = 0; i < KOTXE_KOPURUA; i++) {
			kotxeak[i] = new Kotxea(i, zebrabidea);
		}
		for (int i = 0; i < KOTXE_KOPURUA; i++) {
			kotxeak[i].start();
		}
		
		for (int i = 0; i < OINEZKOEN_KOPURUA; i++) {
			oinezkoak[i] = new Oinezkoa(i, zebrabidea);
		}
		for (int i = 0; i < OINEZKOEN_KOPURUA; i++) {
			oinezkoak[i].start();
		}
	}

}