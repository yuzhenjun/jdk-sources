package com.smzh.thread.mulit;

public class ClassBDecrement implements Runnable{

	private MulitThreadSharedData data;
	
	public ClassBDecrement(MulitThreadSharedData data) {
		this.data=data;
	}
	@Override
	public void run() {
		for(int i=0;i<10;i++){
			int count=data.getdecrement();
			System.out.println(Thread.currentThread().getName()+"开始执行jian操作,结果为"+count);
		}
		
	}

}
