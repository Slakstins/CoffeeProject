package beverageCreation;

import java.util.HashMap;

public abstract class BeverageFactory {
	
	public abstract Beverage prepareBeverage(String drinkBase, HashMap<String, Integer> condiments);

	public abstract Beverage makeBaseDrink(String drinkBase);


}
