package it.unive.java.util.testing;


import it.unive.java.util.exceptions.NotFoundException;
import it.unive.java.util.impl.list.ArrayList;
import it.unive.java.util.impl.list.LinkedList;
import it.unive.java.util.interfaces.Iterator;
import it.unive.java.util.interfaces.List;
import it.unive.java.util.iterators.IteratorType;

public class Main {

	public static void main(String[] args) {
		List<Integer> listaUno = new LinkedList<Integer>();
		// List<Integer> listaDue = new DualLinkList<Integer>();

		listaUno.insertHead(0);
		try {
			listaUno.insertAt(1, 2);
		} catch (NotFoundException e) {
		}
		try {
			listaUno.insertAt(3, 20);
		} catch (NotFoundException e) {
		}
		try {
			listaUno.insertAt(2, 20);
		} catch (NotFoundException e) {
		}

		try {
			System.out.println("listaUno.getAt(2) = " + listaUno.getAt(2));
		} catch (NotFoundException e) {
		}
		try {
			System.out.println("listaUno.getHead() = " + listaUno.getHead());
		} catch (NotFoundException e) {
		}
		try {
			listaUno.removeHead();
		} catch (NotFoundException e) {
		}
		try {
			// listaUno.removeAt(2);
			System.out.println("listaUno.getAt(2) = " + listaUno.getAt(2));
		} catch (NotFoundException e) {
		}
		System.out.println("listaUno.size() = " + listaUno.size());

		System.out.println("listaUno.iterator(IteratorType.INNER)");
		for (Iterator<Integer> i = listaUno.iterator(IteratorType.INNER); i.hasNext();) {
			int value = i.next();
			System.out.println(value);
		}
		System.out.println("listaUno.iterator(IteratorType.OUTER)");
		for (Iterator<Integer> i = listaUno.iterator(IteratorType.OUTER); i.hasNext();) {
			int value = i.next();
			System.out.println(value);
		}
		
		Object[] a = new Object[10];
		for (Object i : a) {
			System.out.println(i);
		}
		
		ArrayList<Integer> b = new ArrayList<Integer>();
		b.insertHead(1);
		try {
			b.removeAt(1);
		} catch (NotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			b.insertAt(1, 2);
		} catch (NotFoundException e) {e.printStackTrace();}
		b.add(3);
		
		for (Iterator<Integer> i = b.iterator(IteratorType.OUTER); i.hasNext();) {
			int value = i.next();
			System.out.println(value);
		}

	}
}
