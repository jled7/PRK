import java.io.IOException;

/*
 * PK7.pdf Ariketak
 * 		Josemiren oiloek oilategian jartzen dituzte arraultzak, baina soilik sartzen
 *		dira bertara Josemi barruan ez badago. Josemi oilategian sartzen da oilorik ez badago, bi arraultz
 *		hartzen ditu eta ondoren ateratzen da.
 *
 * Egilea: Jon Led
 * Data: 2017-12-28
 */

public class OilotegiaApp {	
	public static int OILOEN_KOPURUA = 3;
	public static int ARRAUTZ_KOPURUA_MAX = 5;
	public static int KONTAGAILUA = 10;

	public static void main (String[] args) throws IOException {
		
		Oilotegia oilotegia = new Oilotegia();
		Pantaila.hasieratu();
		Oiloa oiloak[] = new Oiloa[OILOEN_KOPURUA];
		Josemi josemi = new Josemi(0, oilotegia);
				
		for (int i = 0; i < OILOEN_KOPURUA; i++) {
			oiloak[i] = new Oiloa(i+1, oilotegia);
		}
		for (int i = 0; i < OILOEN_KOPURUA; i++) {
			oiloak[i].start();
		}
			josemi.start();
	}

}