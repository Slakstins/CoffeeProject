package orderManagement;

import java.util.ArrayList;

import dataLayer.ShopInitializer;
import machineCommunication.DrinkMaker;
import shop.Controller;

public class LocationDeterminer {

	private ShopInitializer shopInitializer;
	public LocationDeterminer() {
		shopInitializer = new ShopInitializer();
	}
	
	public ArrayList<Controller> findControllers(String street, int zip){
		return shopInitializer.findControllers(street, zip);
		
	}
	
	//Could be implemented by adding more traits to controllers such as
	//"Busy". For an example, just select the first one
	public Controller selectController(ArrayList<Controller> controllers) {
		return controllers.get(0);
	}
	
	public DrinkMaker selectDrinkMaker(Controller controller) {
		return controller.findMaker();
	}
	
	
	
}
