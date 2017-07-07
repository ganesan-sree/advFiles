package com.configuration.hello.impl;



public class HelloWorldImpl implements com.configuration.hello.HelloWorld {

	@Override
	public void printHelloWorld(String msg) {

		System.out.println("Hello : " + msg);
	}

}