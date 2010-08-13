package org.role.common;

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class BeanHelp {
	private static ApplicationContext ac = null;

	public static void init(ServletContext context) {
		ac = WebApplicationContextUtils.getWebApplicationContext(context);
	}

	public static void init(String[] files) {
		ac = new FileSystemXmlApplicationContext(files);
	}
	
	public static void initClassPath(String[] files) {
		ac = new ClassPathXmlApplicationContext(files);
	}

	public static Object getBean(String name) {
		if (null == name)
			return null;
		if (null == ac) {
			String[] files = {"applicationContext*.xml"};
			initClassPath(files);
		}else if (null == ac) {
			String[] files = {"applicationContext*.xml"};
			init(files);
		}else {
			throw new IllegalArgumentException("未找到spring容器");
		}
		return ac.getBean(name);
	}
}