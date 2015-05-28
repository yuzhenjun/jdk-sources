/**
 * @title PersonName.java
 * @package com.smzh.lang.impl
 * @projectName jdk-sources
 * @author zhenjun.yu
 * @date 2015年5月19日 下午3:05:33
 */
package com.smzh.lang.impl;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * @author zhenjun.yu
 * 　	   1.CONSTRUCTOR:用于描述构造器
　　　　2.FIELD:用于描述域
　　　　3.LOCAL_VARIABLE:用于描述局部变量
　　　　4.METHOD:用于描述方法
　　　　5.PACKAGE:用于描述包
　　　　6.PARAMETER:用于描述参数
　　　　7.TYPE:用于描述类、接口(包括注解类型) 或enum声明
 */
@Target(ElementType.FIELD)
public @interface PersonName {
	 /**
     * 数据表名称注解，默认值为类名称
     * @return
     */
    public String name() default "jun";

}
