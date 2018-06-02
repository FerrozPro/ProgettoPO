package it.unive.java.util.interfaces;

import it.unive.java.util.exceptions.NotFoundException;

public interface List<E> extends Iterable<E> {

	void insertHead(E elem);

	void insertAt(int position, E elem) throws NotFoundException;

	void removeHead() throws NotFoundException;

	void removeAt(int position) throws NotFoundException;

	E getHead() throws NotFoundException;

	E getAt(int position) throws NotFoundException;

	// TODO : check se possibile farlo oppure no
	// void concat(List<E> l);

	int size();

}
