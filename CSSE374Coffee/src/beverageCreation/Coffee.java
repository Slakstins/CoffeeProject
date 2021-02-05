package beverageCreation;

import java.util.ArrayList;

import beverageCreation.condiments.CondimentDecorator;

public class Coffee implements Beverage{
	
	private String coffeeType;
	
	public Coffee(String coffeeType) {
		this.coffeeType = coffeeType;
		
	}

	
	/**
	 *Returns null to signal that the base drink was
	 *found
	 */
	@Override
	public Beverage unwrapDrink() {
		return null;
	}

	@Override
	public String getAsString() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Integer getQty() {
		// TODO Auto-generated method stub
		return 1;
	}
	
}
