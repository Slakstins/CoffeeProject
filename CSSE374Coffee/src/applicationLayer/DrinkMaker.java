package shop;

public class DrinkMaker {
	private int ID;
	private CapabilityBehavior behavior;
	private String behaviorType
	
	
	public DrinkMaker(int ID, CapabilityBehavior behavior, String behaviorType) {
		this.ID = ID;
		this.behavior = behavior;
		this.behaviorType = behaviorType
	}

	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void executeBehavior(JSONObject Json){
		behavior.sendOrder(Json)
	}

}
