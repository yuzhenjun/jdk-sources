/**
 * @title ReadWriteLock.java
 * @package com.smzh.thread.lock
 * @projectName jdk-sources
 * @author zhenjun.yu
 * @date 2015年5月29日 上午11:35:45
 */
package com.smzh.thread.lock;

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author zhenjun.yu
 * 
 * 读写锁<br>
 * 多个读锁不互斥<br>
 * 多个写锁互斥<br>
 * 读锁和写锁互斥<br>
 * 写锁和写锁互斥 <br>
 * ReadWriteLock lock=new ReentrantReadWriteLock();<br>
 * 提高程序效率<br>
 * 
 */
public class ReadWriteLock2 {
	
	private Object data=null;
	
    ReadWriteLock lock=new ReentrantReadWriteLock();
	
	/**
	 * 写操作
	 * @throws InterruptedException 
	 */
	public void get(){
		lock.readLock().lock();
		try {
			System.out.println(Thread.currentThread().getName()+"开始读数据");
			Thread.sleep(new Random().nextInt(2000));
			System.out.println(Thread.currentThread().getName()+"读取数据为 "+data);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			lock.readLock().unlock();
		}
	}
	
	/**
	 * 读操作
	 * @param data
	 */
	
	public void put(Object data){
		lock.writeLock().lock();
		try {
			System.out.println(Thread.currentThread().getName()+"开始xie数据");
			Thread.sleep(new Random().nextInt(2000));
			this.data=data;
			System.out.println(Thread.currentThread().getName()+"xie数据为 "+data);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			lock.writeLock().unlock();
		}

	}

}
