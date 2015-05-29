/**
 * @title TestLock.java
 * @package com.smzh.thread.lock
 * @projectName jdk-sources
 * @author zhenjun.yu
 * @date 2015年5月29日 上午10:33:48
 */
package com.smzh.thread.lock;



/**
 * @author zhenjun.yu

 */
public class LockOutPutTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final LockOutPut op=	new LockOutPut();
		new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<100;i++){
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					op.print("yuzhenjun");
				}
				
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<100;i++){
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					op.print("zhenjun");
				}
			}
		}).start();
	}

}
