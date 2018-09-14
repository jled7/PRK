import java.io.IOException;

/*
 * PK7.pdf Ariketak
 * 		LIFO pilaren arazoa soluzionatu, prozesu guztiak
 *		noizbait pilatik aterako direla ziurtatuz.
 *		Segurtasun- eta bizitasun-propietateak aztertu eta hasunarketa egin.
 *			b. Bizitasun propietatea ez dela bortxatzen.
 *
 * Egilea: Jon Led
 * Data: 2017-11-28
 */

public class LIFOApp {
	public static int PROZESU_MAX = 8;	// Prozesu Kopurua
	public static int ILARA_TAMAINA = 5; // Ilararen tamaina
	public static int PROZESU_HUSKETA = 10; // Prozesu husketa egiteko 

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