package com.smzh.thread.mulit;


public class MulitThreadSharedDataTest {

	public static void main(String[] args) {
		MulitThreadSharedData data=new MulitThreadSharedData();
		new Thread(new ClassAIncrement(data)).start();
		new Thread(new ClassBDecrement(data)).start();
	}

}
