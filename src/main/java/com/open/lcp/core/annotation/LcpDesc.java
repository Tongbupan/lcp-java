package com.open.lcp.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ������Ϣ
 * 
 * @author hepengyuan
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface LcpDesc {

	String value();

	/**
	 * ��ʼ֧Ԯ�İ汾
	 * 
	 * @return
	 */
	String ver() default "";
}
