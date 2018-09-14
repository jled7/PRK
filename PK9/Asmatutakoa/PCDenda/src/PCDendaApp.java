import java.io.IOException;

/*
 * Azken Lanak - Asmatutako Praktika
 * 		Hau informatikako denda bat da. Bertan ordenadoreak konpontzen dira.
 *		Informatikaria konpontzez arduratzen da bere barruko lantokian.
 *		Dendan 5 pertsona bakarrik sartzen dira eta ezin dira egon 3 ordenadore
 *		baina gehiago konpontzen egon, denda txiki bat da eta ez dago 
 *		denontzako lekua. 
 *		Bertan informatikari bakarra dago eta berak atenditu eta konpondu
 *		behar ditu, baino ezingo du barrura joan konpontzera jendea atenditzeko
 *      badago. Barruan egoten da eta kanpora atera beharko du norbait
 * 		sartzean, atenditzera. Ezingo ditu eskaketak hartu, barruan mahaia
 *		beteta badago ere.
 *		Ordenadoreak ateratzeko zinta bat erabiltzen du, bezeroak hartu
 *		eta joan egiten dira, aurretik ordain dute eta, honek barruko mahaiaren
 *		limite berdina du(3).
 *		Nahi dugu pertsonak dendan sartzean eta ordenadore bat uztean kanpora
 *		ateratzera eta gero itzultzera ikusteko dagoen, eta badago, eramatera.
 *
 * Egilea: Jon Led
 * Data: 2018-01-11
 */

public class PCDendaApp {
	public static int PERTSONA_KOPURUA = 5;	
	public static int ORDENAGAILU_MAX = 3;
	public static Panel panel;

	public static void main (String[] args) throws IOException {
		
		Konponketak konponketak = new Konponketak();
		Pantaila.hasieratu();
		Pertsona pertsonak[] = new Pertsona[PERTSONA_KOPURUA];
		Informatikaria informatikaria = new Informatikaria(-1, konponketak);
				
		panel = new Panel(informatikaria, pertsonak);
		Frame frame = new Frame();
		frame.add(panel);
		frame.setVisible(true);
		
		for (int i = 0; i < PERTSONA_KOPURUA; i++) {
			pertsonak[i] = new Pertsona(i+1, konponketak);
		}
		for (int i = 0; i < PERTSONA_KOPURUA; i++) {
			pertsonak[i].start();
		}
		
		informatikaria.start();
		

	}

}
