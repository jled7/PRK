/*
 * PK5.pdf Adibidea
 * Baldintzen sinkronizazioa: aparkalekuaren adibidea
 *
 * Data: 2017-10-08
 */

public class AparkalekuaApp {
	final static int Plazak = 4;

	public static void main(String args[]) {
		Pantaila pant = new Pantaila(Plazak);
		Kontrolatzailea k = new Kontrolatzailea(Plazak, pant);
		Sarrerak sar = new Sarrerak(k);
		Irteerak irt = new Irteerak(k);
		sar.start();
		irt.start();
	}
}