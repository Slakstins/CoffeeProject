package beverageCreation.condiments;

import java.util.ArrayList;

import beverageCreation.Beverage;

public class CondimentDecorator implements Beverage{
	
	
	private Beverage innerBeverage;
	private String condimentName;
	private int quantity;
	
	
	public CondimentDecorator(Beverage beverage, String condimentName, Integer howMany) {
		this.innerBeverage = beverage;
		this.condimentName = condimentName;
		this.quantity = howMany;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getAsString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Beverage unwrapDrink() {
		return innerBeverage;
	}

	@Override
	public Integer getQty() {
		return this.quantity;
	}
	
}
