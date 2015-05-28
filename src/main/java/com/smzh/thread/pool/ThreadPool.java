package com.smzh.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPool {
	public static void main(String[] args) {
		ExecutorService pools=Executors.newFixedThreadPool(5);
		final AtomicInteger count=new AtomicInteger(1);
		for(int i=0;i<10;i++){
			pools.execute(new Runnable() {
				@Override
				public void run() {
					for(int j=0;j<10;j++){
								System.out.println(Thread.currentThread().getName()+" 线程开始输出"+count.getAndIncrement());
						}	
				}
			});
		}
		System.out.println("10个任务已添加");
		pools.shutdown();
	}

}
