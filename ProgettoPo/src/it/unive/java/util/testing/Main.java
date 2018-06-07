package it.unive.java.util.testing;

import it.unive.java.util.exceptions.NotFoundException;
import it.unive.java.util.impl.list.ArrayList;
import it.unive.java.util.impl.list.LinkedList;
import it.unive.java.util.impl.map.LinkedMap;
import it.unive.java.util.interfaces.Iterator;
import it.unive.java.util.interfaces.List;
import it.unive.java.util.interfaces.Map;

public class Main {

	public static void main(String[] args) {
		List<Integer> linkedListOne = new LinkedList<Integer>();

		linkedListOne.insertHead(0);
		try {
			linkedListOne.insertAt(1, 2);
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		try {
			linkedListOne.insertAt(3, 20);
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		try {
			linkedListOne.insertAt(2, 20);
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		try {
			System.out.println("listaUno.getAt(2) = " + linkedListOne.getAt(2));
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		try {
			System.out.println("listaUno.getHead() = " + linkedListOne.getHead());
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		try {
			linkedListOne.removeHead();
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		try {
			linkedListOne.removeAt(2);
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		try {
			System.out.println("listaUno.getAt(2) = " + linkedListOne.getAt(2));
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("listaUno.size() = " + linkedListOne.size());
		System.out.println("listaUno.iterator()");
		for (Iterator<Integer> i = linkedListOne.iterator(); i.hasNext();) {
			int value = i.next();
			System.out.println("iterator i value = " + value);
		}

		System.out.println("######################################################");
		System.out.println("#################### FINE listaUno ###################");
		System.out.println("######################################################");

		ArrayList<Integer> arrayListOne = new ArrayList<Integer>();
		arrayListOne.insertHead(1);
		try {
			arrayListOne.removeAt(1);
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		try {
			arrayListOne.insertAt(1, 2);
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		arrayListOne.add(3);
		for (Iterator<Integer> i = arrayListOne.iterator(); i.hasNext();) {
			int value = i.next();
			System.out.println(value);
		}
		arrayListOne.clear();
		try {
			arrayListOne.getAt(1);
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		arrayListOne.insertHead(2);
		try {
			System.out.println("arrayListOne.getHead() = " + arrayListOne.getHead());
		} catch (NotFoundException e) {
			e.printStackTrace();
		}

		System.out.println("######################################################");
		System.out.println("#################### FINE listaUno ###################");
		System.out.println("######################################################");

		Map<String,Integer> linkedMapOne = new LinkedMap<String,Integer>();
		linkedMapOne.put("uno", 1);
		linkedMapOne.clear();
		linkedMapOne.put("due", 2);
		linkedMapOne.put("tre", 3);
		linkedMapOne.containsKey("due");
		linkedMapOne.containsKey("uno");
		System.out.println("linkedMapOne.get(\"due\") = " + linkedMapOne.get("due"));
		List<String> keySet = linkedMapOne.keySet();
		List<Integer> values = linkedMapOne.values();
		System.out.println("keySet = ");
		for(Iterator<String> iter = keySet.iterator(); iter.hasNext();) {
			String value = iter.next();
			System.out.println(value);
		}
		System.out.println("values = ");
		for(Iterator<Integer> iter = values.iterator(); iter.hasNext();) {
			Integer value = iter.next();
			System.out.println(value);
		}
	}
}
