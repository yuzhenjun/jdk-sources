package com.smzh.thread.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁实现缓存系统
 * @author zhenjun.yu
 */
public class CacheDemo {
	/**
	 * 缓存数据
	 */
	private Map<String, Object> cache=new HashMap<String, Object>();
	private ReadWriteLock lock=new ReentrantReadWriteLock();
	/**
	 * 添加锁synchronized
	 * @param key
	 * @return
	 */
	public synchronized Object get(String key){
		Object value=cache.get(key);
		if(value==null){
			value=new Random().nextInt();
			cache.put(key, value);
		}
		return value;
	}
	
	/**
	 * 还是用读写互斥锁<br>
	 * 
	 * @param key
	 * @return
	 */
	public  Object getCache(String key){
		// 当用户读取数据时添加读锁
		lock.readLock().lock();
		Object value=null;
		try {
			value=cache.get(key);
			if(value==null){
				//如果数据为，释放读锁，添加写锁获取数据
				lock.readLock().unlock();
				lock.writeLock().lock();
				try {
					value=cache.get(key);
					if(value==null){
						System.out.println(Thread.currentThread().getName()+"开始从数据库获取数据");
						value=new Random().nextInt();
						cache.put(key, value);//放入缓存
						System.out.println(Thread.currentThread().getName()+"获取的数据放入缓存"+value);
					}
				} finally{
					 //数据获取完成释放写锁
					lock.writeLock().unlock();
				}
				//重新添加读锁
				lock.readLock().lock();
			}
		} catch (Exception e) {
		}finally{
			//数据获取完成释放读锁
			lock.readLock().unlock();
		}
		return value;
	}
}
