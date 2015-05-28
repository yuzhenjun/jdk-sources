/**
 * @title ClassB.java
 * @package com.smzh.thread.threadlocal
 * @projectName jdk-sources
 * @author zhenjun.yu
 * @date 2015年5月27日 下午2:26:05
 */
package com.smzh.thread.threadlocal;

/**
 * @author zhenjun.yu

 */
public class ClassB {
	public void get(){
		System.out.println(Thread.currentThread().getName()+ " B from threadlocal get data "+ThreadScopeData.getInstance().toString());
	}
}
