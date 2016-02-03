package org.eda.examenEnero2013Ejercicio3;

	public class Node<T> {
		public T data; 			// dato del nodo
		public Node<T> next; 	// puntero al siguiente nodo de la lista, null si
								// último
		// -------------------------------------------------------------

		public Node(T dd) 		// constructor
		{
			data = dd;
			next = null;
		}
	}


