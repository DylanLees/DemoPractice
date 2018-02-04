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
	 * map����
	 */
	public void mapTest() {
		Map<String, String> map = new HashMap<>();
		map.put("first", "a");
		map.put("second", "b");
		map.put("third", "c");
		// ��ȡset����
		Set<String> set = map.keySet();
		// ��ȡ������
		Iterator<String> it = set.iterator();
		System.out.println("key��ֵ��");
		// ����������
		while (it.hasNext()) {
			// ��ȡ���������д��map���ϵ���һ��Ԫ�صļ�
			Object key = it.next();
			System.out.print("key:" + key + "\t");

		}

		// ��ȡmap�����е�valuesֵ
		java.util.Collection<String> collection = map.values();
		Iterator<String> iterator = collection.iterator();
		System.out.println("\nvalue��ֵ��");
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
	 * set����
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
		System.out.println("���ϴ�С"+list.size());
		// �������0��2֮��������
		System.out.println("�������"+Math.random() * list.size());
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			String next = iterator.next();
			System.out.println(next);
		}

	}

}
