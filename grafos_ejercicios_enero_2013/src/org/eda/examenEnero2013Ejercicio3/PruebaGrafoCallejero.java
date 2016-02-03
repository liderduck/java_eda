package org.eda.examenEnero2013Ejercicio3;


public class PruebaGrafoCallejero {

	GrafoCallejero g1;
	SimpleLinkedList<String> listaObras;
	
	
	public static void main(String[] args){
		GrafoCallejero g1=new GrafoCallejero();
		SimpleLinkedList<String>listaObras= new SimpleLinkedList<String>();
	
		
		//CREAMOS LAS CALLES
		g1.addVertex("A");
		g1.addVertex("B");
		g1.addVertex("C");
		g1.addVertex("D");
		g1.addVertex("E");
		g1.addVertex("F");
		g1.addVertex("G");
		g1.addVertex("H");
		g1.addVertex("I");
		g1.addVertex("J");
		
		//ESTAS SON LAS UNIONES UNIDIRECCIONALES QUE EXISTEN ENTRE LAS CALLES
		
		//CALLEA
		g1.addEdge("A", "B");
		g1.addEdge("A", "C");
		
		//CALLE B
		g1.addEdge("B", "D");
		
		//CALLE C
		g1.addEdge("C", "G");
		
		//CALLE D
		g1.addEdge("D", "E");
		
		//CALLE E
		g1.addEdge("E", "F");
		g1.addEdge("E", "G");
		
		//CALLE F
		g1.addEdge("F", "H");
		g1.addEdge("F", "I");
		
		//CALLE G
		g1.addEdge("G", "J");
		
		//CALLE H
		
		//CALLE I
		
		//CALLE J
		g1.addEdge("J", "C");
		
		
		//CREAMOS LA LISTA DE LAS CALLES EN OBRAS
		listaObras.add("C");
		listaObras.add("E");
		listaObras.add("I");
		
		
		g1.buscarCamino("D", "G", listaObras);

	}


}
