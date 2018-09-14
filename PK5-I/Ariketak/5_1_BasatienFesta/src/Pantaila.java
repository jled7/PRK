import java.io.IOException;

public class Pantaila {
	private int puskaMaximoa, basatienKopurua;

	
	public Pantaila(int puskaMaximoa) {
		this.puskaMaximoa = puskaMaximoa;
		this.basatienKopurua = BasatienFestaApp.BASATI_KOPURUA;
	}
	
	public synchronized void hasieratu() {
		System.out.print("s");
		for (int i = 0; i < basatienKopurua; i++) {
			System.out.print("\tb[" + i + "]");
		}
		System.out.println("\tLapikoa");
		for (int i = 0; i < basatienKopurua; i++) {
			System.out.print("========");
		}
		System.out.println("===============");
	}

	public synchronized void margotu(int id, String string, int puskaKopurua) {
		if (id < 0) {
			System.out.print("bete\t");
			for (int i = 0; i < basatienKopurua; i++) {
				System.out.print("\t");
			}
		} else {
			for (int i = 0; i < id + 1; i++) {
				System.out.print("\t");
			}
			System.out.print(string + "\t");
			for (int i = 0; i < basatienKopurua - (id + 1); i++) {
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

	public synchronized void hartu(int id, int pk, int puskaKopurua) {
		margotu(id, "hartu", puskaKopurua);
	}

	public synchronized void bete(int puskaKopurua) {
		margotu(-1, "bete", puskaKopurua);
		
		
	}
}
