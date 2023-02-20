package com.sh.spring.proxy;

public class FooImpl implements Foo {

	@Override
	public String bar(String id) {
		return "홍길동";
	}

	@Override
	public String getText() {
		return "abcde";
	}
}
