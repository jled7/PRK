import java.io.IOException;

/*
 * PK7.pdf Ariketak
 * 		Zebrabide batetara iristean:
 *			- Kotxeak zain geldituko dira oinezkoren bat pasatzen 
 *			  edo pasatzeko zain baldin badago.
 *			- Oinezkoek, ordea, zain geldituko dira une horretan 
 *			  kotxe bat pasatzen ari bada, harrapatuak ez izateko.
 *		Gainera ataskorik sor ez dadin, hiru kotxe baino gehiago zain
 *		badaude, oinezkoek ere itxarongo dute.
 *
 *		Hausnarketa:
 *			Oraingo hontan, txandak erabili dira, bizitasun propietateak
 *			ez bortsatzeko.
 *
 * Egilea: Jon Led
 * Data: 2017-11-29
 */

public class LIFOApp {
	public static int PROZESU_MAX = 8;	// Prozesu Kopurua
	public static int ILARA_TAMAINA = 5; // Ilararen tamaina

	public static void main (String[] args) throws IOException {
		
		LIFO fifo = new LIFO();
		Pantaila.hasieratu();
		Prozesua prozesuak[] = new Prozesua[PROZESU_MAX];
		
		for (int i = 0; i < PROZESU_MAX; i++) {
			prozesuak[i] = new Prozesua(i, fifo);
		}
		for (int i = 0; i < PROZESU_MAX; i++) {
			prozesuak[i].start();
		}
	}

}