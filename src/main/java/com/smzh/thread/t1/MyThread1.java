/**
 * @title MyThread1.java
 * @package com.smzh.thread.t1
 * @projectName jdk-sources
 * @author zhenjun.yu
 * @date 2015年5月22日 下午4:06:52
 */
package com.smzh.thread.t1;

/**
 * @author zhenjun.yu

 */
public class MyThread1 extends Thread{

	private static int i=0;
	@Override
	public void run() {
		while (i<100) {
			System.out.println((i++)+this.getName());
		}
	}

}
