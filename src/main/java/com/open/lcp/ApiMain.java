package com.open.lcp;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ComponentScan : ����ɨ�裬��ɨ�赱ǰ��İ������Ӱ�
 * @EnableAutoConfiguration : ���ע�����Spring
 *                          Boot������ӵ�jar�����²������������Spring������spring-boot-starter-web�����Tomcat��Spring
 *                          MVC������auto-configuration���ٶ������ڿ���һ��webӦ�ã�����Spring������Ӧ�����á�
 * @EnableCaching : ����spring-cache,
 *                ConcurrentHashMap����洢�ṹ����ConcurrentHashMapFactoryBean�����͹���.
 * 
 * @author hepengyuan
 *
 */
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class, WebMvcAutoConfiguration.class })
@ComponentScan
@EnableCaching
public class ApiMain {

	public static void main(String[] args) {
		// for (int i = 0; i < args.length; i++) {
		// if ("adpre".equals(args[i])) {
		// System.setProperty("adpre", "1");
		// }
		// }
		// final String proFileName = XunleiEnvFinder.getProfile();
		// System.setProperty("spring.profiles.active", proFileName);
		// logger.info(
		// String.format("ApiMain: start @ %s, profile: %s",
		// XunleiEnvFinder.getIpcfg().toString(), proFileName));
		new SpringApplicationBuilder(ApiMain.class).run(args);
	}
}
