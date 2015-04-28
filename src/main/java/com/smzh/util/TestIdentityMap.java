/**
 * @title TestIdentityMap.java
 * @package com.smzh.util
 * @projectName jdk-sources
 * @author zhenjun.yu
 * @date 2015年4月28日 下午1:27:23
 */
package com.smzh.util;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

/**
 * @author zhenjun.yu

 */
public class TestIdentityMap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Person person= new Person(123,"zhenjun");
		Person person2=new Person(123,"zhenjun");
		Map<String, String> map=new HashMap<String, String>();
		//String str="zhenjun";
		map.put(new String("zhenjun"), "yu");
		map.put(new String("zhenjun"), "yu");
		System.out.println(map.toString());
		IdentityHashMap<String, String> identity=new IdentityHashMap<String, String>();
		identity.put(new String("zhenjun"), "yu");
		identity.put(new String("zhenjun"),"yu");
		System.out.println(identity.toString());
		System.out.println(identity.get("zhenjun"));
	}

}
