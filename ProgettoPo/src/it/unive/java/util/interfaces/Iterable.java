package it.unive.java.util.interfaces;

import it.unive.java.util.impl.IteratorType;

public interface Iterable<U> {
	Iterator<U> iterator(IteratorType value);
}
