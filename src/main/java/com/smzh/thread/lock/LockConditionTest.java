package com.smzh.thread.lock;



public class LockConditionTest {

	public static void main(String[] args) {
		final LockCondition lc=new LockCondition();
		
			new Thread(new Runnable() {
				@Override
				public void run() {
					while(true){
						lc.main();	
					}
						
				}
			}).start();
			new Thread(new Runnable() {
				@Override
				public void run() {
					while(true){
						lc.subs();
					}
				}
			}).start();
	}
}
