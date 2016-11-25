package com.xutao.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetingTest {
	public static void main(String[] args) {
		final String confPath="com/xutao/aop/GreetingAdvisor.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(confPath);
		
		Waiter w = (Waiter)ctx.getBean("waiter");
		Seller s = (Seller)ctx.getBean("seller");
		w.greetTo("xutao");
		w.serveTo("xutao");
		s.greetTo("xutao");
	}
}
