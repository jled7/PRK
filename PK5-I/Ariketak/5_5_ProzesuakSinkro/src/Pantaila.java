import java.io.IOException;

public class Pantaila {
	private int prozesuKopurua;

	public Pantaila(int prozesuKopurua) {
		this.prozesuKopurua = prozesuKopurua;
	}

	public synchronized void hasieratu() {
		for (int i = 0; i < prozesuKopurua; i++) {
			System.out.print("P[" + i + "]\t\t");
		}
		System.out.println();
		for (int i = 0; i < prozesuKopurua + 1; i++) {
			System.out.print("========");
		}
		System.out.println("===============");
	}

	public synchronized void margotu(int id, String string) {
		for (int i = 0; i < id; i++) {
			System.out.print("\t\t");
		}
		System.out.print(string + "\t");
		for (int i = 0; i < prozesuKopurua - (id + 1); i++) {
			System.out.print("\t\t");
		}
		System.out.println();
	}

}
