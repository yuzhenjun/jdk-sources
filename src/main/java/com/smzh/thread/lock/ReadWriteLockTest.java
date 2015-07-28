package com.smzh.thread.lock;

import java.util.Random;


public class ReadWriteLockTest {

	public static void main(String[] args) {
		
		final ReadWriteLock2 rwl=new ReadWriteLock2();
		for(int i=0;i<3;i++){
			new Thread(new Runnable() {
				@Override
				public void run() {
					for(int j=0;j<100;j++){
						rwl.put(new Random().nextDouble());
					}
				}
			}).start();
		}
		for(int i=0;i<3;i++){
			new Thread(new Runnable() {
				@Override
				public void run() {
					for(int j=0;j<100;j++){
						rwl.get();
					}
				}
			}).start();
		}
	}

}
