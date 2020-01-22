package com.bridgelabz.observerpattern;

public class ObserverPatternTest {

	public static void main(String[] args) {
		
		MyTopic topic = new MyTopic();
		
		Observer observer1 = new MyTopicSubscriber("kishore");
		Observer observer2 = new MyTopicSubscriber("ram");
		Observer observer3 = new MyTopicSubscriber("sai");
		
		topic.register(observer1);
		topic.register(observer2);
		topic.register(observer3);
		
		observer1.setSubject(topic);
		observer2.setSubject(topic);
		observer3.setSubject(topic);
		
		observer1.update();
		
		topic.postMessage("content changed");

	}

}
