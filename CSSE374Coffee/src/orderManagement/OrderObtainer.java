package orderManagement;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.json.JSONObject;

public class OrderObtainer implements Subject{
	
	private ArrayList<Observer> observers;
	private String fileData;
	
	//OrderObtainer takes the JSON in its constructor
	public OrderObtainer(){
		observers = new ArrayList<Observer>();
		
	}
	
	
	public void obtainOrderJson(String fileData) {
		this.fileData = fileData;
		notifyObservers();
		
	}
	
	public String pullOrderFileData() {
		return this.fileData;
	}
	
	
	
	
	
	

	@Override
	public void notifyObservers() {
		for (int i = 0; i < observers.size(); i++) {
			observers.get(i).update();
		}
		
	}

	@Override
	public void registerObserver(Observer observer) {
		this.observers.add(observer);
		
	}

	@Override
	public void removeObserver(Observer observer) {
		this.observers.remove(observer);
		
	}


}
