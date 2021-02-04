package orderManagement;

import beverageCreation.Beverage;
import beverageCreation.BeverageProducer;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.*;




public class OrderProcessor implements Observer{
	private BeverageProducer beverageProducer;
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
		this.beverageProducer = new BeverageProducer();
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

		Beverage beverage = beverageProducer.produceBeverage(drink, condimentsMap);		

		DrinkMaker drinkMaker = this.findMaker(street, zip);
		
		//drinkMaker.produceDrinkCommand();
		
	}
	
	
	
	/**
	 * @param street
	 * @param zip
	 * Find a drinkmaker machine using street and zip
	 * IMPLEMENT ME
	 */
	public DrinkMaker findMaker(String street, int zip) {
		return null;
		
	}
	
	@Override
	public void update() {
		this.pullParseOrder();



		// TODO Auto-generated method stub
		
	}

}
