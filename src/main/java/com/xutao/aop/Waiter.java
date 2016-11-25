package com.xutao.aop;

public class Waiter {
	
	private final String myName = "waiter";
	
	public void greetTo(String name) {
		System.out.println(myName + " greet to " + name);
	}
	
	public void serveTo(String name) {
		System.out.println(myName + " serve to " + name);
	}
	
}
