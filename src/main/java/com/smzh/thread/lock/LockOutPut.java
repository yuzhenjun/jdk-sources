/**
 * @title OutPut.java
 * @package com.smzh.thread.lock
 * @projectName jdk-sources
 * @author zhenjun.yu
 * @date 2015年5月29日 上午11:11:15
 */
package com.smzh.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhenjun.yu
 */
public class LockOutPut {
	/**
	 * 比synchronized 更加面向对象
	 */
	private Lock lock=new ReentrantLock();
	
	public void print(String name) {
		int len = name.length();
		lock.lock();
		try{
			System.out.print("线程："+Thread.currentThread().getName());
			for (int i = 0; i < len; i++) {
				System.out.print(name.charAt(i));
			}
			System.out.println();
		}finally{
			lock.unlock();
		}
		
	}

}
