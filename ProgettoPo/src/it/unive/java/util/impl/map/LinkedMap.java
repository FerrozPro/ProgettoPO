package it.unive.java.util.impl.map;

import it.unive.java.util.impl.list.LinkedList;
import it.unive.java.util.interfaces.List;
import it.unive.java.util.interfaces.Map;

public class LinkedMap<K, V> implements Map<K, V> {

	public MapNode<K, V> head;
	public int size;

	public LinkedMap() {
		this.head = null;
		this.size = 0;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public V put(K key, V value) {
		System.out.println("Called LinkedMap.put(" + key + "," + value + ")");
		if (!containsKey(key)) {
			head = new MapNode<K, V>(key, value, head);
			++size;
			System.out.println("Added new record");
			return null;
		} else {
			MapNode<K, V> aux = head;
			while (!aux.getKey().equals(key)) {
				aux = aux.getNext();
			}
			V res = aux.getValue();
			aux.setValue(value);
			System.out.println("Updated old record");
			return res;
		}
	}

	@Override
	public V get(K key) {
		System.out.println("Called LinkedMap.get(" + key + ")");
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
		System.out.println("Called LinkedMap.containsKey(" + key + ")");
		if (size() != 0) {
			if (head.getKey().equals(key)) {
				System.out.println("TRUE");
				return true;
			} else {
				MapNode<K, V> aux = head;
				int sizeAux = size();
				while (sizeAux-- != 0) {
					if (aux.getKey().equals(key)) {
						System.out.println("TRUE");
						return true;
					}
					aux = aux.getNext();
				}
			}
		}
		System.out.println("FALSE");
		return false;
	}

	@Override
	public void clear() {
		System.out.println("Called LinkedMap.clear()");
		head = null;
		size = 0;
	}

	@Override
	public List<K> keySet() {
		System.out.println("Called LinkedMap.keySet()");
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
		System.out.println("Called LinkedMap.values()");
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
