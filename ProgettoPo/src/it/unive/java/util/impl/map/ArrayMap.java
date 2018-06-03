package it.unive.java.util.impl.map;

import it.unive.java.util.impl.list.LinkedList;
import it.unive.java.util.interfaces.List;
import it.unive.java.util.interfaces.Map;

public class ArrayMap<K, V> implements Map<K, V> {

	public MapNode<K, V> head;
	public int size;

	public ArrayMap() {
		this.head = null;
		this.size = 0;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public V put(K key, V value) {
		if (!containsKey(key)) {
			head = new MapNode<K, V>(key, value, head);
			return null;
		} else {
			MapNode<K, V> aux = head;
			while (!aux.getKey().equals(key)) {
				aux = aux.getNext();
			}
			V res = aux.getValue();
			aux.setValue(value);
			return res;
		}
	}

	@Override
	public V get(K key) {
		if (containsKey(key)) {
			MapNode<K, V> aux = head;
			while (!aux.getKey().equals(key)) {
				aux = aux.getNext();
			}
			return aux.getValue();
		}
		return null;
	}

	@Override
	public boolean containsKey(K key) {
		if (size() != 0) {
			if (head.getKey().equals(key)) {
				return true;
			} else {
				MapNode<K, V> aux = head;
				int sizeAux = size();
				while (sizeAux-- != 0) {
					if (aux.getKey().equals(key)) {
						return true;
					}
					aux = aux.getNext();
				}
			}
		}
		return false;
	}

	@Override
	public void clear() {
		head = null;
	}

	@Override
	public List<K> keySet() {
		if (size() != 0) {
			List<K> keySet = new LinkedList<K>();
			MapNode<K, V> aux = head;
			int auxSize = size();
			while (auxSize-- != 0) {
				keySet.add(aux.getKey());
				aux = aux.getNext();
			}
			return keySet;
		}
		return null;
	}

	@Override
	public List<V> values() {
		if (size() != 0) {
			List<V> values = new LinkedList<V>();
			MapNode<K, V> aux = head;
			int auxSize = size();
			while (auxSize-- != 0) {
				values.add(aux.getValue());
				aux = aux.getNext();
			}
			return values;
		}
		return null;
	}

}
