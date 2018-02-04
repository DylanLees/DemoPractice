package com.woniuxy.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author Administrator
 *
 */
public class Collection {

	/**
	 * map集合
	 */
	public void mapTest() {
		Map<String, String> map = new HashMap<>();
		map.put("first", "a");
		map.put("second", "b");
		map.put("third", "c");
		// 获取set集合
		Set<String> set = map.keySet();
		// 获取迭代器
		Iterator<String> it = set.iterator();
		System.out.println("key的值：");
		// 遍历迭代器
		while (it.hasNext()) {
			// 获取迭代的器中存放map集合的下一个元素的键
			Object key = it.next();
			System.out.print("key:" + key + "\t");

		}

		// 获取map集合中的values值
		java.util.Collection<String> collection = map.values();
		Iterator<String> iterator = collection.iterator();
		System.out.println("\nvalue的值：");
		while (iterator.hasNext()) {
			String value = iterator.next();
			System.out.print("value:" + value + "\t\t");
		}

	}

	public static void main(String[] args) {
		Collection coll = new Collection();
		// coll.mapTest();
		// coll.setTest();
		coll.listTest();
	}

	/**
	 * set集合
	 */
	public void setTest() {
		Set<Integer> set = new HashSet<>();
		set.add(11);
		set.add(22);
		set.add(33);
		set.add(44);
		Iterator<Integer> iterator = set.iterator();
		while (iterator.hasNext()) {
			Integer next = iterator.next();
			System.out.println(next);
		}

	}

	public void listTest() {
		List<String> list = new ArrayList<String>();
		list.add("abc");
		list.add("def");
		list.add("ghi");
		System.out.println("集合大小"+list.size());
		// 随机产生0到2之间的随机数
		System.out.println("随机数："+Math.random() * list.size());
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			String next = iterator.next();
			System.out.println(next);
		}

	}

}
