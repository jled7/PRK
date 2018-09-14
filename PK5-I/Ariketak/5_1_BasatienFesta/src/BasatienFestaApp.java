/*
 * PK5.pdf Ariketak
 * 		1. Basatien festa:
 *			- Basati bakoitzak lapiko batetik 
 *			  misiolari-puska bat hartzen du;
 *			  puska hori jaten bukatzean, tripazgora
 *			  jarri eta ondoren beste bat hartzen du...
 *			- Basati sukaldariak lapikoa hutsik dagoenean
 *			  lapikoa betetzen du misiolari-puskekin.
 *
 * Egilea: Jon Led
 * Data: 2017-10-08
 */

public class BasatienFestaApp {
	final static int PUSKA_MAXIMOAK = 3;
	final static int BASATI_KOPURUA = 3;
	
	public static void main(String[] args) {
		Pantaila pantaila = new Pantaila(PUSKA_MAXIMOAK);
		Lapikoa lapikoa = new Lapikoa(PUSKA_MAXIMOAK, pantaila);
		Sukaldaria sukaldaria = new Sukaldaria(lapikoa);
		pantaila.hasieratu();
		Basatia b[] = new Basatia[BASATI_KOPURUA];
		
		for(int i=0; i<BASATI_KOPURUA; i++) {
			b[i] = new Basatia(i, lapikoa, pantaila);
		}
		for(int i=0; i<BASATI_KOPURUA; i++) {
			b[i].start();
		}
		sukaldaria.start();
	}
}
