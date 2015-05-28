package com.smzh.thread.mulit;

public class MulitThreadSharedData {

	private int count =100;
	
	public synchronized int getIncrement (){
		return ++count;
	}
	
	public synchronized int getdecrement(){
		return --count;
	}
}
