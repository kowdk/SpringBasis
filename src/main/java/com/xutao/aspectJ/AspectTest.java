package com.xutao.aspectJ;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AspectTest {
	public static void main(String[] args) {
		final String confPath="com/xutao/aspectJ/waiter-aspect.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(confPath);
		
		Waiter w = (Waiter)ctx.getBean("waiter");
		w.greetTo("xutao");
	}
}
