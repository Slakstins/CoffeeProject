package commands;

import beverageCreation.Beverage;

public abstract class CommandFactory {
	//might return a file
	//request type is based on the behavior of the machine. Might have this implemented by using getType() on behavior. Better way?
	public abstract void produceDrinkOrderCommand(Beverage beverage, int controllerID, int machineID, int orderID, String requestType);

}
