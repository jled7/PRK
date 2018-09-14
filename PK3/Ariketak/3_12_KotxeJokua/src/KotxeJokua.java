/*
 * PK3.pdf Ariketak
 * 		Inplementatu zuk asmatutako programa
 *  	bat hariak eta irudiak erabiliz.
 *
 * Egilea: Jon Led
 * Data: 2017-09-26
 */

public class KotxeJokua {

	public static void main(String args[]) {

		Framea framea = new Framea();
		framea.setVisible(true);

		Kotxea k1 = new Kotxea(4, 100, 0, framea);
		Kotxea k2 = new Kotxea(2, 70, 0, framea);
		Kotxea k3 = new Kotxea(3, 125, 0, framea);
		
		k1.start();
		k2.start();
		k3.start();
	
	}
}
