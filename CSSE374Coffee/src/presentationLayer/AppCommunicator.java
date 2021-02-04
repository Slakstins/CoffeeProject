package presentationLayer;

import orderManagement.OrderObtainer;

public class AppCommunicator {
	
	private OrderObtainer orderObtainer;
	
	
	public AppCommunicator(OrderObtainer orderObtainer) {
		this.orderObtainer = orderObtainer;
		
	}

}
