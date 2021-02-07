package shop;

import java.util.ArrayList;

import machineCommunication.DrinkMaker;

public class Controller {
	private int ID;
	private ArrayList<DrinkMaker> drinkMakers;

	public Controller(int ID) {
		this.ID = ID;
		
	}
	

	/**
	 * look through drinkMakers and find one that is not busy
	 * @return
	 */
	public DrinkMaker findMaker() {

		return null;
	}
	
	public void setDrinkMakers(ArrayList<DrinkMaker> drinkMakers) {
		this.drinkMakers = drinkMakers;
	}

	public int getID() {
		// TODO Auto-generated method stub
		return this.ID;
	}
	

}
