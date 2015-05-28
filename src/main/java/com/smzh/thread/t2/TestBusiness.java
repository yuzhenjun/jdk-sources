/**
 * @title TestBusiness.java
 * @package com.smzh.thread.t2
 * @projectName jdk-sources
 * @author zhenjun.yu
 * @date 2015年5月25日 下午6:06:14
 */
package com.smzh.thread.t2;

import java.util.concurrent.ExecutorService;

/**
 * @author zhenjun.yu

 */
public class TestBusiness {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		final Business business=new Business();
		new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<50;i++){
					business.subs();
				}
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<50;i++){
					business.main();
				}
			}
		}).start();
	}

}
