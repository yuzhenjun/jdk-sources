/**
 * @title LockCondition.java
 * @package com.smzh.thread.lock
 * @projectName jdk-sources
 * @author zhenjun.yu
 * @date 2015年5月29日 下午3:40:13
 */
package com.smzh.thread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhenjun.yu
 * 
 * 
 */
public class LockCondition {
	
   private Lock lock=new ReentrantLock();
   
   private Condition condition=lock.newCondition();
   
   private boolean isSubs=true;
	
	public  void subs(){
		lock.lock();
		try{
			if(!isSubs){
				try {
					condition.await();// 造成当前线程在接到信号或被中断之前一直处于等待状态。
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			for(int i=0;i<5;i++){
				System.err.println(Thread.currentThread().getName()+"子线程");
			}
			isSubs=false;
			condition.signal();//唤醒一个等待线程
		}finally{
			lock.unlock();
		}
		
	}
	
	public  void main(){
		lock.lock();
		try{
			if(isSubs){
				try {
					condition.await();// 造成当前线程在接到信号或被中断之前一直处于等待状态。
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			for(int i=0;i<10;i++){
				System.out.println(Thread.currentThread().getName()+"主线程");
			}
			
			isSubs=true;
			condition.signal();//唤醒一个等待线程
		}finally{
			lock.unlock();
		}
	}
}
