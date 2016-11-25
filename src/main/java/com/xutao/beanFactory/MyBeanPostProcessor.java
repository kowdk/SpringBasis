package com.xutao.beanFactory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

// 推荐使用，属于AOP范畴
public class MyBeanPostProcessor implements BeanPostProcessor{
	
	// 11. 对Bean属性后加工，属于AOP范畴
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {		
		if(beanName.equals("car")){
			Car car = (Car)bean;
			if(car.getMaxSpeed() >= 200){
				System.err.println("11. 调用MyBeanPostProcessor.postProcessAfterInitialization()，将maxSpeed调整为200, AOP after()...");
				car.setMaxSpeed(200);
			}
		}
		return bean;
	}

	// 8. 对Bean属性设置完以后，进行后加工，属于AOP的范畴
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {		
		if(beanName.equals("car")){
			Car car = (Car)bean;
			if(car.getColor() == null){
				System.err.println("8. call MyBeanPostProcessor.postProcessBeforeInitialization()，color为空，设置为默认黑色, AOP before()...");
				car.setColor("黑色");
			}
		}
		return bean;
	}
}
