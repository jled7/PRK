public class IrakurriIdatziLehentasuna implements IrakurriIdatzi {
	private int irakurleak = 0;
	private boolean idazten = false;
	private int zaiW = 0; // zai dauden Idazleen kopurua.

	public synchronized void eskuratuIrakurri() throws InterruptedException {
		while (idazten || zaiW > 0)
			wait();
		++irakurleak;
	}

	public synchronized void askatuIrakurri() {
		--irakurleak;
		if (irakurleak == 0)
			notify();
	}

	synchronized public void eskuratuIdatzi() {
		++zaiW;
		while (irakurleak > 0 || idazten)
			try {
				wait();
			} catch (InterruptedException e) {
			}
		--zaiW;
		idazten = true;
	}

	synchronized public void askatuIdatzi() {
		idazten = false;
		notifyAll();
	}
}