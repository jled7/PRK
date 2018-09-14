
public class Bulegoa {
	public int ikasleSartuta = 0;
	public boolean galderaEginda = false, galderaErantzunda = false;
	
	//  when (s<2)   ikasle[IR].bulegoraSartu ->BULEGOA[s+1][ eg ][ er ]
	synchronized void bulegoraSartu(int id) throws InterruptedException {
		while(!(ikasleSartuta<2)) wait();
		ikasleSartuta++;
		Pantaila.margotu(id, erantzun("bulegoraSartu", id));
				
		notifyAll();
	}
	//  when (eg==0 && er==0) ikasle[IR].galderaEgin   ->BULEGOA[ s ][eg+1][ er ]
	synchronized void galderaEgin(int id) throws InterruptedException {
		while (!(galderaEginda == false && galderaErantzunda == false)) wait();
		galderaEginda = true;
		Pantaila.margotu(id, erantzun("galderaEgin", id));

		
		notifyAll();
	}
	//  when (eg==1) irakasle.galderaEntzun   ->BULEGOA[ s ][ eg ][ er ]
	synchronized void galderaEntzun() throws InterruptedException {
		while (!(galderaEginda == true)) wait();
		galderaEginda = true;
		Pantaila.margotu(-1, erantzun("galderaEntzun", -1));
		
		notifyAll();
	}
	
	//  when (eg==1) irakasle.galderaErantzun ->BULEGOA[ s ][eg-1][er+1]
	synchronized void galderaErantzun() throws InterruptedException {
		while (!(galderaEginda == true)) wait();
		galderaEginda = false;
		galderaErantzunda = true;
		Pantaila.margotu(-1, erantzun("galderaErantzun", -1));
		
		notifyAll();
	}
	
	synchronized void erantzunaJaso(int id) throws InterruptedException {
		while (!(galderaErantzunda == true)) wait();
		galderaEginda = false;
		galderaErantzunda = false;
		Pantaila.margotu(id, erantzun("erantzunaJaso", id));
		
		notifyAll();
	}
	
	synchronized void bulegotikAtera(int id) throws InterruptedException {
		while (!(ikasleSartuta > 0)) wait();
		ikasleSartuta--;
		Pantaila.margotu(id, erantzun("bulegotikAtera", id));
		
		
		notifyAll();
	}
	
	private synchronized String erantzun(String textua, int id) {
		String textuaR = textua;
		if(id >= 0) {
			for(int i = 0; i < TutoretzaApp.IKASLE_KOPURUA - (id); i++) {
				textuaR +="\t\t";
			}	
		}
		textuaR += "\t\t[";
		for(int i = 0;i < 2;i++) {
			if(ikasleSartuta <= i) {
				textuaR += " ";
			} else {
				textuaR += "*";
			}
		}
		textuaR += "]\t\t[";
		textuaR += galderaEginda ? "X" : " "; 
		textuaR += "]\t\t[";
		textuaR += galderaErantzunda ? "X" : " ";
		textuaR += "]";
		
		return textuaR;
	}
	public synchronized void pentsatzen() {
		Pantaila.margotu(-1, erantzun("Pentsatzen", -1));
	}
}