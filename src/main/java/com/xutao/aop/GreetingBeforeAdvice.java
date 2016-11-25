package com.xutao.aop;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

/**
 * 增强定义类，MethodBeforeAdvice是方法前增强
 * @author xutao
 *
 */
public class GreetingBeforeAdvice implements MethodBeforeAdvice{

	/**
	 * 复写的增强方法
	 */
	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		//System.out.println(target.getClass().getName() + "." + method.getName());
		System.out.println("MethodBeforeAdvice...");
		for(Object obj : args) {
			System.out.println("How are you, Mr. " + obj);
		}
	}
	
}
