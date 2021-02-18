package orderManagement;

import beverageCreation.Beverage;
import beverageCreation.BeverageProducer;
import commands.AdvancedCommandFactory;
import commands.Command;
import commands.CommandFactory;
import commands.ProgrammableCommandFactory;
import commands.SimpleCommandFactory;
import dataLayer.ShopInitializer;
import machineCommunication.AdvancedBehavior;
import machineCommunication.CapabilityBehavior;
import machineCommunication.DrinkMaker;
import machineCommunication.SimpleBehavior;
import shop.Controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.*;




public class OrderProcessor implements Observer{
	private BeverageProducer beverageProducer;
	private OrderObtainer orderObtainer;
	private LocationDeterminer locationDeterminer;


	public OrderProcessor(OrderObtainer orderObtainer) {
		orderObtainer.registerObserver(this);
		this.locationDeterminer = new LocationDeterminer();


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
	    JSONArray condimentsJson = null;
	    if (orderJson.has("condiments")) {
	    	condimentsJson = orderJson.getJSONArray("condiments");
	    	
	    }
	    
		int orderID = orderJson.getInt("orderID");
		String street = addressJson.getString("street");
		int zip = addressJson.getInt("ZIP");
		String drink = orderJson.getString("drink");

		HashMap<String, Integer> condimentsMap = new HashMap<String, Integer>();
		if (condimentsJson != null) {
			
			for (int i = 0; i < condimentsJson.length(); i++) {
				JSONObject condiment = (JSONObject) condimentsJson.get(i);
				String name = condiment.getString("name");
				Integer qty = condiment.getInt("qty");
				condimentsMap.put(name, qty);
			}	
		}
		

		Beverage beverage = beverageProducer.produceBeverage(drink, condimentsMap);		
		

		
		ArrayList<Controller> controllers = locationDeterminer.findControllers(street, zip);
		Controller controller = locationDeterminer.selectController(controllers);

		DrinkMaker drinkMaker = locationDeterminer.selectDrinkMaker(controller);
		
		//set the behavior of the drinkMaker that will be used for communication
		beverageProducer.addDrinkMakerBehvaior(drinkMaker);
		
		//set the command type based on the type of drinkMaker
		

		CommandFactory commandFactory = generateCommandFactoryType(drinkMaker);
		//produce JSON for being sent to the physical coffee maker
		Command command = commandFactory.produceDrinkOrderCommand(beverage, controller.getID(), drinkMaker.getID(), orderID);
		
		drinkMaker.getBehavior().sendOrder(command);
	}
	
	public CommandFactory generateCommandFactoryType(DrinkMaker drinkMaker) {
		switch(drinkMaker.getType()) {
		case "Automated":
			return new AdvancedCommandFactory();
		case "Simple":
			return new SimpleCommandFactory();
		case "Programmable":
			return new ProgrammableCommandFactory();
			}
		System.out.println("invalid command factory type");
		return null;
	}
	

	
	@Override
	public void update() {
		this.pullParseOrder();



		// TODO Auto-generated method stub
		
	}

}
