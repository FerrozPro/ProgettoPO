package it.unive.java.util.impl.list;

import it.unive.java.util.exceptions.NotFoundException;
import it.unive.java.util.interfaces.Iterator;
import it.unive.java.util.interfaces.List;
import it.unive.java.util.iterators.LinkedListIterator;
import it.unive.java.util.iterators.IteratorType;

public class LinkedList<E> implements List<E> {

	private Node<E> head;
	private int size;

	public LinkedList() {
		this.head = null;
		this.size = 0;
	}

	@Override
	public void insertHead(E elem) {
		try {
			insertAt(0, elem);

		} catch (NotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insertAt(int position, E elem) throws NotFoundException {

		// System.out.println("Called LinkedList.insertAt(" + position + "," + elem +
		// ")");
		if (position > size())
			throw new NotFoundException("LinkedList.insertAt(): cannot insert at position " + position
					+ ". Max position available " + size());
		if (position == 0) {
			this.head = new Node<E>(elem, null);
		} else {
			Node<E> aux = this.head;
			while (--position != 0) {
				aux = aux.getNext();
			}
			aux.setNext(new Node<E>(elem, aux.getNext()));
		}
		++size;
	}

	@Override
	public void add(E elem) {
		try {
			insertAt(size(), elem);
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void removeHead() throws NotFoundException {
		removeAt(0);

	}

	@Override
	public void removeAt(int position) throws NotFoundException {
		System.out.println("Called LinkedList.removeAt(" + position + ")");
		if (position >= size())
			throw new NotFoundException("LinkedList.removeAt(): cannot remove at position " + position
					+ ". Max position available " + (size() - 1));
		if (position == 0) {
			head = head.getNext();
		} else {
			Node<E> aux = head;
			while (--position != 0) {
				aux = aux.getNext();
			}
			aux.setNext(aux.getNext().getNext());
		}
		--size;
	}

	@Override
	public E getHead() throws NotFoundException {
		return getAt(0);
	}

	@Override
	public E getAt(int position) throws NotFoundException {
		System.out.println("Called LinkedList.getAt(" + position + ")");
		if (position >= size())
			throw new NotFoundException("LinkedList.getAt(): cannot get at position " + position
					+ ". Max position available " + (size() - 1));
		if (position == 0) {
			return head.getElem();
		} else {
			Node<E> aux = head;
			while (position-- != 0) {
				aux = aux.getNext();
				// --position;
			}
			return aux.getElem();
		}
	}

	// TODO: check che l sia un LinkedList
	// @Override
	public void concat(LinkedList<E> l) throws NotFoundException {
		if (head == null) {
			head = new Node<E>(l.getHead(), null);
			l.removeHead();
		}
		Node<E> aux = head;
		int position = size() - 1;
		while (position != 0) {
			aux = aux.getNext();
			--position;
		}
		position = l.size() - 1;
		while (position != 0) {
			aux.setNext(new Node<E>(l.getHead(), null));
			l.removeHead();
			aux = aux.getNext();
		}
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public void clear() {
		if (head != null) {
			head = null;
			size = 0;
		}
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public Iterator<E> iterator(IteratorType value) {
		switch (value) {
		case INNER:
			return innerIterator();
		case OUTER:
			return new LinkedListIterator<E>(this);
		default:
			return innerIterator();
		}
	}

	public Iterator<E> innerIterator() {
		return new Iterator<E>() {

			int position = 0;

			@Override
			public boolean hasNext() {
				return position < size();
			}

			@Override
			public E next() {
				try {
					return getAt(position++);
				} catch (NotFoundException e) {
					e.printStackTrace();
					throw new RuntimeException("Iterator.next() failed");
				}
			}

		};
	}
}
