package com.smzh.thread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程通信 三个线程，线程1结束通知线程2，线程2结束通知线程3，线程3结束通知线程1
 * 
 * @author zhenjun.yu
 */
public class SignalCondition {

	private Lock lock = new ReentrantLock();
	private Condition c1 = lock.newCondition();
	private Condition c2 = lock.newCondition();
	private Condition c3 = lock.newCondition();
	
	private int status=1;//
	
	
	public void execute1(){
		lock.lock();
		try{
			if(status!=1){
				try {
					c1.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName()+"执行完成 开始通知执行execute2");
			status=2;
			c2.signal();
		}finally{
			lock.unlock();
		}
	}
	
	public void execute2(){
		lock.lock();
		try{
			if(status!=2){
				try {
					c2.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.err.println(Thread.currentThread().getName()+"执行完成 开始通知执行execute3");
			status=3;
			c3.signal();
		}finally{
			lock.unlock();
		}
	}
	
	public void execute3(){
		lock.lock();
		try{
			if(status!=3){
				try {
					c3.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName()+"执行完成 开始通知执行execute1");
			status=1;
			c1.signal();
		}finally{
			lock.unlock();
		}
	}

}
