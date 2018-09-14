
public class Pantaila {
	synchronized void imprimatu(String indentazioa, int kopurua,int max) {
		System.out.print(indentazioa+"[");
		for(int k = 0;k < kopurua; k++) { 
			System.out.print("*");
			Simulatu.HWinterrupt();
		}
		
		for(int j = kopurua; j < max; j++) 
			System.out.print(" ");				
		System.out.println("]");
	}
}
