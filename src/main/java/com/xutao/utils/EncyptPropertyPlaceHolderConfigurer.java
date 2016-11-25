package com.xutao.utils;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class EncyptPropertyPlaceHolderConfigurer extends PropertyPlaceholderConfigurer{
	
	private final String[] strs = {"username", "password"};
	
	@Override
	protected String convertProperty(String propertyName, String propertyValue){
		if(isEncyptProp(propertyName)){
			return DESUtils.getEncryptString(propertyName);
		} else {
			return propertyValue;
		}
	}
	
	private boolean isEncyptProp(String prop) {
		for(String str : strs) {
			if(str.equals(prop))
				return true;
		}
		return false;
	}
}
