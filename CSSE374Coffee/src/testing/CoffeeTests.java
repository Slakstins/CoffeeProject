package testing;
import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import orderManagement.OrderObtainer;
import orderManagement.OrderProcessor;
import presentationLayer.AppCommunicator;

class CoffeeTests {

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	
	@Test
	void otherTest() {
		OrderObtainer orderObtainer = new OrderObtainer();
		AppCommunicator appCommunicator = new AppCommunicator(orderObtainer);
		OrderProcessor orderProcessor = new OrderProcessor(orderObtainer);
		orderObtainer.obtainOrderJson(1);

		byte[] file = null;
		String fileString = null;
		String first = "./order-input" + 1 + ".json";
		try {
			file = (Files.readAllBytes(Paths.get(first)));
		    fileString = new String(file);
		}
		catch (Exception e) {
			e.printStackTrace();
		}	
		JSONObject outerJson = new JSONObject(fileString);

	    JSONObject orderJson = outerJson.getJSONObject("order");
	    JSONObject addressJson = orderJson.getJSONObject("address");
	    JSONArray condimentsJson = orderJson.getJSONArray("condiments");
	    
		int orderID = orderJson.getInt("orderID");
		String street = addressJson.getString("street");
		int zip = addressJson.getInt("ZIP");
		String drink = orderJson.getString("drink");

	    assertEquals(street, "200 N Main");
	}

}
