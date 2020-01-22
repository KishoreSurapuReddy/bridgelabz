package com.bridgelabz.observerpattern;

public class MyTopicSubscriber implements Observer {
	
	private String name;
	private Subject topic;

	public MyTopicSubscriber(String name) {
		this.name = name;
	}

	@Override
	public void update() {
		String message = (String) topic.getUpdate(this);
		if(message == null) {
			System.out.println(name+" no  message ");
		}else {
			System.out.println(name+" message "+message);
		}
	}

	@Override
	public Subject setSubject(Subject subject) {
		return this.topic = subject;
	}

}
