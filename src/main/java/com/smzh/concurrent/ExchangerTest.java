/**
 * @title ExchangerTest.java
 * @package com.smzh.concurrent
 * @projectName jdk-sources
 * @author zhenjun.yu
 * @date 2015年6月1日 上午10:35:05
 */
package com.smzh.concurrent;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhenjun.yu

 */
public class ExchangerTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final Exchanger<String> exchanger=new Exchanger<String>();
		ExecutorService pools=Executors.newCachedThreadPool();
		pools.execute(new Runnable() {
			@Override
			public void run() {
				try {
				String data1="线程1的数据";
				System.out.println("线程"+Thread.currentThread().getName()+"准备交换数据"+data1);
				Thread.sleep((long)(Math.random()*10000));
				String data2=exchanger.exchange(data1);
				System.err.println("线程"+Thread.currentThread().getName()+"换回的数据"+data2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}	
				
			}
		});
		
		pools.execute(new Runnable() {
			@Override
			public void run() {
				try {
				String data1="线程2的数据";
				System.out.println("线程"+Thread.currentThread().getName()+"准备交换数据"+data1);
				Thread.sleep((long)(Math.random()*10000));
				String data2=exchanger.exchange(data1);
				System.err.println("线程"+Thread.currentThread().getName()+"换回的数据"+data2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}	
			}
		});
		
		pools.shutdown();
	}

}
