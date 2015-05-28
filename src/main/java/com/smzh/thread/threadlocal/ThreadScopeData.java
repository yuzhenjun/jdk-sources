/**
 * @title ThreadScopeData.java
 * @package com.smzh.thread.threadlocal
 * @projectName jdk-sources
 * @author zhenjun.yu
 * @date 2015年5月27日 下午2:19:42
 */
package com.smzh.thread.threadlocal;

/**
 * @author zhenjun.yu
 */
public class ThreadScopeData {
	private static ThreadLocal<ThreadScopeData>  threadLocal=new ThreadLocal<ThreadScopeData>();
	
	private ThreadScopeData(){
	}
	/**
	 *  threadLocal 的使用
	 *  同一个线程共享同一个变量
	 *  不同的线程变量不共享
	 * @return
	 */
	public static ThreadScopeData getInstance(){
		ThreadScopeData instence=threadLocal.get();
		if(instence==null){
			instence=new ThreadScopeData();
			threadLocal.set(instence);
		}
		return instence;
	}
	
	/**
	 * 单例模式
	 * 不适合多线程情况
	 * @return
	 */
	public static ThreadScopeData getSingleInstance(){
		if(singleInstance==null){
			singleInstance=new ThreadScopeData();
		}
		return singleInstance;
	}
	/**
	 *单例模式
	 *应用于多线程
	 * @return
	 */
	public static synchronized ThreadScopeData getSingleInstance2(){
		if(singleInstance==null){
			singleInstance=new ThreadScopeData();
		}
		return singleInstance;
	}
	private static ThreadScopeData singleInstance=null;
	private int age;
	private String name;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ThreadScopeData [age=" + age + ", name=" + name + "]";
	}
}
