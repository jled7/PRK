import java.io.IOException;

public class Pantaila {
	private int puskaMaximoa, basatiKopurua;

	
	public Pantaila(int puskaMaximoa, int basatiKopurua) {
		this.puskaMaximoa = puskaMaximoa;
		this.basatiKopurua = basatiKopurua;
	}
	
	public synchronized void hasieratu() {
		System.out.print("s");
		for (int i = 0; i < basatiKopurua; i++) {
			System.out.print("\tb[" + i + "]");
		}
		System.out.println("\tLapikoa");
		for (int i = 0; i < basatiKopurua; i++) {
			System.out.print("========");
		}
		System.out.println("===============");
	}

	public synchronized void margotu(int id, String string, int puskaKopurua) {
		if (id < 0) {
			System.out.print(string+"\t");
			for (int i = 0; i < basatiKopurua; i++) {
				System.out.print("\t");
			}
		} else {
			for (int i = 0; i < id + 1; i++) {
				System.out.print("\t");
			}
			System.out.print(string + "\t");
			for (int i = 0; i < basatiKopurua - (id + 1); i++) {
				System.out.print("\t");
			}
		}
		if(puskaKopurua >= 0)
			printLapikoPuskak(puskaKopurua);
		System.out.println();
	}

	private synchronized void printLapikoPuskak(int pk) {
		System.out.print('[');
		for (int i = 0; i < pk; i++) {
			System.out.print('*');
		}
		for (int i = 0; i < puskaMaximoa - (pk); i++) {
			System.out.print(' ');
		}
		System.out.print(']');
	}
}
