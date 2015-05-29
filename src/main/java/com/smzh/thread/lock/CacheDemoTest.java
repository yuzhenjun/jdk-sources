package com.smzh.thread.lock;



public class CacheDemoTest {

	 public static void main(String[] args) {
		final CacheDemo cache=new CacheDemo();
		for(int i=0;i<10;i++){
			new Thread(new Runnable() {
				@Override
				public void run() {
					for(int i=0;i<100;i++){
						System.out.println(Thread.currentThread().getName()+"     "+cache.getCache("data"));
					}
					
				}
			}).start();
		}
	}
}
