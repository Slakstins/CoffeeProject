package machineCommunication;

public class DrinkMaker {
	private int ID;
	private String type;
	private CapabilityBehavior behavior;
	
	
	public DrinkMaker(int ID, String type) {
		this.ID = ID;
		this.type = type;
	}

	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getType() {
		// TODO Auto-generated method stub
		return type;
	}

	public CapabilityBehavior getBehavior() {
		return behavior;
	}

	public void setBehavior(CapabilityBehavior behavior) {
		this.behavior = behavior;
	}
	

}
