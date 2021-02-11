package machineCommunication;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

import commands.Command;
import presentationLayer.AppCommunicator;

public class AdvancedBehavior implements CapabilityBehavior {
	public void sendOrder(Command command){
		System.out.println("order sent to advanced machine");
		
		System.out.println("response retrieved from machine");
		
		JSONObject response = generateMachineResponse(command);
		
		AppCommunicator appCommunicator = AppCommunicator.getInstance();
		JSONObject appJSON = this.formatAppResponse(command.getCommandJSON(), response);

		appCommunicator.sendReturnMessage(appJSON);
		
	}
	
	private JSONObject formatAppResponse(JSONObject command, JSONObject machineResponse) {
		//need orderID, coffee_machine_id, status, status-message, *error-message
		JSONObject appResponse = new JSONObject();
		
		
		int orderID = machineResponse.getInt("orderID");
		int coffeeMachineId = command.getInt("coffee_machine_id");
		int status = machineResponse.getInt("status");
		String statusMessage = "Your coffee hase been prepared with you desired options.";
		if (status != 0) {
			statusMessage = "Your coffee order has been cancelled";
			String errorMessage = machineResponse.getString("errordesc");
			appResponse.put("error-message", errorMessage);
		}
		
		appResponse.put("orderID", orderID);
		appResponse.put("coffee_machine_id", coffeeMachineId);
		appResponse.put("status", status);
		appResponse.put("status-message", statusMessage);


		return appResponse;
		
	}
	
	/**This method is NOT FUNCIONAL. there is no real coffee machine. 
	 * Instead, check the orderID and generate any necessary responses.
	 * @param command
	 * @return
	 */
	public JSONObject generateMachineResponse(Command command) {
		JSONObject commandJSON = command.getCommandJSON();
		JSONObject machineResponse = new JSONObject();
		int orderID = commandJSON.getInt("orderID");
		machineResponse.put("orderID", orderID);
		int status = 0;
		
		//check for errors.
		switch(orderID) {
		case 2:
			status = 1;
			machineResponse.put("errordesc", "Out of milk, drink cancelled");
			machineResponse.put("errorcode", 2);
			break;
		case 3:
			status = 1;
			machineResponse.put("errordesc", "Machine jammed");
			machineResponse.put("errorcode", 26);
			break;
		}
		
		machineResponse.put("status", status);
		JSONObject outerObj = new JSONObject();
		outerObj.put("drinkresponse", machineResponse);
		
		File commandFile = createFile("MachineResponse.json");
		//write the JSONObject to the command file
        try {
        	FileWriter fileWriter = new FileWriter(commandFile.getName());
			fileWriter.write(outerObj.toString(2));
			fileWriter.close();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

		return machineResponse;

		
		
		
	}
	
	public File createFile(String filename) {
		File commandJSON = null;
			try {
			commandJSON = new File(filename);
			if (commandJSON.createNewFile()) {
	        	System.out.println("File created: " + commandJSON.getName());
	      	}
	    	} catch (IOException e) {
	      	System.out.println("An error occurred.");
	      	e.printStackTrace();
	    	}
		return commandJSON;
	}
	
	
}