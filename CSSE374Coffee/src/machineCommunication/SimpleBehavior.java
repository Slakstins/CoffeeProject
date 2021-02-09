package machineCommunication;

import org.json.JSONObject;

import commands.Command;
import presentationLayer.AppCommunicator;

public class SimpleBehavior implements CapabilityBehavior {
	public void sendOrder(Command command){
		//no return message from machine for simple behavior
		System.out.println("command sent to simple machine");
		JSONObject appJSON = new JSONObject();
		JSONObject commandJSON = command.getCommandJSON();
		int orderID = commandJSON.getInt("orderID");
		int coffeeMachineId = commandJSON.getInt("coffee_machine_id");
		String statusMessage = "Command sent to simple machine.";
		appJSON.put("status-message", statusMessage);
		appJSON.put("orderID", orderID);
		appJSON.put("coffee_machine_id", coffeeMachineId);
		appJSON.put("status", 0);
		AppCommunicator appCommunicator = AppCommunicator.getInstance();
		appCommunicator.sendReturnMessage(appJSON);
	}
}
