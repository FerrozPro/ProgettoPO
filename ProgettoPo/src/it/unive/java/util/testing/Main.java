package it.unive.java.util.testing;

import it.unive.java.util.exceptions.NotFoundException;
import it.unive.java.util.impl.ArrayList;
import it.unive.java.util.impl.IteratorType;
import it.unive.java.util.interfaces.Iterator;
import it.unive.java.util.interfaces.List;

public class Main {

	public static void main(String[] args) {
		List<Integer> listaUno = new ArrayList<Integer>();
		// List<Integer> listaDue = new DualLinkList<Integer>();

		listaUno.insertHead(0);
		try {
			listaUno.insertAt(1, 2);
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		try {
			listaUno.insertAt(3, 20);
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		try {
			listaUno.insertAt(2, 20);
		} catch (NotFoundException e) {
			e.printStackTrace();
		}

		try {
			System.out.println("listaUno.getAt(2) = " + listaUno.getAt(2));
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		try {
			System.out.println("listaUno.getHead() = " + listaUno.getHead());
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		try {
			listaUno.removeHead();
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		try {
//			listaUno.removeAt(2);
			System.out.println("listaUno.getAt(2) = " + listaUno.getAt(2));
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("listaUno.size() = " + listaUno.size());
		
		System.out.println("listaUno.iterator(IteratorType.INNER)");
		for(Iterator<Integer> i = listaUno.iterator(IteratorType.INNER); i.hasNext();) {
			int value = i.next();
			System.out.println(value);
		}
		System.out.println("listaUno.iterator(IteratorType.OUTER)");
		for(Iterator<Integer> i = listaUno.iterator(IteratorType.OUTER); i.hasNext();) {
			int value = i.next();
			System.out.println(value);
		}
		
	}
}
