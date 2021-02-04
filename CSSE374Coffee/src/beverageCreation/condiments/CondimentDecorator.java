package beverageCreation.condiments;

import beverageCreation.Beverage;

public abstract class CondimentDecorator implements Beverage{
	
	
	private Beverage innerBeverage;
	private float cost;
	public CondimentDecorator(Beverage beverage) {
		this.innerBeverage = beverage;
	}
	
	public float getCost() {
		return this.cost;
	}
	
	public void setCost(float cost) {
		this.cost = cost;
	
	}
	
	
	public float calculateCost() {
		return this.cost + innerBeverage.calculateCost();

		
	}
}
