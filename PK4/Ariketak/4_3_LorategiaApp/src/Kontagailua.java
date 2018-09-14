
class Kontagailua {
	int balioa = 0;
	Pantaila p;

	public Kontagailua(Pantaila p) {
		this.p = p;
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
		p.imprimatu("\t\t\t\t", balioa, LorategiaApp.MAX*2);
	}
}