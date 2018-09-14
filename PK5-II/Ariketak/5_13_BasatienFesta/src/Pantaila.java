import java.io.IOException;

public class Pantaila {
	private int puskaMaximoa, basatiKopurua;

	
	public Pantaila(int puskaMaximoa, int basatiKopurua) {
		this.puskaMaximoa = puskaMaximoa;
		this.basatiKopurua = basatiKopurua;
	}
	
	public synchronized void hasieratu() {
		System.out.print("Txalupa");
		for (int i = 0; i < basatiKopurua; i++) {
			System.out.print("\t\tb[" + i + "]");
		}
		System.out.println("\t\tSukald\t|| \tHondartza\tHozkailua\tLapikoa");
		for (int i = 0; i < basatiKopurua; i++) {
			System.out.print("================================");
		}
		System.out.println("=========================");
	}

	public synchronized void margotu(int id, String string, int misiolariKopurua, int hozkailuarenKopurua, int puskaKopurua) {
		if (id < 0) {
			System.out.print(string+"\t");
			for (int i = 0; i < basatiKopurua + 1; i++) {
				System.out.print("\t\t");
			}
		} else {
			for (int i = 0; i < id + 1; i++) {
				System.out.print("\t\t");
			}
			System.out.print(string + "\t");
			for (int i = 0; i < basatiKopurua + 1 - (id + 1); i++) {
				System.out.print("\t\t");
			}
		}
		if(string.length() < 8)
			System.out.print("\t");
		if(misiolariKopurua >= 0)
			printPuskak(misiolariKopurua, BasatienFestaApp.MISIOLARI_KOPURUA);
		System.out.print("\t");
		if(hozkailuarenKopurua >= 0)
			printPuskak(hozkailuarenKopurua, BasatienFestaApp.HOZKAILUAREN_TAMAINA);
		System.out.print("\t");
		if(puskaKopurua >= 0)
			printPuskak(puskaKopurua, BasatienFestaApp.PUSKA_MAXIMOAK);
		System.out.println();
	}

	private synchronized void printPuskak(int pk, int maximoa) {
		System.out.print('[');
		for (int i = 0; i < pk; i++) {
			System.out.print('*');
		}
		for (int i = 0; i < maximoa - (pk); i++) {
			System.out.print(' ');
		}
		System.out.print(']');
	}
}
