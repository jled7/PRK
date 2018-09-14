public class IrakurriIdatziSegurua implements IrakurriIdatzi {
  private int irakurleak = 0;
  private boolean idazten = false;

  public synchronized void eskuratuIrakurri()
            throws InterruptedException {
    while (idazten) wait();
    ++irakurleak;
  }

  public synchronized void askatuIrakurri() {
    --irakurleak;
    if(irakurleak==0) notify();
  }
public synchronized void eskuratuIdatzi()
              throws InterruptedException {
    while (irakurleak>0 || idazten) wait();
    idazten = true;
  }

  public synchronized void askatuIdatzi() {
    idazten = false;
    notifyAll();
  }
}