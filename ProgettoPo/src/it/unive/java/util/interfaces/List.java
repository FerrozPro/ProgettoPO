package it.unive.java.util.interfaces;

import it.unive.java.util.exceptions.NotFoundException;

public interface List<E> extends Iterable<E> {

	void insertHead(E elem);

	void insertAt(int position, E elem) throws NotFoundException;
	
	void add(E elem);

	void removeHead() throws NotFoundException;

	void removeAt(int position) throws NotFoundException;

	E getHead() throws NotFoundException;

	E getAt(int position) throws NotFoundException;

	int size();
	
	void clear();
	
	boolean isEmpty();

}
