/* 6.3 Filosofoen afaria 3.Ariketa
 * 
 *	• Javaren   wait  primitiba   erabiliz  Sardeska
 *    monitorearen   inplementazioa   aldatu, segundu
 *    bat zain egon ondoren get deia itzultzeko false
 *    balioarekin.
 *    
 *	• Filosofoak beste sardeskarik bazuen askatu beharko du eta berriz saiatu. 
 *
 *	• Aztertu sistemaren jokaera:
 *			Sistema ez da blokeatzen, sardeska bat ez duelako segundu bat
 *			baino gehiago irauten blokeatuta, eta beste prozesuek segi
 *			dezakete haien lana burutzen
 *
 * Jon Led
 * 07/11/17
 */

class FilosofoApp {
	final static int Kop = 5;
	final static Filosofoa[] fil = new Filosofoa[Kop];
	final static Sardeska[] sar = new Sardeska[Kop];
	final static String[] tartea = new String[Kop];

	public static void main(String args[]) {
		tartea[0] = "\t ";
		tartea[1] = "\t \t   ";
		tartea[2] = "\t \t\t\t   ";
		tartea[3] = "\t \t\t\t\t\t   ";
		tartea[4] = "\t \t\t\t\t\t\t\t   ";

		System.out.println("      \t\t\t\tFilosofoak ");
		System.out.print("  \t      0\t\t1\t\t2\t\t3\t\t4");
		
		for (int i = 0; i < Kop; ++i) {
			sar[i] = new Sardeska(i);
			System.out.print("\tSardeska" + (i+1));
		}
		System.out.println();
		System.out
		.println("=========================================================================================================================================================");	
		for (int j = 0; j < Kop; ++j) {
			fil[j] = new Filosofoa(j, sar[(j - 1 + Kop) % Kop], sar[j],
					tartea[j]);
			fil[j].start();
		}
	}
}
