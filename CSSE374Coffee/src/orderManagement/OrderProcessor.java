package orderManagement;

import beverageCreation.BeverageFactory;
import beverageCreation.CoffeeFactory;
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
		int orderID = orderJson.getInt("orderID");
		System.out.println(orderID);

		


		
		
		
		
		
	}
	
	@Override
	public void update() {
		this.pullParseOrder();



		// TODO Auto-generated method stub
		
	}

}
