package org.eda.examenJulio2013Ejercicio3;

public class Node<T> {

	public T data;
	public Node<T> next;
	public Node<T> prev;
	
	
	
	public Node(T dd)
	{
		this.data=dd;
		this.next=null;
		this.prev=null;
	}
	
}
