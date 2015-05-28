/**
 * @title Business.java
 * @package com.smzh.thread.t2
 * @projectName jdk-sources
 * @author zhenjun.yu
 * @date 2015年5月25日 下午6:04:05
 */
package com.smzh.thread.t2;

/**
 * @author zhenjun.yu

 */
public class Business {

	private boolean isSubs=true;
	
	public synchronized void subs(){
		if(!isSubs){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for(int i=0;i<10;i++){
			System.out.println("子线程"+i);
		}
		isSubs=false;
		this.notify();
	}
	
	public synchronized void main(){
		if(isSubs){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for(int i=0;i<100;i++){
			System.out.println("主线程"+i);
		}
		isSubs=true;
		this.notify();
	}
}
