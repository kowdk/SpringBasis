package com.xutao.beanFactory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class BeanLifeCycle {
	private static void lifeCycleInBeanFactory(){
		Resource res = new ClassPathResource("com/xutao/beanFactory/car-beans.xml");
		BeanFactory bf = new XmlBeanFactory(res);
		
		// 如果使用ApplicationContext而不是BeanFactory的话，可以将这些后处理器配置在xml文件中 
		
		// 注册MyBeanPostProcessor后处理器
		((ConfigurableBeanFactory)bf).addBeanPostProcessor(new MyBeanPostProcessor());
		
		// 注册MyInstantiationAwareBeanPostProcessor后处理器
		((ConfigurableBeanFactory)bf).addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());
		
		Car car1 = (Car)bf.getBean("car");
		
		// 12. 调用toString()方法
		System.out.println("12. " + car1);
		//car1.setColor("red");
		
		// 13. Spring默认是Singleton的，因此返回缓存的car对象
		Car car2 = (Car)bf.getBean("car");
		
		System.out.println("car1==car2:" + (car1==car2));
		((XmlBeanFactory)bf).destroySingletons();
		
	}
	
	public static void main(String[] args) {
		lifeCycleInBeanFactory();
	}
}
