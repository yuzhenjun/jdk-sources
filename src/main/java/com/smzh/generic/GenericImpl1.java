/**
 * @title GenericImpl1.java
 * @package com.smzh.generic
 * @projectName jdk-sources
 * @author zhenjun.yu@shatacloud.com
 * @date 2015年8月7日 下午4:38:05
 */
package com.smzh.generic;
/**
 * @author zhenjun.yu@shatacloud.com
 */
public class GenericImpl1 implements IGeneric{

	@Override
	public void fly() {
		System.out.println("我是雷鸟");
	}
	
	public void say(){
		System.err.println("GenericImpl1 泛型另外添加的方法");
	}

}
