/**
 * @title TestIdentityMap.java
 * @package com.smzh.util
 * @projectName jdk-sources
 * @author zhenjun.yu
 * @date 2015年4月28日 下午1:27:23
 */
package com.smzh.util.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhenjun.yu

 */
public class TestIdentityMap {
	
	public static <T extends Comparable<T>> T max(List<T> list){
		return null;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map<Person, String> map=new HashMap<Person, String>();
		map.put(new Person(123,"zhenjun"), "yu");
		map.put(new Person(123,"zhenjun"), "yu");
		System.out.println(map.toString());
		System.out.println(map.get(new Person(123,"zhenjun")));
		double d=12.3;
		int i=12;
		double dd=d%i;
		System.out.println(Math.floor(d));
		if(dd==0){
			System.out.println("============");
		}
		
		List<Person1>lists=new ArrayList<Person1>();
		TestIdentityMap.max(lists);
	}

}


class Person1 implements Comparable<Person1>{

	@Override
	public int compareTo(Person1 o) {
		return 0;
	}
	
}
