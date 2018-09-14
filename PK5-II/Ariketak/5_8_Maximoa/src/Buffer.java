public class Buffer {
	public int p = 0;
	public int i = MaximoaApp.ARRAY_TAMAINA;
	public int N = MaximoaApp.ARRAY_TAMAINA;
	public int[] array;

	public Buffer(int[] array) {
		this.array = array;
	}

	// when(i>=2) p[PR].hartu->[i-1]->[i-2]->AGENDA[i-2][p+1]
	synchronized int[] hartu(int id) throws InterruptedException {
		while (!(i >= 2))
			wait();
		int[] z = new int[2];
		z[0] = array[i - 2];
		z[1] = array[i - 1];
		array[i - 2] = -1;
		array[i - 1] = -1;
		Pantaila.margotu(id, "Hartu[" + z[0] +","+ z[1] + "]", array);

		i -= 2;
		p++;
		return z;
	}

	//			 p[PR].sartu->if(i==0 && p==1) then (emaitza->STOP)
	//										   else ([i]	->AGENDA[i+1][p-1])
	synchronized void sartu(int id, int haundiena) throws InterruptedException {
		array[i] = haundiena;
		Pantaila.margotu(id, "Sartu[" + haundiena + "]", array);
		if(i==0 && p==1) {
			Pantaila.margotu(id, "Emaitza -> " + haundiena, array);
			System.exit(0);
		}	
		i++;
		p--;

	}

}