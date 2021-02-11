package commands;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import beverageCreation.Beverage;

public class AdvancedCommandFactroy extends CommandFactory {

	private String commandFilename = "Command.json";
	
		


	/**
	 *might want to put this in the superclass so it's in both. How will this vary from simple to advanced
	 *Controllers?
	 */
	@Override
	public Command produceDrinkOrderCommand(Beverage beverage, int controllerID, int machineID, int orderID) {
		JSONObject command = new JSONObject();
		command.put("controller_id", controllerID);
		command.put("coffee_machine_id", machineID);
		command.put("orderID", orderID);
		//we know this because it is an advanced factory!
		command.put("Requesttype", "Automated");
		
		
		
		JSONArray condiments = new JSONArray();
		Beverage bPointer = beverage;
		//get all of the condiments. Save the innermost drink pointer
		while(bPointer.unwrapDrink() != null) {
			JSONObject condiment = new JSONObject();
			condiment.put("Name", bPointer.getAsString());
			condiment.put("qty", bPointer.getQty());

			condiments.put(condiment);

			bPointer = bPointer.unwrapDrink();
		}
		command.put("DrinkName", bPointer.getAsString());
		command.put("Options", condiments);

		JSONObject outerObj = new JSONObject();
		outerObj.put("command", command);
		
		File commandFile = createFile(commandFilename);
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
        
        //return a pointer to the command file
        DrinkOrderCommand machineCommand = new DrinkOrderCommand(command, commandFile);
        return machineCommand;
	}

}
