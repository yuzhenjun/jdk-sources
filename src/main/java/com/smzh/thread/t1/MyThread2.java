package com.smzh.thread.t1;


/**
 * 实现Runnable接口比继承Thread类所具有的优势：
 * 
 * 1）：适合多个相同的程序代码的线程去处理同一个资源
 * 
 * 2）：可以避免java中的单继承的限制
 * 
 * 3）：增加程序的健壮性，代码可以被多个线程共享，代码和数据独立。
 * 
 * @author zhenjun.yu
 */

public class MyThread2 implements Runnable {
	
	private Object lock=new Object();
	/**
	 * 售票数
	 */
	private int ticket = 1000;

	@Override
	public void run() {
		for (int i = 0; i <100; i++) {
			synchronized (lock) {
				if (this.ticket > 0) {
					System.out.println(Thread.currentThread().getName() + "正在卖票"+ this.ticket--);
					if(ticket==3){
						Thread.currentThread().yield();
					}
				}
			}
			
		}

	}

}
