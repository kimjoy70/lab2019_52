package com.di;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

public class InsaMain {
	public static void main(String[] args) {
		System.out.println("=============================");
		ApplicationContext context = 
				new ClassPathXmlApplicationContext
								("com\\di\\insaBean.xml");
		InsaList insaList = (InsaList)context.getBean("insa");
		System.out.println(insaList.insaBean);
		for(int i=0;i<insaList.insaBean.size();i++) {
			System.out.println(insaList.insaBean.get(i));
		}
		

	}
}
