/*
 * PK3.pdf Ariketak
 * 		BaiEz4 adibidearen Java inplementazioa egokitu,
 *		bi hari sortu beharrean, hiru sortzeko:
 *		“bai”, “ez” eta “agian”
 *
 * Egilea: Jon Led
 * Data: 2017-09-24
 */

public class BaiEzAgian1App {

	public static void main(String args[]) {
		Pantaila p = new Pantaila();
		Idazlea bai = new Idazlea("bai", 1000, 4, p);
		Idazlea ez = new Idazlea("\tez", 400, 20, p);
		Idazlea agian = new Idazlea("\t\tagian", 700, 10, p);
		bai.start();
		ez.start();
		agian.start();
	}
}
