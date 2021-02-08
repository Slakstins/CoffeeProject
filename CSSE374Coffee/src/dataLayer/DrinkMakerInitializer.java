package dataLayer;

public class DrinkMakerInitializer {
	public ArrayList<DrinkMaker> drinkMakers;
	
	public DrinkMakerInitializer(){
		
		for(i = 1; i <= 5; i++){
			drinkMaker.add(DrinkMaker(i, SimpleBehavior(), "simple"));
			drinkMaker.add(DrinkMaker(i + 5, AdvancedBehavior(), "advanced"));
		}
	}
}
