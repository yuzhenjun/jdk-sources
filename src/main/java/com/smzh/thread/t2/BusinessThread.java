package com.smzh.thread.t2;

public class BusinessThread implements Runnable{

	private Business business=new Business();
	@Override
	public void run() {
		for(int i=0;i<10;i++){
			business.main();
			business.subs();
		}
		
	}

}
