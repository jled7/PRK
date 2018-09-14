
public class Zebrabidea {
	public int kotxeakItxoiten = 0;
	public int kotxeakPasatzen = 0;
	public int oinezkoakItxoiten = 0;
	public int oinezkoakPasatzen = 0;
	public boolean txanda =	false;
	
	public Zebrabidea() {

	}
	
	//  oinezkoa[OID].iritxi->				  ZEBRABIDEA[ ki ][ kz ][oi+1][ oz ][ tx ]
	synchronized void iritxiO(int id) throws InterruptedException {
		oinezkoakItxoiten++;
		Pantaila.margotu(id+ZebrabideaApp.KOTXE_KOPURUA, "iritxi");
		Pantaila.margotuDatuak(id+ZebrabideaApp.KOTXE_KOPURUA, kotxeakItxoiten, kotxeakPasatzen, oinezkoakItxoiten, oinezkoakPasatzen, txanda);
		notifyAll();
	}
	// when((kz == 0 && ki < 3) || (kz==0 && tx==1)) 		oinezkoa[OID].sartu ->if(ki >=3) then ZEBRABIDEA[ ki ][ kz ][oi-1][oz+1][ 0  ]
	//																						 else ZEBRABIDEA[ ki ][ kz ][oi-1][oz+1][ tx ]
	synchronized void sartuO(int id) throws InterruptedException {
		while (!((kotxeakPasatzen == 0 && kotxeakItxoiten < 3) || (kotxeakPasatzen==0 && txanda == true))) wait();
		oinezkoakItxoiten--;
		oinezkoakPasatzen++;
		if(kotxeakItxoiten >= 3) {
			txanda = false;
		}
		Pantaila.margotu(id+ZebrabideaApp.KOTXE_KOPURUA, "sartu");
		Pantaila.margotuDatuak(id+ZebrabideaApp.KOTXE_KOPURUA, kotxeakItxoiten, kotxeakPasatzen, oinezkoakItxoiten, oinezkoakPasatzen, txanda);
		
		notifyAll();
	}
	
	//						 							oinezkoa[OID].atera ->				  ZEBRABIDEA[ ki ][ kz ][ oi ][oz-1][ tx ]
	synchronized void ateraO(int id) throws InterruptedException {
		oinezkoakPasatzen--;
		Pantaila.margotu(id+ZebrabideaApp.KOTXE_KOPURUA, "atera");
		Pantaila.margotuDatuak(id+ZebrabideaApp.KOTXE_KOPURUA, kotxeakItxoiten, kotxeakPasatzen, oinezkoakItxoiten, oinezkoakPasatzen, txanda);
		
		
		notifyAll();
	}
	
	//  					 							kotxea[KID].iritxi  ->				  ZEBRABIDEA[ki+1][ kz ][ oi ][ oz ][ tx ]
	synchronized void iritxiK(int id) throws InterruptedException {
		kotxeakItxoiten++;
		Pantaila.margotu(id, "iritxi");
		Pantaila.margotuDatuak(id, kotxeakItxoiten, kotxeakPasatzen, oinezkoakItxoiten, oinezkoakPasatzen, txanda);
		
		
		notifyAll();
	}
	// when(oz == 0 && (oi == 0 || (ki >= 3 && tx==0)))	kotxea[KID].sartu   ->if(ki >=3) then ZEBRABIDEA[ki-1][kz+1][ oi ][ oz ][ 1  ]
	//																					 else ZEBRABIDEA[ki-1][kz+1][ oi ][ oz ][ tx ]
	synchronized void sartuK(int id) throws InterruptedException {
		while (!(oinezkoakPasatzen == 0 && (oinezkoakItxoiten == 0 || (kotxeakItxoiten >= 3 && txanda == false)))) wait();
		kotxeakItxoiten--;
		kotxeakPasatzen++;
		if(kotxeakItxoiten >= 3) {
			txanda = true;
		}	
		Pantaila.margotu(id, "sartu");
		Pantaila.margotuDatuak(id, kotxeakItxoiten, kotxeakPasatzen, oinezkoakItxoiten, oinezkoakPasatzen, txanda);

		notifyAll();
	}
	
	//						 							kotxea[KID].atera	->				  ZEBRABIDEA[ ki ][kz-1][ oi ][ oz ][ tx ]
	synchronized void ateraK(int id) throws InterruptedException {
		kotxeakPasatzen--;
		
		Pantaila.margotu(id, "atera");
		Pantaila.margotuDatuak(id, kotxeakItxoiten, kotxeakPasatzen, oinezkoakItxoiten, oinezkoakPasatzen, txanda);

		
		notifyAll();
	}
}