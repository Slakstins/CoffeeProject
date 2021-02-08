package shop;

import java.util.ArrayList;

public class Shop {
	private ArrayList<Controller> controllers;
	
	private String address;
	private int zip;
	
	public Shop(String address, int zip) {
		this.address = address;
		this.zip = zip;
		
	}

	public String getAddress() {
		return address;
	}

	public int getZip() {
		return zip;
	}
	
	public void setControllers(ArrayList<Controller> controllers) {
		this.controllers = controllers;
		
	}

}
