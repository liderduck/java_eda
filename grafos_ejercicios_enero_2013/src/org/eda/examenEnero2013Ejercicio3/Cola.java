package org.eda.examenEnero2013Ejercicio3;

public class Cola<T> {

	private Node<T> front;
	private Node<T> rear;
	private int count;
	
	
	public Cola()
	{
		this.front=null;
		this.rear=null;
		this.count=0;
	}
	
	
	
	public int size()
	{
		return this.count;
	}
	
	
	public boolean isEmpty()
	{
		return this.count==0;
	}
	
	
	public void insert(T elem)
	{
		Node<T> nuevoNodo= new Node<T>(elem);
		if(this.isEmpty())
		{
			this.front=nuevoNodo;
		}
		else
		{
			this.rear.next=nuevoNodo;
		
		}
		this.rear=nuevoNodo;
		this.count++;
	}
	
	
	public T first()
	{
		if(this.isEmpty())
		{
			return null;
		}
		else
		{
			return this.front.data;
		}
	}
	
	
	public T remove()
	{
		if(this.isEmpty())
		{
			return null;
		}
		else
		{
			T elemAux= this.front.data;
			if(this.size()==1)
			{
				this.front=null;
				this.rear=null;
			}
			else
			{
				this.front=this.front.next;
			}
			this.count--;
			return elemAux;
		}
	}
	
}
