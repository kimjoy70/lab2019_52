package com.mvc2;

public class A {
	B b = null;
	public void methodB() {
		//B b = new B();
		int x = b.methodA();
	}
	public static void main(String[] args) {
		A a  = new A();
		a.methodB();
	}
	public void setB(B b) {
		this.b = b;
	}

}
