package machineCommunication;

import commands.Command;

public class SimpleBehavior implements CapabilityBehavior {
	public void sendOrder(Command command){
		System.out.println("simple behavior");
	}
}
