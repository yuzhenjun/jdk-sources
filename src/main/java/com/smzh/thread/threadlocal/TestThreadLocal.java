/**
 * @title TestThreadLocal.java
 * @package com.smzh.thread.threadlocal
 * @projectName jdk-sources
 * @author zhenjun.yu
 * @date 2015年5月27日 下午3:02:37
 */
package com.smzh.thread.threadlocal;

import java.util.Random;

/**
 * @author zhenjun.yu

 */
public class TestThreadLocal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for(int i=0;i<3;i++){
			new Thread(new Runnable() {
				@Override
				public void run() {
					int age=new Random().nextInt(100);
					ThreadScopeData data=ThreadScopeData.getInstance();
					data.setAge(age);
					data.setName(Thread.currentThread().getName());
					System.out.println(Thread.currentThread().getName()+"开始放入数据");
					new ClassA().get();
					new ClassB().get();
				}
			}).start();
		}
		
	}

}
