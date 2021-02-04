import orderManagement.OrderObtainer;
import orderManagement.OrderProcessor;
import presentationLayer.AppCommunicator;

public class Main {

	public static void main(String[] args) {
		OrderObtainer orderObtainer = new OrderObtainer();
		AppCommunicator appCommunicator = new AppCommunicator(orderObtainer);
		OrderProcessor orderProcessor = new OrderProcessor(orderObtainer);
		
		orderObtainer.obtainOrderJson();
		
		
		
		// TODO Auto-generated method stub

	}

}
