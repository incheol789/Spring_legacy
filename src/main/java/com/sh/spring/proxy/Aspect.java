package com.sh.spring.proxy;

public class Aspect {
	
	
	// advice
	public void before() {
		System.out.println("Aspect#before");
	}
		
	// advice
	public void after() {
		System.out.println("Aspect#after");
	}
	
	/**
	 * 소문자를 대문자로 변환하는 부가 기능
	 */

	public String toUpper(String text) {
		return text.toUpperCase();
	}

}
