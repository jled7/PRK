public class Krono1 extends Thread {

	private int i = 10;

	public void run() {
		while (true) {
			if (i > 0) {
				tik();
				--i;
			}
			if (i == 0) {
				alarma();
				return;
			}
		}
	}
	
	private void tik() {
		System.out.println(i);
		try {
			sleep(1000);
		} catch (InterruptedException e) {
		}
	}
	
	private void alarma() {
		System.out.println("Bukatu da.");
	}

}
