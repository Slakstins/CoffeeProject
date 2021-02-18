package dataLayer;

import java.util.ArrayList;
import java.util.HashMap;

public class RecipeInitializer {
	
	private HashMap<String, ArrayList<String[]>> recipes;
	// in the String[], index 0 is commandstep. Index2 is condiment aka "object"
	
	public RecipeInitializer() {
		recipes = new HashMap<String, ArrayList<String[]>>();
		this.initializeRecipes();
		
	}
	
	public ArrayList<String[]> obtainRecipe(String drinkName){
		ArrayList<String[]> recipe = recipes.get(drinkName);
		if (recipe == null) {
			System.out.println("recipe does not exist for drink name. Sending without steps...");
			return null;
		}
		else {
			return recipe;
		}
	}
	
	private void initializeRecipes(){
		String drinkName1 = "Large Latte";
		ArrayList<String[]> cmd1 = new ArrayList<String[]>();
		String[] cmd1a = new String[]{"steam", "milk"};
		String[] cmd1b = new String[] {"add", "expresso"};
		String[] cmd1c = new String[] {"mix", null};
		String[] cmd1d = new String[] {"top", "whipped cream"};
		cmd1.add(cmd1a);
		cmd1.add(cmd1b);
		cmd1.add(cmd1c);
		cmd1.add(cmd1d);
		recipes.put(drinkName1, cmd1);
		
		
		String drinkName2 = "Pumpkin Spice";
		ArrayList<String[]> cmd2 = new ArrayList<String[]>();
		String[] cmd2a = new String[]{"add", "coffee"};
		String[] cmd2b = new String[] {"add", "pumpkin spice"};
		String[] cmd2c = new String[] {"mix", null};
		String[] cmd2d = new String[] {"top", "nutmeg"};
		cmd2.add(cmd2a);
		cmd2.add(cmd2b);
		cmd2.add(cmd2c);
		cmd2.add(cmd2d);
		recipes.put(drinkName2, cmd2);
		
		String drinkName3 = "Regular Latte";
		ArrayList<String[]> cmd3 = new ArrayList<String[]>();
		String[] cmd3a = new String[]{"steam", "milk"};
		String[] cmd3b = new String[] {"add", "expresso"};
		String[] cmd3c = new String[] {"top", "whipped cream"};
		cmd3.add(cmd3a);
		cmd3.add(cmd3b);
		cmd3.add(cmd3c);
		recipes.put(drinkName3, cmd3);

		
	}

}
