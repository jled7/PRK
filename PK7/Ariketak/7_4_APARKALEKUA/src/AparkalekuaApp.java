import java.io.IOException;

/*
 * PK7.pdf Ariketak
 * 		3 kotxe eta 5 moto erabiltzen duten aparkaleku batean 10 plaza daude. Moto batek plaza bat
 *		okupatzen du eta kotxe batek hiru plaza. Aparkalekura sartzeko eta ateratzeko pasabide txiki bat
 *		dago. Pasabide horretan kotxe bakar bat egon daiteke edo bi moto edozein norabidean.
 *		Pasabidean sartzean ibilgailuek ez dakite aparkalekuan plazarik dagoen edo ez.
 *
 * Egilea: Jon Led
 * Data: 2017-12-28
 */

public class AparkalekuaApp {
	public static int KOTXE_KOPURUA = 3;	
	public static int MOTOEN_KOPURUA = 5;
	public static int APARKALEKUEN_MAX = 10;

	public static void main (String[] args) throws IOException {
		
		Aparkalekua aparkalekua = new Aparkalekua();
		Pantaila.hasieratu();
		Kotxea kotxeak[] = new Kotxea[KOTXE_KOPURUA];
		Motoa motoak[] = new Motoa[MOTOEN_KOPURUA];
				
		for (int i = 0; i < KOTXE_KOPURUA; i++) {
			kotxeak[i] = new Kotxea(i, aparkalekua);
		}
		for (int i = 0; i < KOTXE_KOPURUA; i++) {
			kotxeak[i].start();
		}
		
		for (int i = 0; i < MOTOEN_KOPURUA; i++) {
			motoak[i] = new Motoa(i+KOTXE_KOPURUA, aparkalekua);
		}
		for (int i = 0; i < MOTOEN_KOPURUA; i++) {
			motoak[i].start();
		}
	}

}