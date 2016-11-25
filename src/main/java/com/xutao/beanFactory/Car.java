package com.xutao.beanFactory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

// 这四个接口过于耦合，不建议使用
public class Car implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean{

	private String brand;
	private String color;
	private int maxSpeed;
	private double price;
	
	private BeanFactory beanFactory;
	private String beanName;
	
	// 2.根据构造函数实例化Bean
	public Car(){
		System.out.println("2. call constructor()...");
	}
	
	// 对应于构造注入
	public Car(String brand, double price) {
		this.brand = brand;
		this.price = price;
	}
	
	public Car(String brand, int maxSpeed) {
		this.brand = brand;
		this.maxSpeed = maxSpeed;
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public String getBrand() {
		return brand;
	}

	// 解析xmlBean配置，调用setter方法注入值
	public void setBrand(String brand){
		System.out.println("5. call set Brand()...");
		this.brand = brand;
	}
	
	@Override
	public String toString() {
		return "Car [brand=" + brand + ", color=" + color + ", maxSpeed=" + maxSpeed + "]";
	}

	// 14. destroy调用
	@Override
	public void destroy() throws Exception {
		System.out.println("14. call DisposableBean.destroy()...");
	}

	// 9. 实现了Disposable接口，可以再次释放资源，记录日志等
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("9. call InitializingBean.afterPropertiesSet()...");
	}

	// 6. 实现了BeanNameAware接口，会调用setBeanName方法
	@Override
	public void setBeanName(String name) {
		System.out.println("6. call BeanNameAware.setBeanName()...");
		this.beanName = name;
	}

	// 7. 实现了BeanFactoryAware接口，会调用setBeanFactory方法
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("7. call BeanFactoryAware.setBeanFactory()...");
		this.beanFactory = beanFactory;
	}
	
	// 在xml中配置的两个函数可以解耦
	// 8. 在xml中配置了myInit()方法，是在设置了属性之后
	public void myInit(){
		System.out.println("10. call init-method myInit()... set maxSpeed 240, in xml...");
		this.maxSpeed = 240;
	}
	
	// 15. 在xml中配置myDestory()方法
	public void myDestory(){
		System.out.println("15. call destroy-method myDestory(), in xml...");
	}
	
}
