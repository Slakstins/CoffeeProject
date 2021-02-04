package beverageCreation;

import java.util.HashMap;

import beverageCreation.condiments.CondimentDecorator;

public class BeverageProducer {
	
	public BeverageProducer() {
		
	}

	public Beverage produceBeverage(String drink, HashMap<String, Integer> condimentsMap) {
		//if we wanted a noncoffee drink such as tea, we could add a switchboard here for the names
		// of drinks or use a field in JSON
		
		Coffee coffeeDrink = new Coffee(drink);
		Beverage bPointer = coffeeDrink;
		
		for (String condimentName : condimentsMap.keySet()) {
			CondimentDecorator newDecorator = new CondimentDecorator(bPointer, condimentName, condimentsMap.get(condimentName));
			bPointer = newDecorator;
		}
		//bPointer should now have the wrapped version of the drink
		return bPointer;
		
		
		// TODO Auto-generated method stub
		
	}

}
