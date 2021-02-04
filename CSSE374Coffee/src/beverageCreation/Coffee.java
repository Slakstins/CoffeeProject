package beverageCreation;

import beverageCreation.condiments.CondimentDecorator;

public class Coffee extends CondimentDecorator {
	private int coffeeDefaultCost;


	public Coffee(Beverage beverage) {
		super(beverage);
		this.coffeeDefaultCost = 2;
		super.setCost(coffeeDefaultCost);
	}
}
