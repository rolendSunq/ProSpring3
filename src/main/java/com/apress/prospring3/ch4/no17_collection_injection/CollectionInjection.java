package com.apress.prospring3.ch4.no17_collection_injection;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service("injectCollection")
public class CollectionInjection {
	
	@Resource(name="map")
	private Map<String, Object> map;
	
	@Resource(name="props")
	private Properties props;
	
	@Resource(name="set")
	private Set set;
	
	@Resource(name="list")
	private List list;
	
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:ch4/no17_collection_injection/app-context-collection_injection.xml");
		ctx.refresh();
		
		CollectionInjection instance = (CollectionInjection) ctx.getBean("injectCollection");
		instance.displayInfo();
	}

	public void displayInfo() {
		
		// Map을 표시
		System.out.println("Map contents: \n");
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			System.out.println("Key: " + entry.getKey() + " - Value: " + entry.getValue());
		}
		
		// 프로퍼티를 표시
		System.out.println("Properties contents: \n");
		for (Map.Entry<Object, Object> entry : props.entrySet()) {
			System.out.println("Key: " + entry.getKey() + " - Value: " + entry.getValue());
		}
		
		// Set을 표시
		System.out.println("\nSet contents:\n");
		for (Object obj : set) {
			System.out.println("Value: " + obj);
		}
		
		// List를 표시
		System.out.println("\nList contents:\n");
		for (Object obj : list) {
			System.out.println("Value: " + obj);
		}
	}
}
