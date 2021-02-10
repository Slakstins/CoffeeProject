package testing;
import static org.junit.Assert.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import orderManagement.OrderObtainer;
import orderManagement.OrderProcessor;
import presentationLayer.AppCommunicator;

class CoffeeTests {

	@org.junit.Test
	void test() {
		fail("Not yet implemented");
	}
	
	
	@org.junit.Test
	void otherTest() throws Exception {
		OrderObtainer orderObtainer = new OrderObtainer();
		AppCommunicator appCommunicator = new AppCommunicator(orderObtainer);
		OrderProcessor orderProcessor = new OrderProcessor(orderObtainer);
		orderObtainer.obtainOrderJson(1);

		byte[] file = null;
		String fileString = null;
		JSONObject outerJson = null;
		JSONObject orderJson = null;
		JSONObject addressJson = null;
		JSONArray condimentsJson = null;
		int orderID = 0;
		String street = null;
		int zip = 0;
		String drink = null;
		
		//test order 1
		String first = "./order-input" + 1 + ".json";
		try {
			file = (Files.readAllBytes(Paths.get(first)));
		    fileString = new String(file);
		}
		catch (Exception e) {
			e.printStackTrace();
		}	

		outerJson = new JSONObject(fileString);
	    orderJson = outerJson.getJSONObject("order");
	    addressJson = orderJson.getJSONObject("address");
	    condimentsJson = orderJson.getJSONArray("condiments");
	    
		orderID = orderJson.getInt("orderID");
		street = addressJson.getString("street");
		zip = addressJson.getInt("ZIP");
		drink = orderJson.getString("drink");

	    assertEquals(street, "200 N. Main");
	    assertEquals(orderID, 1);
	    assertEquals(zip, 47803);
	    assertEquals(drink, "Americano");
	    
	    //test order 2
	    String second = "./order-input" + 2 + ".json";
	    try {
			file = (Files.readAllBytes(Paths.get(second)));
		    fileString = new String(file);
		}
		catch (Exception e) {
			e.printStackTrace();
		}	

		outerJson = new JSONObject(fileString);
	    orderJson = outerJson.getJSONObject("order");
	    addressJson = orderJson.getJSONObject("address");
	    condimentsJson = orderJson.getJSONArray("condiments");
	    
		orderID = orderJson.getInt("orderID");
		street = addressJson.getString("street");
		zip = addressJson.getInt("ZIP");
		drink = orderJson.getString("drink");

	    assertEquals(street, "200 N. Main");
	    assertEquals(orderID, 2);
	    assertEquals(zip, 47803);
	    assertEquals(drink, "Expresso");
	    
	    //test order 3
	    
	    String third = "./order-input" + 3 + ".json";
	    try {
			file = (Files.readAllBytes(Paths.get(third)));
		    fileString = new String(file);
		}
		catch (Exception e) {
			e.printStackTrace();
		}	

		outerJson = new JSONObject(fileString);
	    orderJson = outerJson.getJSONObject("order");
	    addressJson = orderJson.getJSONObject("address");
	    condimentsJson = orderJson.getJSONArray("condiments");
	    
		orderID = orderJson.getInt("orderID");
		street = addressJson.getString("street");
		zip = addressJson.getInt("ZIP");
		drink = orderJson.getString("drink");

	    assertEquals(street, "200 N. Main");
	    assertEquals(orderID, 3);
	    assertEquals(zip, 47803);
	    assertEquals(drink, "Pumpkin Spice");
	    
	}
	

}
