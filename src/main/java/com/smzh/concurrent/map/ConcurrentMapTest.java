/**
 * @title ConcurrentMapTest.java
 * @package com.smzh.concurrent.map
 * @projectName jdk-sources
 * @author zhenjun.yu
 * @date 2015年6月1日 上午11:19:32
 */
package com.smzh.concurrent.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhenjun.yu
 */
public class ConcurrentMapTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map<String, String> map=new HashMap<String, String>();
		Collections.synchronizedMap(map);
		ConcurrentHashMap<String , String> cMap=new ConcurrentHashMap<String, String>();
	}

}
