package com.xutao.aop;

public class Seller {
	private final String myName = "seller";
	
	public void greetTo(String name){
		System.out.println(myName + " greet to " + name);
	}
}
