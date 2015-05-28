/**
 * @title ClassA.java
 * @package com.smzh.thread.threadlocal
 * @projectName jdk-sources
 * @author zhenjun.yu
 * @date 2015年5月27日 下午2:25:56
 */
package com.smzh.thread.threadlocal;

/**
 * @author zhenjun.yu
 */
public class ClassA {
	public void get(){
		System.out.println(Thread.currentThread().getName()+ " A from threadlocal get data "+ThreadScopeData.getInstance().toString());
	}
}
