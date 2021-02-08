import orderManagement.OrderObtainer;
import orderManagement.OrderProcessor;
import presentationLayer.AppCommunicator;

public class Main {

	public static void main(String[] args) {
		OrderObtainer orderObtainer = new OrderObtainer();
		AppCommunicator appCommunicator = new AppCommunicator(orderObtainer);
		OrderProcessor orderProcessor = new OrderProcessor(orderObtainer);
		
		//take input from the user for orderEXAMPLE to run
		orderObtainer.obtainOrderJson(1);
		
		
		
		// TODO Auto-generated method stub

	}

}
