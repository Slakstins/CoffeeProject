package beverageCreation;

import beverageCreation.condiments.CondimentDecorator;

public class Coffee extends CondimentDecorator {
	private int coffeeDefaultCost;
	private String size = "small";


	//base drinks shouldn't have a superclass
	//probably easiest to just give it a null pointer
	public Coffee(Beverage beverage) {
		super(beverage);
		this.coffeeDefaultCost = 2;
		super.setCost(coffeeDefaultCost);
	}
	
}
