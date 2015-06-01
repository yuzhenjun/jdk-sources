/**
 * @title CountDownLatchTest.java
 * @package com.smzh.concurrent
 * @projectName jdk-sources
 * @author zhenjun.yu
 * @date 2015年5月29日 下午6:24:43
 */
package com.smzh.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhenjun.yu

 */
public class CountDownLatchTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExecutorService pools=Executors.newCachedThreadPool();
		final CountDownLatch cdOrder=new CountDownLatch(1);
		final CountDownLatch cdAnswer=new CountDownLatch(3);
		for(int i=0;i<3;i++){
			Runnable command=new Runnable() {
				@Override
				public void run() {
					try {
						System.out.println("线程" + Thread.currentThread().getName() + 
								"正准备接受命令");				
						cdOrder.await();
						System.out.println("线程" + Thread.currentThread().getName() + 
								"已接受命令");	
						Thread.sleep((long)(Math.random()*10000));	
						System.out.println("线程" + Thread.currentThread().getName() + 
								"回应命令处理结果");	
						cdAnswer.countDown();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			};
			pools.execute(command);
		}
		
		try {
			Thread.sleep((long)(Math.random()*10000));
			System.out.println("线程" + Thread.currentThread().getName() + 
					"即将发布命令");	
			cdOrder.countDown();
			System.out.println("线程" + Thread.currentThread().getName() + 
					"已发送命令，正在等待结果");	
			cdAnswer.await();
			System.out.println("线程" + Thread.currentThread().getName() + 
					"已收到所有响应结果");	
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}

}
