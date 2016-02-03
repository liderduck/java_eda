package org.eda.examenJulio2013Ejercicio3;



public class GraphAL<T> {

	protected final int DEFAULT_CAPACITY=100;
	protected int numVertices;
	protected SimpleLinkedList<Integer>[] adjList;
	protected Casilla[] vertices;
	

	
	public GraphAL()
	{
		this.numVertices=0;
		this.adjList= (SimpleLinkedList<Integer>[])new SimpleLinkedList[this.DEFAULT_CAPACITY];
		
		for(int i=0;i<DEFAULT_CAPACITY;i++)
		{
			this.adjList[i]=new SimpleLinkedList<Integer>();
		}
		
		this.vertices= new Casilla[DEFAULT_CAPACITY];
	}

	
	public boolean yaExisteVertice(Casilla casilla)
	{
		boolean encontrado=false;
		int pos=0;
		
		while(!encontrado & pos<this.numVertices)
		{
			if(this.vertices[pos].equals(casilla))
			{
				System.out.println("vertice encontrado");
				encontrado=true;
			}
			else
			{
				pos++;
			}
		}
		
		return encontrado;
		
		
	}
	
	public void addVertex(Casilla casilla)
	{
	
		
		if(this.yaExisteVertice(casilla))
		{
			System.out.println("El vertice ya se encontraba en el grafo");
		}
		else
		{
			if(this.numVertices==this.DEFAULT_CAPACITY)
			{
				System.out.println("Se ha llegado al numero maximo de vertices que se pueden crear");
			}
			else
			{
				System.out.println("Vertice "+casilla.toString()+" anadido correctamente");
				this.vertices[numVertices]= casilla;
				numVertices++;
			}
			
		}
		
	}
	
	
	public int buscarPosVertice(T vertex)
	{
		int pos=0;
		boolean encontrado=false;
		
		while(!encontrado && pos<this.numVertices)
		{
			if(this.vertices[pos].equals(vertex))
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
	
	
	public void addEdge(T vertex1,T vertex2)
	{
		//pre: los vertices 1 y 2 existen en el grafo
		//post: crea una union entre ambos vertices
		
		
		int posV1= this.buscarPosVertice(vertex1);
		int posV2= this.buscarPosVertice(vertex2);
		
		
		if((posV1==-1) || (posV2==-1))
		{
			System.out.println("Alguno de los 2 vertices no existe en el grafo");
		}
		else
		{
			if(!this.adjList[posV1].contains(posV2))
			{
			this.adjList[posV1].add(posV2);
			System.out.println("se ha creado un arco entre "+vertex1+" y "+vertex2);
			}
			else
			{
				System.out.println("Ya se encontraba esa relacion. No se ha anadido por segunda vez");
			}
			
		}
	}
	
	

	
	
}
