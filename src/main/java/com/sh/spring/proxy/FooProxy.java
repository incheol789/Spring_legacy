package com.sh.spring.proxy;

public class FooProxy implements Foo {
	
	private Foo target; // 주업무로직 객체
	private Aspect aspect; // aop 객체 (advice)
	
	public FooProxy(Foo target, Aspect aspect) {
		this.target = target;
		this.aspect = aspect;
	}

	@Override
	public String bar(String id) {
		aspect.before();
		String name = target.bar(id);
		aspect.after();
		return name;
	}

	public String getText() {

		String text = target.getText();

		return aspect.toUpper(text);
	}


	
	

}
