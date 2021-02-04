package beverageCreation;

import java.util.HashMap;

public class CoffeeFactory extends BeverageFactory {
	CoffeeFactory(){
		
	}

	@Override
	public Beverage prepareBeverage(String drinkBase, HashMap<String, Integer> condiments) {

		return null;
	}

	//need to handle for sizes. Probably with a size field in Beverage
	//need to check every drink to see if it has a valid size word first
	@Override
	public Beverage makeBaseDrink(String drinkBase) {
		Coffee coffee = new Coffee(null);
		switch (drinkBase) {
		case "Americano":

			break;
		case "Expresso":
			break;
		
		case "Latte":
			break;
		case "Pumpkin Spice":
			break;
		
		
		
		}


		return null;
	}
	
	
	
	
	
	

}
