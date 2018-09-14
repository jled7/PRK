/*
 * PK3.pdf Ariketak
 * 		Nahi dituzun hobekuntzak egin 9. ariketan:
 * 			- fondo bat jarriz, kotxe gehiago ipiniz,
 * 			  kotxeek aurrera eta atzera eginez, 
 * 			  kotxeez gain beste aktore batzuk agertuz,
 * 			  mugimenduak ez soilik horizontalean izanik...
 * 			- hasieran interfazeak eskeintzen du aukera,
 * 			  erabiltzaileak sartzeko kotxe kopurua,
 * 			  mugimendu motak, azelerazio parametroak...
 * 			- botoi batzuen edo teklen bidez, kotxeak
 *  		  azeleratzeko eta desazeleratzeko, edota
 *  		  aurrera joateaz gain, kotxeak gora eta
 *  		  behera egiteko...
 *
 * Egilea: Jon Led
 * Data: 2017-09-25
 */

public class KotxeAnimatuak {

	public static void main(String args[]) {

		Framea framea = new Framea();
		framea.setVisible(true);

		Kotxea k1 = new Kotxea(1, 400, -1, framea);
		Kotxea k2 = new Kotxea(2, 250, 1, framea);
		Kotxea k3 = new Kotxea(3, 2000, 2, framea);
		
		k1.start();
		k2.start();
		k3.start();
	
	}
}
