
class Kontagailua {
	int balioa = 0;

	Kontagailua() {
		imprimatu();
	}

	void gehitu() {
		int lag;
		lag = balioa;
		// balioa irakurri
		Simulatu.HWinterrupt();
		balioa = lag + 1;
		// balioa idatzi
		imprimatu();
	}
	
	void imprimatu() {
		System.out.print("\t\t\t\t[");
		for(int k = 0;k < balioa; k++) 
			System.out.print("*");
		for(int j = balioa; j < LorategiaApp.MAX*2; j++) 
			System.out.print(" ");				
		System.out.println("]");
	}
}