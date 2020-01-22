package com.bridgelabz.observerpattern;

import java.util.ArrayList;
import java.util.List;

public class MyTopic implements Subject {
	private List<Observer> observers ;
	private String message;
	private boolean changed;
	private Object MUTEX = new Object();
	
	public MyTopic() {
		observers = new ArrayList<Observer>();
	}

	@Override
	public void register(Observer observer) {
		if(observers == null) {
			throw new NullPointerException("null observers");
		}synchronized(MUTEX) {
			if(!observers.contains(observer)) {
				observers.add(observer);
			}
		}
		
	}

	@Override
	public void unRegister(Observer obj) {
		synchronized(MUTEX) {
			observers.remove(obj);		}
		
	}

	@SuppressWarnings("unused")
	@Override
	public void notifyObservers() {
		List<Observer> list = null;
		synchronized(MUTEX) {
			if(!changed) {
				return;
			}
			list = new ArrayList<Observer>(this.observers);
			this.changed = false;
		}
		for(Observer observer : observers) {
			observer.update();
		}
	}

	@Override
	public Object getUpdate(Observer obj) {
		return this.message;
	}
	
	public void postMessage(String message) {
		System.out.println(" posted content "+message);
		this.message = message;
		this.changed = true;
		notifyObservers();
	}

}
