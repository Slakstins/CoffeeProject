import java.util.InputMismatchException;
import java.util.Scanner;

import orderManagement.OrderObtainer;
import orderManagement.OrderProcessor;
import presentationLayer.AppCommunicator;

public class Main {

	public static void main(String[] args) {

		OrderObtainer orderObtainer = new OrderObtainer();
		AppCommunicator appCommunicator = AppCommunicator.getInstance();
		OrderProcessor orderProcessor = new OrderProcessor(orderObtainer);
		appCommunicator.setOrderObtainer(orderObtainer);
		
		System.out.println("Input the order filenumber to prepare.");
		System.out.println("1 through 4 are valid orders. Input -1 to stop");
		while (true) {
			
		Scanner sc = new Scanner(System.in);
		int requestedVal = -2;
		try {
			
			requestedVal = sc.nextInt();
		}catch(InputMismatchException e){
			System.out.println("invalid input");
			
		}

		if (requestedVal >= 0 && requestedVal <= 4) {
			appCommunicator.sendOrderJson(requestedVal);
		}
		else if (requestedVal == -1) {
			System.out.println("shutting down");
			sc.close();
			break;
		}
		else {
			System.out.println("invalid input");
		}
		//take input from the user for orderEXAMPLE to run
		
		
		
		// TODO Auto-generated method stub

		}
	}

}
