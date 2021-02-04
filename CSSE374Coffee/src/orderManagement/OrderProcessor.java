package orderManagement;

import beverageCreation.BeverageFactory;
import beverageCreation.CoffeeFactory;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.*;




public class OrderProcessor implements Observer{
	private BeverageFactory coffeeFactory;
	private OrderObtainer orderObtainer;


	public OrderProcessor(OrderObtainer orderObtainer) {
		orderObtainer.registerObserver(this);
		this.orderObtainer = orderObtainer;
		// is it okay to instantiate this here?
		//would make sense to instantiate based on the order,
		//but an order could have both tea and coffee and require the tea
		//factory and coffee factory for a single order
		//could just use a BeverageFactory pointer and swap back and forth
		//based on the drink
		this.coffeeFactory = new CoffeeFactory();
	}
	
	
	
	
	public void pullParseOrder() {
		String data = orderObtainer.pullOrderFileData();
		JSONObject outerJson = new JSONObject(data);
	    JSONObject orderJson = outerJson.getJSONObject("order");
	    JSONObject addressJson = orderJson.getJSONObject("address");
	    JSONArray condimentsJson = orderJson.getJSONArray("condiments");
	    
		int orderID = orderJson.getInt("orderID");
		String street = addressJson.getString("street");
		int zip = addressJson.getInt("ZIP");
		String drink = orderJson.getString("drink");

		HashMap<String, Integer> condimentsMap = new HashMap<String, Integer>();
		
		for (int i = 0; i < condimentsJson.length(); i++) {
			JSONObject condiment = (JSONObject) condimentsJson.get(i);
			String name = condiment.getString("name");
			Integer qty = condiment.getInt("qty");
			condimentsMap.put(name, qty);
		}
		

		
	}
	
	
	
	
	/**
	 * @param street
	 * @param zip
	 * Find a drinkmaker machine using street and zip
	 */
	public void findMaker(String street, int zip) {
		
	}
	
	@Override
	public void update() {
		this.pullParseOrder();



		// TODO Auto-generated method stub
		
	}

}
