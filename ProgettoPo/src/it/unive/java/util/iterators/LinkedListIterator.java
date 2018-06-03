package it.unive.java.util.iterators;

import it.unive.java.util.exceptions.NotFoundException;
import it.unive.java.util.impl.list.LinkedList;
import it.unive.java.util.interfaces.Iterator;

public class LinkedListIterator<E> implements Iterator<E> {

	private int position;
	private LinkedList<E> enclosing;

	public LinkedListIterator(LinkedList<E> enclosing) {
		this.position = 0;
		this.enclosing = enclosing;
	}

	@Override
	public boolean hasNext() {
		return position < enclosing.size();
	}

	@Override
	public E next() {
		try {
			return enclosing.getAt(position++);
		} catch (NotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Iterator.next() failed");
		}
	}

}
