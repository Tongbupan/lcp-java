package com.open.lcp.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ��ʶ�������Ӧ������Ϊ�����ṩ������ʹ�÷�ʽ Required("����һ�����Ե�����") Required(value"����һ�����Ե�����")<br/>
 * <br/>
 * 
 * ��������FieldΪ�����Listʱ�����Զ��Ѷ��ŷָ����ַ����Զ�תΪ��Ӧ�������List���������List��Field��������set������<br/>
 * <br/>
 * 
 * max���ڲ�С��minֵ�Ҳ�ȫΪ0ʱ��Ч��minֵ��min��maxֵ����һ����Ϊ0ʱ��Ч��
 * 
 * @author hepengyuan
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LcpRequired {

	/** �Ƿ��ѡ��Ĭ�ϱ�ѡ */
	boolean value() default true;

	/** �ֶ����� */
	String desc() default "";

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

	/** �Ƿ��Ѿ�ʹ��aes���� **/
	boolean aes() default false;

	/** �Ƿ��Ѿ�ʹ��gzѹ�� **/
	boolean gz() default false;

	/** ����ǽṹ�壬ȷ���ڽ�������Ĭ�ϲ��ǽṹ�� */
	Struct struct() default Struct.NONE;

	public enum Struct {
		NONE, JSON
	}
}
