/**
 * @title SemaphoreTest.java
 * @package com.smzh.thread.lock
 * @projectName jdk-sources
 * @author zhenjun.yu
 * @date 2015年5月29日 下午5:14:55
 */
package com.smzh.concurrent;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Semaphore
 * 一个计数信号量。从概念上讲，信号量维护了一个许可集。如有必要，在许可可用前会阻塞每一个 acquire()，然后再获取该许可
 * @author zhenjun.yu

 */
public class SemaphoreTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExecutorService pools=Executors.newCachedThreadPool();
		final Semaphore sp=new Semaphore(3);
		
		for(int i=0;i<15;i++){
			Runnable command=new Runnable() {
				@Override
				public void run() {
					try {
						sp.acquire();//从此信号量获取一个许可，在提供一个许可前一直将线程阻塞，否则线程被中断
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("线程"+Thread.currentThread().getName()+"已进来拉屎,当前有"+(3-sp.availablePermits())+"个线程在拉屎");
					try {
						Thread.sleep((long)(Math.random()*10000));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.err.print("线程"+Thread.currentThread().getName()+"已拉完,即将离开");
					sp.release();
				}
			};
			pools.execute(command);
		}
		pools.shutdown();
	}

}
