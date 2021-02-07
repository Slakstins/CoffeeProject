package commands;

import java.io.File;

import org.json.JSONObject;

public abstract class Command {
	private File commandFile;
	private JSONObject commandJSON;
	public Command(File commandFile, JSONObject commandJSON) {
		this.commandFile = commandFile;
		this.commandJSON = commandJSON;
	}


	public File getCommandFile() {
		return commandFile;
	}


	public JSONObject getCommandJSON() {
		return commandJSON;
	}

}
