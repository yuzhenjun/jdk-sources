/**
 * @title PrintThread.java
 * @package com.smzh.thread
 * @projectName jdk-sources
 * @author zhenjun.yu
 * @date 2015年5月22日 上午10:22:15
 */
package com.smzh.thread;

/**
 * @author zhenjun.yu
*  设计两个线程类，一个线程类负责打印100以内所有的偶数，另一个线程打印100以内所有的奇数。
 * 要求偶数线程每打印10个偶数以后，
 * 就让奇数线程打印10个奇数，如此交替进行
 * */
public class PrintThread {
	 // state==1表示线程1开始打印，state==2表示线程2开始打印
	private static int state=1;
	private static int num1=1;
	private static int num2=2;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final Object  object=new Object();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while (num1<100) {
					synchronized (object) {
						if(state!=1){
							try {
								object.wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						for(int i=0;i<10;i++){
							System.out.print(num1+" ");
							num1+=2;
						}
						System.out.println("===========");
						state=2;
						object.notifyAll();
					}
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (num2<100) {
					synchronized (object) {
						if(state!=2){
							try {
								object.wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						for(int i=0;i<10;i++){
							System.out.print(num2+" ");
							num2+=2;
						}
						System.out.println("===========");
						state=1;
						object.notifyAll();
					}
				}
			}
		}).start();
	}

}
