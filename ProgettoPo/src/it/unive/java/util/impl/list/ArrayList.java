package it.unive.java.util.impl.list;

import it.unive.java.util.exceptions.NotFoundException;
import it.unive.java.util.interfaces.Iterator;
import it.unive.java.util.interfaces.List;
import it.unive.java.util.iterators.ArrayListIterator;

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
		System.out.println("Called ArrayList.grow()");
		Object[] aux = new Object[arrayLength + sizeIncrement];
		for (int i = 0; i < arrayLength; i++) {
			aux[i] = array[i];
		}
		arrayLength += sizeIncrement;
		array = aux;
	}

	@Override
	public void insertHead(E elem) {
		System.out.println("Called ArrayList.insertHead()");
		try {
			insertAt(0, elem);
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
	}

	private boolean checkGrow(int position) {
		System.out.println("Called ArrayList.checkGrow()");
		return position >= arrayLength;
	}

	@Override
	public void insertAt(int position, E elem) throws NotFoundException {
		System.out.println("Called ArrayList.insertAt(" + position + "," + elem + ")");
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
		System.out.println("Called ArrayList.add()");
		try {
			insertAt(size(), elem);
		} catch (NotFoundException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void removeHead() throws NotFoundException {
		System.out.println("Called ArrayList.removeHead()");
		removeAt(0);
	}

	@Override
	public void removeAt(int position) throws NotFoundException {
		System.out.println("Called ArrayList.removeAt(" + position + ")");
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
		System.out.println("Called ArrayList.getHead()");
		return getAt(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public E getAt(int position) throws NotFoundException {
		System.out.println("Called ArrayList.getAt(" + position + ")");
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
		System.out.println("Called ArrayList.clear()");
		size = 0;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}
	
	@Override
	public void concat(List<E> l) throws NotFoundException {
		System.out.println("Called ArrayList.concat()");
		for(Iterator<E> iter = l.iterator(); iter.hasNext();) {
			E value = iter.next();
			add(value);
		}
	}

	@Override
	public Iterator<E> iterator() {
		// return innerIterator();
		return new ArrayListIterator<E>(this);
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
