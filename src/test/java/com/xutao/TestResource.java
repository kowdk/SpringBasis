package com.xutao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.xutao.domain.User;

public class TestResource {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(User.class);
		User user = ctx.getBean("user", User.class);
		user.setUserName("xuato");
		System.out.println(user);
	}
}
