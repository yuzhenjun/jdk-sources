/**
 * @title TraditionalThread.java
 * @package com.smzh.thread.t1
 * @projectName jdk-sources
 * @author zhenjun.yu
 * @date 2015年5月22日 下午4:19:58
 */
package com.smzh.thread.t1;

/**
 * @author zhenjun.yu

 */
public class TraditionalThread {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyThread2 thread=new MyThread2();
		Thread h1=new Thread(thread, "窗口1");
		Thread h2=new Thread(thread, "窗口2");
		Thread h3=new Thread(thread, "窗口3");
		System.out.println("===========");
		h1.setPriority(8);
		h2.setPriority(2);
		h3.setPriority(6);
		h1.start();
		h2.start();
		h3.start();
	}

}
