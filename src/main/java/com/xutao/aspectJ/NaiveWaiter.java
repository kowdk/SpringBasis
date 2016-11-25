package com.xutao.aspectJ;

public class NaiveWaiter implements Waiter{

	@Override
	public void greetTo(String name) {
		System.out.println("Waiter greet to " + name);
	}

	@Override
	public void serveTo(String name) {
		System.out.println("Waiter serve to " + name);
	}

}
