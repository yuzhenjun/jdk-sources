/**
 * @title GenericMethod.java
 * @package com.smzh.generic
 * @projectName jdk-sources
 * @author zhenjun.yu@shatacloud.com
 * @date 2015年8月7日 上午10:29:58
 */
package com.smzh.generic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author zhenjun.yu@shatacloud.com
 */
public class GenericMethod {
	/**
	 * 泛型方法
	 * <T extends Comparable<T>> 针对可以与自身比较的每个类型T
	 * @param list
	 * @return
	 */
	public static <T extends Comparable<T>> T max(List<T> list){
		if(list!=null&&list.size()>0){
			Iterator<T> i=list.iterator();
		    T result=i.next();
		    while (i.hasNext()) {
				T t=i.next();
				if(t.compareTo(result)>0){
					result=t;
				}
			}
		    return result;
		}
		return null;
	}
	
	/**
	 *通配符测试
	 * @param list
	 * @return
	 */
	public static <E> List<E> min(List<? extends E> list,List<? extends E> list2){
		List<E> result=new ArrayList<E>();
		result.addAll(list);
		result.addAll(list2);
		return result;
	}
}

