package dataLayer;

import java.util.ArrayList;

import machineCommunication.DrinkMaker;
import shop.Controller;
import shop.Shop;

public class ShopInitializer {
	private ArrayList<Shop> shops;
	int controllerId = 0;
	int machineId = 0;
	
	public ShopInitializer(){
		//Initialize shops one by one with addresses
		shops = new ArrayList<Shop>();
		Shop newShop = new Shop("200 N Main", 47803);
		addControllers(newShop, 2);
		shops.add(newShop);
		//add a number of controllers to each shop
		Shop shop2 = new Shop("200 N Main", 47803);
		addControllers(shop2, 1);
		shops.add(shop2);
		//shop3
		Shop shop3 = new Shop("200 N Main", 47803);
		addControllers(shop3, 3);
		shops.add(shop3);
		
	}
	
	public ArrayList<Controller> findControllers(String address, int zip) {
		for (int i = 0; i < shops.size(); i++) {
			Shop shop = shops.get(i);
			if (shop.getAddress().equals(address) && zip == shop.getZip()) {
				return shop.getControllers();
			}
			
		}
		System.out.println("no controllers for specified address");
		return null;

		
	}
	
	
	public void addControllers(Shop shop, int count) {
		ArrayList<Controller> controllers = new ArrayList<Controller>();
		for (int i = 0; i < count; i++) {
			Controller newController = new Controller(controllerId);
			addDrinkMakers(newController);
			controllers.add(newController);
			controllerId++;
		}
		shop.setControllers(controllers);
	}
	
	public void addDrinkMakers(Controller controller) {
		ArrayList<DrinkMaker> drinkMakers = new ArrayList<DrinkMaker>();
		switch(controllerId) {
		case 0:
			drinkMakers.add(new DrinkMaker(machineId++, "Automated"));
			drinkMakers.add(new DrinkMaker(machineId++, "Simple"));
			controller.setDrinkMakers(drinkMakers);
			break;
		case 1:
			drinkMakers.add(new DrinkMaker(machineId++, "Simple"));
			controller.setDrinkMakers(drinkMakers);
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		case 7:
			break;
		case 8:
			break;
		default:
			System.out.println("not enough controllers defined");
		
		}
	}
	
}
