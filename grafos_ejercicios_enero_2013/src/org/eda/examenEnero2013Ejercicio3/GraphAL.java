package org.eda.examenEnero2013Ejercicio3;

public class GraphAL<T> {

	protected static int DEFAULT_CAPACITY=100;
	protected int numVertices;
	protected SimpleLinkedList<Integer>[] adjList;
	protected String[] vertices;
	
	
	public GraphAL()
	{
		this.numVertices=0;
		this.adjList= (SimpleLinkedList<Integer>[]) new SimpleLinkedList[DEFAULT_CAPACITY];
		
		for (int i=0; i<DEFAULT_CAPACITY;i++)
		{
			this.adjList[i]= new SimpleLinkedList<Integer>();
		}
		
		this.vertices= new String[DEFAULT_CAPACITY];
	}
	
	
	public void addVertex(String v1)
	{
		if(!this.yaExisteVertice(v1))
		{
			this.vertices[this.numVertices]= v1;
			this.numVertices++;
		}
		else
		{
			System.out.println("El vertice ya se encontraba en el grafo, asi que no ha sido posible anadirlo");
		}
	}
	
	
	public boolean yaExisteVertice(String v1)
	{
		boolean encontrado=false;
		int pos=0;
		
		while(pos<this.numVertices && !encontrado)
		{
			if(this.vertices[pos].equals(v1))
			{
				encontrado=true;
			}
			else
			{
				pos++;
			}
		}
		
		return encontrado;
	}
	
	public int buscarPosicionVertice(T v1)
	{
		int pos=0;
		boolean encontrado=false;
		
		while(!encontrado && pos<this.numVertices)
		{
			if(this.vertices[pos].equals(v1))
			{
				encontrado=true;
			}
			else
			{
				pos++;
			}
		}
		
		if(!encontrado)
		{
			return -1;
		}
		else
		{
			return pos;
		}
	}
	
	public void addEdge(T v1,T v2)
	{
		int posv1= this.buscarPosicionVertice(v1);
		int posv2= this.buscarPosicionVertice(v2);
		
		if((posv1==-1) || (posv2==-1))
		{
			System.out.println("Lo sentimos pero alguno de los nodos no se encuentra en el grafo");
		}
		else
		{
			if(this.adjList[posv1].contains(posv2))
			{
				System.out.println("La relacion entre los dos nodos ya se habia creado. No se puede volver a anadir");
			}
			else
			{
				this.adjList[posv1].add(posv2);
			}
		}
	}
}
