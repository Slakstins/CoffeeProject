package presentationLayer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONException;
import org.json.JSONObject;

import orderManagement.OrderObtainer;


public class AppCommunicator {
	//singleton!
	private static AppCommunicator instance;
	private OrderObtainer orderObtainer;

	private AppCommunicator() {
	}
	
	public void setOrderObtainer(OrderObtainer orderObtainer) {
		this.orderObtainer = orderObtainer;
	}

	public String sendOrderJson(int orderExNumber) {
		String first = "./order-input" + orderExNumber + ".json";
		String fileData = null;
		try {
			byte[] file = (Files.readAllBytes(Paths.get(first)));
		    fileData = new String(file);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		orderObtainer.obtainOrderJson(fileData);
		return fileData;
		
	}	
	
	//lazy instantiation
	public static AppCommunicator getInstance(){
		if (instance == null) {
			instance = new AppCommunicator();
		}
		return instance;
	}

	
	public void sendReturnMessage(JSONObject userResponse) {
		JSONObject outerJSON = new JSONObject();
		outerJSON.put("UserResponse", userResponse);
		File userResponseFile = createFile("App-response.json");
		//write the JSONObject to the command file
		FileWriter fileWriter = null;
        try {
        	fileWriter = new FileWriter(userResponseFile.getName());
			fileWriter.write(outerJSON.toString(2));

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


        System.out.println("Return message added to file system");
        
		

		
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
