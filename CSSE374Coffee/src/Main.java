import orderManagement.OrderObtainer;
import orderManagement.OrderProcessor;

public class Main {

	public static void main(String[] args) {
		OrderObtainer orderObtainer = new OrderObtainer();
		OrderProcessor orderProcessor = new OrderProcessor(orderObtainer);
		
		orderObtainer.obtainOrderJson();
		
		
		
		// TODO Auto-generated method stub

	}

}
