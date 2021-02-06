package commands;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import beverageCreation.Beverage;

public class SimpleCommandFactory extends CommandFactory {
	
	public void unwrapBeverageData(Beverage beverage) {
		
		
	}


	/**
	 *might want to put this in the superclass so it's in both. How will this vary from simple to advanced
	 *Controllers?
	 */
	@Override
	public void produceDrinkOrderCommand(Beverage beverage, int controllerID, int machineID, int orderID,
			String requestType) {
		JSONObject command = new JSONObject();
		command.put("controller_id", controllerID);
		command.put("coffee_machine_id", machineID);
		command.put("orderID", orderID);
		command.put("Requesttype", requestType);
		
		
		
		JSONArray condiments = new JSONArray();
		Beverage bPointer = beverage;


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
		
		createFile("Command.json");
		

        try {
        	FileWriter fileWriter = new FileWriter("Command.json");
			fileWriter.write(outerObj.toString(2));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		
	}
	
	public void createFile(String filename) {
		try {
		File commandJSON = new File(filename);
		if (commandJSON.createNewFile()) {
	        System.out.println("File created: " + commandJSON.getName());
	      } else {
	        System.out.println("File already exists.");
	      }
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
			
	}

}
