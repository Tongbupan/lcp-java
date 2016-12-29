package com.open.lcp.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ��ǰ�ӿڽ���һ�������Ͳ���ʱ�����ô˷�ʽʵ�֡�
 * 
 * ע�⣺��ѡʱ���������ͣ�����Integer,Long,Boolean�ȣ�һ��Ĭ��Ϊnull����������Ϊ0(int,byte,long,double,etc)��false��boolean��
 * 
 * @author hepengyuan
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface LcpReq {

	/** �Ƿ��ѡ��Ĭ�ϱ�ѡ */
	String name();

	/** �Ƿ��ѡ��Ĭ�ϱ�ѡ */
	boolean required();

	/** �ֶ����� */
	String desc();

	/** ֵ����С��minֵ��min��maxֵ����һ����Ϊ0ʱ��Ч�� */
	long min() default 0;

	/** ֵ�����max���ڲ�С��minֵ�Ҳ�ȫΪ0ʱ��Ч�� */
	long max() default 0;

	/** �����룬��У��ʧ��ʱ���ء� */
	int errorCode() default 0;

	/** ������ʾ����У��ʧ��ʱ���ء� */
	String errorMsg() default "";

	/** ������ַ������Ƿ���Ҫtrim��Ĭ�ϲ�trim������min��max������ʱ��Ч */
	boolean trim() default false;
}
