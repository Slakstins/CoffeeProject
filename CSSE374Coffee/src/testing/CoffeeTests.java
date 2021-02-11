package testing;
import static org.junit.Assert.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import beverageCreation.Beverage;
import beverageCreation.BeverageProducer;

import orderManagement.OrderObtainer;
import orderManagement.OrderProcessor;
import presentationLayer.AppCommunicator;

class CoffeeTests {

	@Test
	void testStrategyPattern() {
		//the JSON returned from the machine is produced by AdvancedBehavior but not by
		//simpleBehavior.

		//start up the system
		OrderObtainer orderObtainer = new OrderObtainer();
		AppCommunicator appCommunicator = AppCommunicator.getInstance();
		OrderProcessor orderProcessor = new OrderProcessor(orderObtainer);
		appCommunicator.setOrderObtainer(orderObtainer);
		
		assertTrue(testAStrategy(1, true, appCommunicator));
		assertTrue(testAStrategy(2, true, appCommunicator));
		assertTrue(testAStrategy(3, true, appCommunicator));
		//  4th order uses simpleBehavior, so it should not rewrite the MachineResponse file
		// and the orderID should be wrong.
		assertTrue(testAStrategy(4, false, appCommunicator));
	}
	
	@Test
	void testDecoratorPattern() {
		ArrayList<String> condimentsList = new ArrayList<String>();
		condimentsList.add("cream");
		condimentsList.add("salt");
		condimentsList.add("salt");
		condimentsList.add("whipped cream");
		
		HashMap<String, Integer> condimentMap = new HashMap<String, Integer>();
		condimentMap.put("cream", 1);
		condimentMap.put("salt", 2);
		condimentMap.put("whipped cream", 1);
		BeverageProducer beverageProducer = new BeverageProducer();

		
		Beverage testBeverage = beverageProducer.produceBeverage("Salty Creamy", condimentMap);
		//they unwrap in the opposite order they were added in using the hashmap
		int i = condimentsList.size() - 1;
		while (testBeverage.unwrapDrink() != null) {
			assertTrue(condimentsList.contains(testBeverage.getAsString()));
			condimentsList.remove(testBeverage.getAsString()); //ensures that the .contains has to find the 2nd salt
			testBeverage = testBeverage.unwrapDrink();
			i--;
		}
		assertEquals("Salty Creamy", testBeverage.getAsString());
	}
	
	@Test
	void testFactoryPattern() {
		// factory pattern is used to produce commands, so we can run the system
		// and check that the produced commandJSON files have the correct values

		//start up the system
		OrderObtainer orderObtainer = new OrderObtainer();
		AppCommunicator appCommunicator = AppCommunicator.getInstance();
		OrderProcessor orderProcessor = new OrderProcessor(orderObtainer);
		appCommunicator.setOrderObtainer(orderObtainer);	
		
		
		assertTrue(testAsCommand(1, "Americano", "Automated", appCommunicator));
		assertTrue(testAsCommand(2, "Expresso", "Automated", appCommunicator));
		assertTrue(testAsCommand(3, "Pumpkin Spice", "Automated", appCommunicator));
		assertTrue(testAsCommand(4, "Large Latte", "Simple", appCommunicator));
		
		
	}
	
	private boolean testAsCommand(int testOrderID, String drinkName, String type, AppCommunicator appCommunicator) {
		appCommunicator.sendOrderJson(testOrderID);
		byte[] file = null;
		String fileString = null;
		String first = "./Command.json";
		try {
			file = (Files.readAllBytes(Paths.get(first)));
		    fileString = new String(file);
		}
		catch (Exception e) {
			e.printStackTrace();
		}	
		JSONObject outerJson = new JSONObject(fileString);

	    JSONObject commandJSON = outerJson.getJSONObject("command");
	    String drinkNameMach = commandJSON.getString("DrinkName");
	    String requestType = commandJSON.getString("Requesttype");
	    
	    return (requestType.equals(type) && drinkName.equals(drinkNameMach));


		
		
		
	}
	
	private boolean testAStrategy(int testOrderID, boolean correctOutput, AppCommunicator appCommunicator) {
		appCommunicator.sendOrderJson(testOrderID);
		byte[] file = null;
		String fileString = null;
		String first = "./MachineResponse.json";
		try {
			file = (Files.readAllBytes(Paths.get(first)));
		    fileString = new String(file);
		}
		catch (Exception e) {
			e.printStackTrace();
		}	
		JSONObject outerJson = new JSONObject(fileString);

	    JSONObject drinkresponseJSON = outerJson.getJSONObject("drinkresponse");
	    int orderID = drinkresponseJSON.getInt("orderID");
	    
	    if (correctOutput == (orderID == testOrderID)) {
	    	return true;
	    	
	    }
	    return false;
	    

	}
	

}
