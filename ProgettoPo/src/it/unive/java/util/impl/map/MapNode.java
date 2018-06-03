package it.unive.java.util.impl.map;

public class MapNode<K, V> {

	private K key;
	private V value;
	private MapNode<K, V> next;

	public MapNode(K key, V value, MapNode<K, V> next) {
		this.key = key;
		this.value = value;
		this.next = next;
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public MapNode<K, V> getNext() {
		return next;
	}

	public void setNext(MapNode<K, V> next) {
		this.next = next;
	}

}
