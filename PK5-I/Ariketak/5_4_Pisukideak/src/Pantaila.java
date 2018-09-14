import java.io.IOException;

public class Pantaila {
	private int txanponMaximoa, ikasleKopurua;

	public Pantaila(int txanponMaximoa, int ikasleKopurua) {
		this.txanponMaximoa = txanponMaximoa;
		this.ikasleKopurua = ikasleKopurua;
	}

	public synchronized void hasieratu() {
		for (int i = 0; i < ikasleKopurua; i++) {
			System.out.print("i[" + i + "]\t\t");
		}
		System.out.println("Botea");
		for (int i = 0; i < ikasleKopurua + 1; i++) {
			System.out.print("========");
		}
		System.out.println("=============================");
	}

	public synchronized void margotu(int id, String string, int txanponKopurua) {
		for (int i = 0; i < id; i++) {
			System.out.print("\t\t");
		}
		System.out.print(string + "\t");
		for (int i = 0; i < ikasleKopurua - (id + 1); i++) {
			System.out.print("\t\t");
		}
		if (txanponKopurua >= 0)
			printLapikoPuskak(txanponKopurua);
		System.out.println();
	}

	private synchronized void printLapikoPuskak(int pk) {
		System.out.print('[');
		for (int i = 0; i < pk; i++) {
			System.out.print('*');
		}
		for (int i = 0; i < txanponMaximoa - (pk); i++) {
			System.out.print(' ');
		}
		System.out.print(']');
	}
}
