package beverageCreation;

import java.util.ArrayList;
import java.util.Collection;

public interface Beverage {

	public String getAsString();
	public Beverage unwrapDrink();
	public Integer getQty();


}
