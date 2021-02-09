package commands;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import beverageCreation.Beverage;

public class SimpleCommandFactory extends CommandFactory {
	
	private String commandFilename = "Command.json";
	
	public void unwrapBeverageData(Beverage beverage) {
		
		
	}


	@Override
	public Command produceDrinkOrderCommand(Beverage beverage, int controllerID, int machineID, int orderID) {
		JSONObject command = new JSONObject();
		command.put("controller_id", controllerID);
		command.put("coffee_machine_id", machineID);
		command.put("orderID", orderID);
		//we know this because it is a simple factory!
		command.put("Requesttype", "Simple");
		
		
		
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
		FileWriter fileWriter = null;
        try {
        	fileWriter = new FileWriter(commandFile.getName());
			fileWriter.write(outerObj.toString(2));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fileWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
        
        //return a pointer to the command file
        DrinkOrderCommand machineCommand = new DrinkOrderCommand(outerObj, commandFile);
        return machineCommand;
		
		
	}
	

	/**
	 * returns a pointer to the created file hopefully
	 * @param filename
	 * @return
	 */
	public File createFile(String filename) {
		File commandJSON = null;
			try {
			commandJSON = new File(filename);
			if (commandJSON.createNewFile()) {
	        	System.out.println("File created: " + commandJSON.getName());
	      	} else {
	        	System.out.println("File already exists.");
	      	}
	    	} catch (IOException e) {
	      	System.out.println("An error occurred.");
	      	e.printStackTrace();
	    	}
		return commandJSON;
			
	}

}
