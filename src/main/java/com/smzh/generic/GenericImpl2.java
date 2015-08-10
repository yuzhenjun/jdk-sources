/**
 * @title GenericImpl2.java
 * @package com.smzh.generic
 * @projectName jdk-sources
 * @author zhenjun.yu@shatacloud.com
 * @date 2015年8月7日 下午4:38:40
 */
package com.smzh.generic;

/**
 * @author zhenjun.yu@shatacloud.com
 */
public class GenericImpl2 implements IGeneric{

	@Override
	public void fly() {
		System.out.println("我是老鹰我会飞");
	}

	public void say(){
		System.err.println("GenericImpl2 泛型另外添加的方法");
	}
}
