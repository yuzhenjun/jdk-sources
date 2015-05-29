package com.smzh.thread.lock;


public class SignalConditionTest {

	public static void main(String[] args) {
		final SignalCondition sc=new SignalCondition();
		new Thread(new Runnable() {
			@Override
			public void run() {
			for(int i=0;i<100;i++){
				sc.execute1();
			   }
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
			for(int i=0;i<100;i++){
				sc.execute2();
			   }
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
			for(int i=0;i<100;i++){
				sc.execute3();
			   }
			}
		}).start();
	}

}
