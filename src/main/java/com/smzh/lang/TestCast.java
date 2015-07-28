/**
 * @title TestCast.java
 * @package com.smzh.lang
 * @projectName jdk-sources
 * @author zhenjun.yu@shatacloud.com
 * @date 2015年7月9日 下午3:10:42
 */
package com.smzh.lang;

import java.util.Arrays;


/**
 * @author zhenjun.yu@shatacloud.com
 */
public class TestCast {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		long d=124342422312312312L;
		float f=d;
		System.out.println(d);
		System.out.println(f);
		
		
		int i=100;
		char c=(char)i;
		System.out.println(c);
		
		
		int money=1000000000;
		int years=20;
		
		long total=(long)money*years;
		System.out.println(total);
		
		byte b=127;
		double dou=3.14;
		float fl=3.14f;
		//Stack<Object>;
		//Properties;
		//ConcurrentHashMap
		//Arrays.sort(a);
		
		
	}
	
}
