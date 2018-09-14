
public class KotxeUrdina extends Thread {
    Zubia zubia;
    Pantaila pantaila;
    int zenb;
    KotxeUrdina(Zubia z, Pantaila p, int zenb) {
        this.zenb = zenb;
        zubia = z;
        pantaila = p;
    }
    public void run() {
      try {
        while(true) {
            while (!pantaila.mugituUrdina(zenb))	// mugitu zubitik kanpoan
            	sleep(500+(int)(2000*Math.random()));
            zubia.sartuUrdina();					// eskatzen du zubiaren atzipena
    		while (pantaila.mugituUrdina(zenb)) 	// mugitu zubiaren barruan
    			sleep(500+(int)(2000*Math.random()));
            zubia.irtenUrdina();					// askatzen du zubiaren atzipena
        }
      } catch (InterruptedException e){}
    }
}