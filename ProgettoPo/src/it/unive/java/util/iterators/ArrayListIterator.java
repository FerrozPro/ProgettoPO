package it.unive.java.util.iterators;

import it.unive.java.util.exceptions.NotFoundException;
import it.unive.java.util.impl.ArrayList;
import it.unive.java.util.interfaces.Iterator;

public class ArrayListIterator<E> implements Iterator<E> {

	private int position;
	private ArrayList<E> enclosing;

	public ArrayListIterator(ArrayList<E> enclosing) {
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
