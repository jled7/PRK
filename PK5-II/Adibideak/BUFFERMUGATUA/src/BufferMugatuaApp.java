/*
 * PK5.pdf Ariketak
 * 		Egokitu buffer mugatuaren FSP eredua
 *		put eta get egitean, jarri eta hartu
 *		behar den posizioa adierazteko
 *
 * Egilea: Jon Led
 * Data: 2017-10-28
 */

public class BufferMugatuaApp {

	public static void main(String[] args) {
		Pantaila pantaila = new Pantaila();
		Buffer buffer = new Buffer(5, pantaila);
		Idazlea idazle = new Idazlea(buffer, pantaila);
		Irakurlea irakurle = new Irakurlea(buffer, pantaila);
		idazle.start();
		irakurle.start();

	}

}
