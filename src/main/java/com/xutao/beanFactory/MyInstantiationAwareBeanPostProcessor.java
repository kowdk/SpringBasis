package com.xutao.beanFactory;

import java.beans.PropertyDescriptor;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

public class MyInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {

	// 1. 在实例化Bean之前，调用postProcessBeforeInstantiation方法
	public Object postProcessBeforeInstantiation(Class beanClass, String beanName) throws BeansException {
		if("car".equals(beanName)){
			System.out.println("1. call MyInstantiationAwareBeanPostProcessor.postProcessBeforeInstantiation()...");			
		}		
		return null;
	}

	// 3. 在实例化Bean之后，调用postProcessAfterInstantiation方法
	public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
		if("car".equals(beanName)){
		System.out.println("3. call InstantiationAwareBeanPostProcessor.postProcessAfterInstantiation()...");
		}
		return true;
	}

	// 4. 在设置Bean的属性之前，调用postProcessPropertyValues方法
	public PropertyValues postProcessPropertyValues(
			PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName)
			throws BeansException {
		if("car".equals(beanName)){
		   System.out.println("4. call InstantiationAwareBeanPostProcessor.postProcessPropertyValues()...");
		}
		return pvs;
	}

}
