import java.io.IOException;

/*
 * PK5.pdf Ariketak
 * 		LIFO ilara batean prozesuak 
 *		sartu eta ateratzen dira.
 *
 * Egilea: Jon Led
 * Data: 2017-10-30
 */

public class FIFOApp {
	public static int PROZESU_MAX = 8;	// Prozesu Kopurua
	public static int POSIZIO_MAX = 5;	// Prozesu Kopurua

	public static void main (String[] args) throws IOException {
		
		FIFO fifo = new FIFO();
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