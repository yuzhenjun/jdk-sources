/**
 * @title GenericMethodTest.java
 * @package com.smzh.generic
 * @projectName jdk-sources
 * @author zhenjun.yu@shatacloud.com
 * @date 2015年8月7日 下午5:01:37
 */
package com.smzh.generic;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @author zhenjun.yu@shatacloud.com
 */
public class GenericMethodTest {

	/**
	 * Test method for {@link com.smzh.generic.GenericMethod#max(java.util.List)}.
	 */
	@Test
	public void testMax() {
		
	}

	/**
	 * Test method for {@link com.smzh.generic.GenericMethod#min(java.util.List, java.util.List)}.
	 */
	@Test
	public void testMin() {
		List<IGeneric>list =new ArrayList<IGeneric>();
		list.add(new GenericImpl1());
		List<IGeneric>list2 =new ArrayList<IGeneric>();
		list2.add(new GenericImpl2());
		List<IGeneric>result=GenericMethod.min(list, list2);
		GenericImpl1 genericImpl1 =(GenericImpl1)result.get(0);
		genericImpl1.fly();
		genericImpl1.say();
		GenericImpl2 genericImpl2 =(GenericImpl2)result.get(1);
		genericImpl2.fly();
		genericImpl2.say();
	}

}
