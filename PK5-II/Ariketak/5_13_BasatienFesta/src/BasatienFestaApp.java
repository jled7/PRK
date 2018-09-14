/*
 * PK5.pdf Ariketak
 * 		3. Basatien festa:
 *			- Basati bakoitzak lapiko batetik 
 *			  misiolari-puska bat hartzen du;
 *			  puska hori jaten bukatzean, tripazgora
 *			  jarri eta ondoren beste bat hartzen du...
 *			- Basati sukaldariak lapikoa hutsik dagoenean
 *			  lapikoa betetzen du misiolari-puskekin.
 *			- baina orain sukaldariak hainbat puska bota,
 * 			  eta basatiek hainbat puska hartu, eta bota 
 * 			  edo hartu aurretik, lapikoan zenbat dagoen
 * 			  begiratzen dute.
 *
 * Egilea: Jon Led
 * Data: 2017-10-08
 */

public class BasatienFestaApp {
	final static int PUSKA_MAXIMOAK = 5;  // Lapikoaren tamaina
	final static int BASATI_KOPURUA = 3;
	final static int MISIOLARI_KOPURUA = 6;
	final static int HOZKAILUAREN_TAMAINA = 6;
	final static int MOZTEKO_PUSKETAK = 3;
	
	public static void main(String[] args) {
		Pantaila pantaila = new Pantaila(PUSKA_MAXIMOAK, BASATI_KOPURUA);
		Lapikoa lapikoa = new Lapikoa(PUSKA_MAXIMOAK, pantaila);
		Sukaldaria sukaldaria = new Sukaldaria(BASATI_KOPURUA, lapikoa, pantaila, MOZTEKO_PUSKETAK);
		Txalupa txalupa = new Txalupa(lapikoa, pantaila);
		pantaila.hasieratu();
		Basatia b[] = new Basatia[BASATI_KOPURUA];
		
		for(int i=0; i<BASATI_KOPURUA; i++) {
			b[i] = new Basatia(i, lapikoa, pantaila);
		}
		for(int i=0; i<BASATI_KOPURUA; i++) {
			b[i].start();
		}
		sukaldaria.start();
		txalupa.start();
	}
}
