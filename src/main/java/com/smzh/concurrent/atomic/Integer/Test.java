/**
 * @title Test.java
 * @package com.smzh.concurrent.atomic.Integer
 * @projectName jdk-sources
 * @author zhenjun.yu
 * @date 2015年4月27日 下午4:34:57
 */
package com.smzh.concurrent.atomic.Integer;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhenjun.yu

 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AtomicInteger ai=new AtomicInteger(3);
		int i=ai.getAndAdd(2);
		System.out.println(i);
		System.out.println(ai.get());
	}

}
