package com.jh.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.TreeMap;


public class GenericsDemo {

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		return "GenericsDemo :" + member;
	}

	private String member;
	
	
	
	public GenericsDemo() {
		// TODO Auto-generated constructor stub
		
	}
	

	public GenericsDemo(String member) {
		// TODO Auto-generated constructor stub
		this.member = member;
	}

	
	public static void ListTest(){
		List<String> list = new ArrayList<String>();
		list.add("Hello");
		list.add(1, "world");
		list.add(2, "world");
		
		for(String str: list){
			System.out.println(str);
		}
		// contains
		if(list.contains(new String("Hello"))){
			System.out.println("contains hello");
		}
		
		if(list.equals(new ArrayList<String>())){
			System.out.println("list equals newlist");
		}
		
		Collection<String> collection = list;
		collection.add("helooooooooooooooooooooooooooooooooo");
		for(String str: collection){
			System.out.println(str);
		}
		
		for(String str: list){
			System.out.println(str);
		}

		

	}
	
	
	public static void LinkedListTest(){
		
		List<String> list = new LinkedList<String>();
		list.add("Hello World");
		for(String str: list){
			System.out.println(str);
		}
	}
	
	
	public static void MapDemo(){
		Map map = new TreeMap();
		
		map.put("ce1", new GenericsDemo("Hello"));
		
		map.put("ce2", new GenericsDemo("World"));
		
		Iterator iter =  map.values().iterator();
		while( iter.hasNext()){
			System.out.println(iter.next());
		}
		
		Iterator ite = map.keySet().iterator();
		while( ite.hasNext()){
			Object i = ite.next();
			System.out.println( i  + " = " + map.get(i));			
		}

	}
	
	
	public static void MapXmlDemo(){
		Map<String,List> map = new TreeMap<String,List>();
		List<String> list = new ArrayList<String>();
		list.add("halei");
		list.add("hawayi");
		
		
		System.out.println(list.indexOf("hawayi"));
		
		map.put("ce1", list);
		System.out.println(map.get("ce1").get(0));
		
		
		
		List<String> list2 = new ArrayList<String>();
		list2.add("moximoxi");
		list2.add("huahuashijie");
		
		
		// 特殊的iterator -- ListIterator   可以插入和替换
		ListIterator<String> it = list.listIterator();
		it.add("hello ListIterator");
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		
		
		map.put("ce2", list2);
		
		
		
		/*Iterator iter =  map.values().iterator();
		while( iter.hasNext()){
			System.out.println(iter.next());
		}*/

		Iterator ite = map.keySet().iterator();
		while( ite.hasNext()){
			Object i = ite.next();
			System.out.println( i  + " = " + map.get(i));			
		}
	}
	
	
	public static void main(String[] args) {
		//LinkedListTest();
		//MapDemo();
		MapXmlDemo();
		
	}
}
