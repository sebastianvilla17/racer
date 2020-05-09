package model;

import java.util.ArrayList;

public class Race {

	private ArrayList<NumberAL> numberList = new ArrayList<NumberAL>();
	
	////////////////////ArrayList///////////////
	
	/////iteratives///////////

	public void addArrayListI(long number) {

		NumberAL tmp = new NumberAL(number);
		numberList.add(tmp);

	}

	public void deleteArrayListI(long number) {

		for (int i = 0; i < numberList.size(); i++) {

			if (numberList.get(i).getNumber() == number) {

				numberList.remove(i);
			}
		}
	}

	public void searchArrayListI(long number) {

		int search = 0;
		for (int i = 0; i < numberList.size(); i++) {

			if (numberList.get(i).getNumber() == number) {
				search = 1;

			}
		}
		if (search == 0) {

		}
	}
//////////////recursive///////////////////////
}
