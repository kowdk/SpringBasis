package com.xutao.aop;

import java.lang.reflect.Method;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;

/**
 * 切面定义类
 * @author xutao
 *
 */
public class GreetingStaticAdvisor extends StaticMethodMatcherPointcutAdvisor{

	private static final long serialVersionUID = -8427788701441682638L;

	private String pointcutName = "greetTo";
	
	/**
	 * 用于过滤方法名
	 */
	@Override
	public boolean matches(Method method, Class<?> targetClass) {
		return pointcutName.equals(method.getName());
	}

	/**
	 * 用于过滤类
	 */
	public ClassFilter getClassFilter() {
		return new ClassFilter(){
			@Override
			public boolean matches(Class<?> clazz) {
				return Waiter.class.isAssignableFrom(clazz);
			}
		};
	}
}
