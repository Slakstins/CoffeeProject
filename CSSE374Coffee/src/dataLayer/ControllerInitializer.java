package dataLayer;

public class ControllerInitializer {
	public ArrayList<Controller> controllers;
	
	public ControllerInitializer(){
		for(i = 1; i <= 10; i++){
//			ArrayList<DrinkMaker> dm = ArrayList<DrinkMaker>();
//			dm.add(DrinkMakerInitializer.get(i - 1));
//			dm.add(DrinkMakerInitializer.get(i + 4));
			controllers.add(Controller(i));
		}
	}
}
