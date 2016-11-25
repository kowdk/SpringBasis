package com.xutao.aop;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

public class GreetingDynamicAdvisor extends DynamicMethodMatcherPointcut{

	private static List<String> clientList = new ArrayList<String>();
	static {
		clientList.add("xutao");
		clientList.add("yin");
	}
	
	/**
	 * 使用getClassFilter过滤类
	 * @return
	 */
	@Override
	public ClassFilter getClassFilter() {
		return new ClassFilter(){
			@Override
			public boolean matches(Class<?> clazz) {
				System.out.println("call getClassFilter to static check class : " + clazz.getName());
				return Waiter.class.isAssignableFrom(clazz);
			}
		};
	}


	/**
	 * 使用matches方法动态过滤方法的参数
	 * @param method
	 * @param targetClass
	 * @param args
	 * @return
	 */
	@Override
	public boolean matches(Method method, Class<?> targetClass, Object[] args) {
		System.out.println("call matches to dynamic check method :" + method.getName());
		return clientList.contains(args[0]);
	}
	
	/**
	 * 使用matches静态过滤方法名
	 * @param method
	 * @param targetClass
	 * @return
	 */
	@Override
	public boolean matches(Method method, Class<?> targetClass) {
		System.out.println("call matches to static check method : " + method.getName());
		return "greetTo".equals(method.getName());
	}

}
