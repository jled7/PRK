/*
 * PK3.pdf Ariketak
 * 		BaiEz4 adibidearen Java inplementazioa egokitu,
 *		exekuzioan zehar harien abiadura aldatzeko.
 *		Hasieran “bai” azkar idazten du eta bukaeran poliki,
 *		eta “ez” hasieran poliki eta gero azkar.
 *
 * Egilea: Jon Led
 * Data: 2017-09-24
 */

public class BaiEzApp {

	public static void main(String args[]) {
		Pantaila p = new Pantaila();
		Idazlea bai = new Idazlea("bai", 200, -100, 12, p);
		Idazlea ez = new Idazlea("\tez", 1200, 100, 15, p);
		bai.start();
		ez.start();
	}
}
