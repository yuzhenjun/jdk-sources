package com.smzh.thread.mulit;

public class ClassAIncrement implements Runnable{

	private MulitThreadSharedData data;
	
	public  ClassAIncrement(MulitThreadSharedData data) {
		this.data=data;
	}
	@Override
	public void run() {
		for(int i=0;i<10;i++){
		int count=data.getIncrement();
		System.out.println(Thread.currentThread().getName()+"开始执行加操作,结果为"+count);
		}
	}
	
	

}
