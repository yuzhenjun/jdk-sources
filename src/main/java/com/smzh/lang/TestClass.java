/**
 * @title TestClass.java
 * @package com.smzh.lang
 * @projectName jdk-sources
 * @author zhenjun.yu
 * @date 2015年5月19日 上午11:00:14
 */
package com.smzh.lang;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.smzh.lang.impl.PersonName;





/**
 * @author zhenjun.yu

 */
public class TestClass {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		/** 返回与带有给定字符串名的类或接口相关联的 Class 对象**/
		Class<?> clazz=Class.forName("com.smzh.lang.Person");
		Method[] methods = clazz.getMethods();
		Field[] fields= clazz.getDeclaredFields();
		System.out.println(clazz.getClassLoader().getClass().getName());
		/**  isAnnotationPresent 如果指定类型的注释存在于此元素上，则返回 true，否则返回 false。**/
		for (Method m:methods) {
			System.out.println(m.getDefaultValue());
			System.out.println(m.isAnnotationPresent(PersonName.class));
		}
		
		for(Field f:fields){
			System.out.println(f.getName());
			System.out.println("======"+f.isAnnotationPresent(PersonName.class)+"=======");
		}
		Annotation [] annotation=clazz.getAnnotations();
		    for(Annotation tmp:annotation){
		    	System.out.println(tmp.toString());
		    }
		//实例化此类
	     System.out.println(clazz.newInstance());
	  
	}

}
