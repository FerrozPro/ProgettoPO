package it.unive.java.util.impl;

import it.unive.java.util.exceptions.NotFoundException;
import it.unive.java.util.interfaces.Iterator;
import it.unive.java.util.interfaces.List;

public class ArrayList<E> implements List<E> {

	private Node<E> head;
	private int size;

	public ArrayList() {
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
		if (position > size())
			throw new NotFoundException("ArrayList.insertAt(): cannot insert at position " + position);
		if (position == 0) {
			this.head = new Node<E>(elem, null);
		} else {
			Node<E> aux = this.head;
			while (--position != 0) {
				aux = aux.getNext();
				--position;
			}
			aux.setNext(new Node<E>(elem, aux.getNext()));
		}
		++size;

	}

	@Override
	public void removeHead() throws NotFoundException {
		removeAt(0);

	}

	@Override
	public void removeAt(int position) throws NotFoundException {
		if (position >= size())
			throw new NotFoundException("ArrayList.removeAt(): cannot remove at position " + position);
		if (position == 0) {
			head = head.getNext();
		} else {
			Node<E> aux = head;
			while (--position != 0) {
				aux = aux.getNext();
				--position;
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
		if (position >= size())
			throw new NotFoundException("ArrayList.getAt(): cannot get at position " + position);
		if (position == 0) {
			return head.getElem();
		} else {
			Node<E> aux = head;
			while (position != 0) {
				aux = aux.getNext();
				--position;
			}
			return aux.getElem();
		}
	}

	// TODO: check che l sia un ArrayList
	// @Override
	public void concat(ArrayList<E> l) throws NotFoundException {
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
	public Iterator<E> iterator() {
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
