package commands;

import java.io.File;

import org.json.JSONObject;

public class DrinkOrderCommand extends Command {
	public DrinkOrderCommand(JSONObject fileContents, File commandFile){
		super(commandFile, fileContents);
	}

}
