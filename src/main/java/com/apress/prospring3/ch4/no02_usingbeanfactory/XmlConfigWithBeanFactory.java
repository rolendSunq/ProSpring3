package com.apress.prospring3.ch4.no02_usingbeanfactory;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.FileSystemResource;

public class XmlConfigWithBeanFactory {

	public static void main(String[] args) {
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader rdr = new XmlBeanDefinitionReader(factory);
		rdr.loadBeanDefinitions(new FileSystemResource("src/main/resources/ch4/no02_usingbeanfactory/xmlBeanFactory.xml"));
		
		Oracle oracle = factory.getBean("oracle", Oracle.class);
		System.out.println(oracle.defineMeaningOfLife());
	}

}
