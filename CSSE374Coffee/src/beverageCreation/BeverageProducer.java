package beverageCreation;

import java.util.HashMap;

import beverageCreation.condiments.CondimentDecorator;
import machineCommunication.AdvancedBehavior;
import machineCommunication.CapabilityBehavior;
import machineCommunication.DrinkMaker;
import machineCommunication.SimpleBehavior;

public class BeverageProducer {
	
	public BeverageProducer() {
		
	}

	public Beverage produceBeverage(String drink, HashMap<String, Integer> condimentsMap) {
		//if we wanted a noncoffee drink such as tea, we could add a switchboard here for the names
		// of drinks or use a field in JSON
		
		Coffee coffeeDrink = new Coffee(drink);
		Beverage bPointer = coffeeDrink;
		
		if (condimentsMap != null) {
			for (String condimentName : condimentsMap.keySet()) {
				CondimentDecorator newDecorator = new CondimentDecorator(bPointer, condimentName, condimentsMap.get(condimentName));
				bPointer = newDecorator;
			}
		}

		//bPointer should now have the wrapped version of the drink or a base drink
		return bPointer;
		
		
		// TODO Auto-generated method stub
		
	}

	
	//move to beverage producer
	public void addDrinkMakerBehvaior(DrinkMaker maker) {
		String type = maker.getType();
		CapabilityBehavior behavior = null;
		switch(type) {
		case "Automated":
			behavior = new AdvancedBehavior();
			break;
		case "Simple":
			behavior = new SimpleBehavior();
			break;
		case "Programmable":
			//do we need another behavior for this???
			behavior = new AdvancedBehavior();
			break;
		default:
			System.out.println("machine type not supported in OrderProcessor.addDrinkBehavior()");
			break;

		}
		
		maker.setBehavior(behavior);

		
	}
	
}
