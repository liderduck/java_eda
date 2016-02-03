package org.eda.examenJulio2013Ejercicio3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;



public class GrafoJuego extends GraphAL<Casilla>{
	
	
	
	
	public SimpleLinkedList<Casilla> camino(Casilla comienzo, Casilla fin,HashMap<Integer,ArrayList<Casilla>> hs1)
	{
		SimpleLinkedList<Casilla> l1= new SimpleLinkedList<Casilla>();
		Queue<Casilla> cola=new LinkedList<Casilla>();
		HashMap<Casilla,Casilla> visitados= new HashMap<Casilla,Casilla>();
		
		boolean enc=false;
		cola.add(comienzo);
		visitados.put(comienzo, null);
		
		while(!cola.isEmpty() && enc==false){
			Casilla actual=cola.poll();
			
			if(actual==fin){
				enc=true;
			}else{
				ArrayList<Casilla> colega= new ArrayList<Casilla>();
				colega=hs1.get(actual.getValor());
				for(int i=0;i<colega.size();i++){
					Casilla sig=colega.get(i);
					if(sig.getColor()!=actual.getColor() && !visitados.containsKey(sig)){
						cola.add(sig);
						visitados.put(sig,actual);
					}
				}
			}
		}
		
		if (enc==true){
			l1.add(fin);
			Casilla calle = visitados.get(fin);
			while(calle!=null){
				l1.add(calle);
				calle=visitados.get(calle);
			}
		}
		l1.visualizarNodos();
		return l1;
		
	}
	
	private int buscarPorVertice(Casilla casillaObj)
	{
		
		boolean encontrado=false;
		int pos=0;
		
		while(!encontrado && pos<this.numVertices)
		{
			Casilla casillaAct= this.vertices[pos];
			
			
			if(casillaAct.equals(casillaObj))
			{
				encontrado=true;
			}
			else
			{
				pos++;
			}
		}
		
		if(!encontrado){
		return -1;}
		else
		{
			return pos;
		}
	}
	
	private SimpleLinkedList<Casilla> encontrarCamino(SimpleLinkedList<Casilla> l1, int posComienzo, int posFin)
	{
		
		boolean[] marca= new boolean[this.numVertices];
		boolean conectados=false;
		
		for(int i=0;i<this.numVertices;i++)
		{
			marca[i]= false;
		}
		
		HashMap<Casilla,Casilla> referencias= new HashMap<Casilla,Casilla>();
		referencias.put(this.vertices[posComienzo], null);
		
		Cola<Casilla> colaCasillas= new Cola<Casilla>();
		
		colaCasillas.insert(this.vertices[posComienzo]);
		marca[posComienzo]=true;
		
		while(!colaCasillas.isEmpty() && !conectados)
		{
			Casilla pCasilla= colaCasillas.remove();
			
			int pos= this.buscarPorVertice(pCasilla);
			
			NodeSimple<Integer> current= this.adjList[pos].first;
			
			while(!conectados && current!=null)
			{
				
				Casilla casillaColega= this.vertices[current.data];
				
				int posColega= this.buscarPorVertice(casillaColega);
				
				if((casillaColega.equals(this.vertices[posFin]))&& casillaColega.getColor()!=pCasilla.getColor())
				{
					conectados=true;
					referencias.put(casillaColega, pCasilla);
				}
				else
				{
					if(!marca[posColega] && casillaColega.getColor()!=pCasilla.getColor())
					{
						colaCasillas.insert(casillaColega);
						marca[posColega]=true;
						referencias.put(casillaColega, pCasilla);
					}
				}
				current=current.next;
				
			}
			
			
			
			
		}
		
		

		
		if(conectados)
		{
			//variables auxiliares que usaremos para movernos en la hashmap de las relaciones
			Casilla cDestino= this.vertices[posFin];
			Casilla cOrigen= referencias.get(cDestino);

			boolean fin=false;
	
			//este trozo de codigo busca continuamente los actores y sus origenes y va creando relaciones
			while(!cDestino.equals(this.vertices[posComienzo]) && !fin)
			{	
				if(cOrigen==null)
				{
					fin=true;
				}
				else
				{
					
					l1.add(cDestino);
					
					cDestino=cOrigen;
					cOrigen= referencias.get(cDestino);

				}
			}
	
			l1.add(cDestino);
		
		}
		
		if(!conectados)
		{
			System.out.println("No existe un camino posible entre las dos casillas indicadas");
		}
		else
		{
			l1.visualizarNodos();
		}
		return l1;
	}
	
	
	public Casilla getCasilla(int i)
	{
		if(i>=this.numVertices || i<0)
		{
			System.out.println("Limites excedidos");
			return null;
		}
		else
		{
			return this.vertices[i];
		}
	}
	


	public void cargarGrafo()
	{
		Casilla c1= new Casilla("negro",13);
		Casilla c2= new Casilla("negro",9);
		Casilla c3= new Casilla("negro",7);
		Casilla c4= new Casilla("negro",3);
		Casilla c5= new Casilla("negro",12);
		Casilla c6= new Casilla("negro",17);

		Casilla c7= new Casilla("blanco",11);
		Casilla c8= new Casilla("blanco",5);
		Casilla c9= new Casilla("blanco",8);
		Casilla c10= new Casilla("blanco",1);
		Casilla c11= new Casilla("blanco",4);
		Casilla c12= new Casilla("blanco",20);


		this.addVertex(c1);
		this.addVertex(c2);
		this.addVertex(c3);
		this.addVertex(c4);
		this.addVertex(c5);
		this.addVertex(c6);
		this.addVertex(c7);
		this.addVertex(c8);
		this.addVertex(c9);
		this.addVertex(c10);
		this.addVertex(c11);
		this.addVertex(c12);

		//casilla 13
		this.addEdge(c1, c9);
		this.addEdge(c1, c8);
		this.addEdge(c1, c7);
		
		//casilla 9
		this.addEdge(c2, c8);
		this.addEdge(c2, c9);
		this.addEdge(c2, c3);
		this.addEdge(c2, c5);
		this.addEdge(c2, c4);
		this.addEdge(c2, c10);
		
		//casilla 7
		this.addEdge(c3, c3);
		this.addEdge(c3, c5);
		
		
		//casilla 3
		this.addEdge(c4, c2);
		this.addEdge(c4, c10);
		this.addEdge(c4, c11);
		this.addEdge(c4, c6);
		this.addEdge(c4, c5);
		
		//casilla 12
		this.addEdge(c5, c3);
		this.addEdge(c5, c2);
		this.addEdge(c5, c4);
		this.addEdge(c5, c6);
		this.addEdge(c5, c12);
		
		//casilla 17
		this.addEdge(c6, c4);
		this.addEdge(c6, c10);
		this.addEdge(c6, c11);
		this.addEdge(c6, c12);
		this.addEdge(c6, c5);
	
		
		//casilla 11
		this.addEdge(c7, c8);
		this.addEdge(c7, c1);
		
		
		//casilla 5
		this.addEdge(c8, c7);
		this.addEdge(c8, c8);
		this.addEdge(c8, c1);
		this.addEdge(c8, c9);
		
		//casilla 8
		this.addEdge(c9, c1);
		this.addEdge(c9, c8);
		this.addEdge(c9, c2);
		
		//casilla 1
		this.addEdge(c10, c2);
		this.addEdge(c10, c4);
		this.addEdge(c10, c6);
		this.addEdge(c10, c11);
		
		//casilla 4
		this.addEdge(c11, c10);
		this.addEdge(c11, c4);
		this.addEdge(c11, c6);
		this.addEdge(c11, c12);
		
		//casilla 20
		this.addEdge(c12, c11);
		this.addEdge(c12, c6);
		this.addEdge(c12, c5);
	}

	
	public void visualizarGrafo()
	{
		
		//por cada vertice
		for(int i=0;i<this.numVertices;i++)
		{
			//generamos un apuntador al primer elemento de la lista en el vertice i-esimo
		NodeSimple<Integer> current=this.adjList[i].first;
		
				System.out.println("La casilla " + this.vertices[i].getColor()+","+this.vertices[i].getValor()+" esta conectada con: ");
				
				int pos=1;
			while(current!=null)
			{
				System.out.println(pos+"- "+this.vertices[current.data].getColor()+","+this.vertices[current.data].getValor());
				current=current.next;
				pos++;
			}
		
		}
		
	}
	
	
}
