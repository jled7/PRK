import java.io.IOException;

/*
 * PK5.pdf Ariketak
 * 		Array bateko zenbakien batuketa kalkulatu,
 *		agendaren eredua erabiliz eta soilik bi 
 *      zenbakien arteko batuketak egin ahal 
 *      dituzten prozesu aktiboekin.
 *      Soilik Javaz inplementatu.
 *
 * Egilea: Jon Led
 * Data: 2017-10-31
 */

public class BaturaApp {

	public static int PROZESU_MAX = 5; 		// Prozesu Kopurua
	public static int ARRAY_TAMAINA = 20; 	// Array-aren tamaina

	public static void main(String[] args) throws IOException {

		int[] array = new int[ARRAY_TAMAINA];
		for (int i = 0; i < array.length; i++) {
			array[i] = ((int) (Math.random() * 10));
		}
		Pantaila.hasieratu(array);
		Buffer buffer = new Buffer(array);
		Prozesua prozesuak[] = new Prozesua[PROZESU_MAX];

		for (int i = 0; i < PROZESU_MAX; i++) {
			prozesuak[i] = new Prozesua(i, buffer);
		}
		for (int i = 0; i < PROZESU_MAX; i++) {
			prozesuak[i].start();
		}
	}
}
