package it.unive.java.util.impl.list;

public class Node<E> {

	private E elem;
	private Node<E> next;

	public Node(E elem, Node<E> next) {
		this.elem = elem;
		this.next = next;
	}

	public E getElem() {
		return elem;
	}

	// TODO: da verificare se rendere il nodo mutabile o meno
	public void setElem(E elem) {
		this.elem = elem;
	}

	public Node<E> getNext() {
		return next;
	}

	public void setNext(Node<E> next) {
		this.next = next;
	}

}
