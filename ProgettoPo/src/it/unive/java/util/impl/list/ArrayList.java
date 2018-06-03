package it.unive.java.util.impl.list;

import it.unive.java.util.exceptions.NotFoundException;
import it.unive.java.util.interfaces.Iterator;
import it.unive.java.util.interfaces.List;
import it.unive.java.util.iterators.ArrayListIterator;
import it.unive.java.util.iterators.IteratorType;

public class ArrayList<E> implements List<E> {

	private Object[] array;
	private int arrayLength;
	private int size;
	private static final int sizeIncrement = 15;

	public ArrayList() {
		this.arrayLength = 0;
		this.array = new Object[arrayLength];
		this.size = 0;
	}

	public ArrayList(int arrayLength) {
		this.arrayLength = arrayLength;
		this.array = new Object[arrayLength];
		this.size = 0;
	}

	private void grow() {
		Object[] aux = new Object[arrayLength + sizeIncrement];
		for (int i = 0; i < arrayLength; i++) {
			aux[i] = array[i];
		}
		arrayLength += sizeIncrement;
		array = aux;
	}

	@Override
	public void insertHead(E elem) {
		try {
			insertAt(0, elem);
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
	}

	private boolean checkGrow(int position) {
		return position >= arrayLength;
	}

	@Override
	public void insertAt(int position, E elem) throws NotFoundException {
		if (position > size()) {
			throw new NotFoundException("ArrayList.insertAt(): cannot insert at position " + position
					+ ". Max position available " + size());
		} else {
			if (checkGrow(position))
				grow();
			array[position] = elem;
			++size;
		}
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
		if (position >= size()) {
			throw new NotFoundException("ArrayList.removeAt(): cannot remove at position " + position);
		} else {
			for (int i = position; i < size() - 1; i++) {
				array[i] = array[i + 1];
			}
			--size;
		}
	}

	@Override
	public E getHead() throws NotFoundException {
		return getAt(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public E getAt(int position) throws NotFoundException {
		if (position >= size()) {
			throw new NotFoundException(
					"ArrayList.getAt(): cannot get at position " + position + ". Max position available " + size());
		} else {
			return (E) array[position];
		}
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void clear() {
		size = 0;
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
			return new ArrayListIterator<E>(this);
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
