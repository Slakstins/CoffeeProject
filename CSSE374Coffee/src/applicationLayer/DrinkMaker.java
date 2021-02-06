package shop;

public class DrinkMaker {
	private int ID;
	private CapabilityBehavior behavior;
	
	
	public DrinkMaker(int ID, CapabilityBehavior behavior) {
		this.ID = ID;
		this.behavior = behavior
	}

	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void executeBehavior(String Json){
		behavior.sendOrder(Json)
	}

}
