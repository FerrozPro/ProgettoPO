package it.unive.java.util.interfaces;

public interface Map<K, V> {

	V put(K key, V value);

	V get(K key);

	boolean containsKey(K key);

	void clear();

	List<K> keySet();

	List<V> values();
	
	int size();

}
