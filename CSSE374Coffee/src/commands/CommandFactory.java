package commands;

import java.io.File;
import java.io.IOException;

import beverageCreation.Beverage;

public abstract class CommandFactory {
	//might return a file
	//request type is based on the behavior of the machine. Might have this implemented by using getType() on behavior. Better way?
	public abstract Command produceDrinkOrderCommand(Beverage beverage, int controllerID, int machineID, int orderID);

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
	      	}
	    	} catch (IOException e) {
	      	System.out.println("An error occurred.");
	      	e.printStackTrace();
	    	}
		return commandJSON;
	}

}
