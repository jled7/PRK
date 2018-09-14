import java.io.IOException;

/*
 * PK7.pdf Ariketak
 * 		Josemiren oiloek oilategian jartzen dituzte arraultzak,
 *		baina soilik sartzen dira bertara Josemi barruan ez badago.
 *		Josemi oilategian sartzen da oilorik ez badago, bi arraultz
 *		hartzen ditu eta ondoren ateratzen da.
 *
 * Egilea: Jon Led
 * Data: 2017-12-28
 */

public class ZoologikoaApp {	
	public static int LEHOI_KOPURUA = 3;
	public static int HARAGI_KOPURUA_MAX = 10;

	public static void main (String[] args) throws IOException {
		
		Jangela jangela = new Jangela();
		Pantaila.hasieratu();
		Lehoia lehoiak[] = new Lehoia[LEHOI_KOPURUA];
		Langilea langilea = new Langilea(0, jangela);
				
		for (int i = 0; i < LEHOI_KOPURUA; i++) {
			lehoiak[i] = new Lehoia(i+1, jangela);
		}
		for (int i = 0; i < LEHOI_KOPURUA; i++) {
			lehoiak[i].start();
		}
			langilea.start();
	}

}