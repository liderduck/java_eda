package org.eda.examenJulio2013Ejercicio3;

import java.util.ArrayList;
import java.util.HashMap;

public class pruebaGrafoJuego {

	
	public static void main(String[] args){
		GrafoJuego g1= new GrafoJuego();
		
		Casilla c1;
		Casilla c2;
		Casilla c3;
		Casilla c4;
		Casilla c5;
		Casilla c6;
		Casilla c7;
		Casilla c8;
		Casilla c9;
		Casilla c10;
		Casilla c11;
		Casilla c12;
		
		c1= new Casilla("negro",13);
		c2= new Casilla("negro",9);
		c3= new Casilla("negro",7);
		c4= new Casilla("negro",3);
		c5= new Casilla("negro",12);
		c6= new Casilla("negro",17);

		c7= new Casilla("blanco",11);
		c8= new Casilla("blanco",5);
		c9= new Casilla("blanco",8);
		c10= new Casilla("blanco",1);
		c11= new Casilla("blanco",4);
		c12= new Casilla("blanco",20);


		g1.addVertex(c1);
		g1.addVertex(c2);
		g1.addVertex(c3);
		g1.addVertex(c4);
		g1.addVertex(c5);
		g1.addVertex(c6);
		g1.addVertex(c7);
		g1.addVertex(c8);
		g1.addVertex(c9);
		g1.addVertex(c10);
		g1.addVertex(c11);
		g1.addVertex(c12);

		//casilla 13
		g1.addEdge(c1, c9);
		g1.addEdge(c1, c8);
		g1.addEdge(c1, c7);
		
		//casilla 9
		g1.addEdge(c2, c8);
		g1.addEdge(c2, c9);
		g1.addEdge(c2, c3);
		g1.addEdge(c2, c5);
		g1.addEdge(c2, c4);
		g1.addEdge(c2, c10);
		
		//casilla 7
		g1.addEdge(c3, c3);
		g1.addEdge(c3, c5);
		
		
		//casilla 3
		g1.addEdge(c4, c2);
		g1.addEdge(c4, c10);
		g1.addEdge(c4, c11);
		g1.addEdge(c4, c6);
		g1.addEdge(c4, c5);
		
		//casilla 12
		g1.addEdge(c5, c3);
		g1.addEdge(c5, c2);
		g1.addEdge(c5, c4);
		g1.addEdge(c5, c6);
		g1.addEdge(c5, c12);
		
		//casilla 17
		g1.addEdge(c6, c4);
		g1.addEdge(c6, c10);
		g1.addEdge(c6, c11);
		g1.addEdge(c6, c12);
		g1.addEdge(c6, c5);
	
		
		//casilla 11
		g1.addEdge(c7, c8);
		g1.addEdge(c7, c1);
		
		
		//casilla 5
		g1.addEdge(c8, c7);
		g1.addEdge(c8, c8);
		g1.addEdge(c8, c1);
		g1.addEdge(c8, c9);
		
		//casilla 8
		g1.addEdge(c9, c1);
		g1.addEdge(c9, c8);
		g1.addEdge(c9, c2);
		
		//casilla 1
		g1.addEdge(c10, c2);
		g1.addEdge(c10, c4);
		g1.addEdge(c10, c6);
		g1.addEdge(c10, c11);
		
		//casilla 4
		g1.addEdge(c11, c10);
		g1.addEdge(c11, c4);
		g1.addEdge(c11, c6);
		g1.addEdge(c11, c12);
		
		//casilla 20
		g1.addEdge(c12, c11);
		g1.addEdge(c12, c6);
		g1.addEdge(c12, c5);
		
		HashMap<Integer,ArrayList<Casilla>> adyacentes= new HashMap<Integer,ArrayList<Casilla>>();
		ArrayList<Casilla> mola = new ArrayList<Casilla>();
		mola.add(c8);
		mola.add(c1);
		adyacentes.put(11, mola);
		
		mola=new ArrayList<Casilla>();
		mola.add(c7);
		mola.add(c8);
		mola.add(c9);
		adyacentes.put(13,mola);
		
		mola=new ArrayList<Casilla>();
		mola.add(c1);
		mola.add(c7);
		mola.add(c9);
		adyacentes.put(5,mola);
		
		mola=new ArrayList<Casilla>();
		mola.add(c2);
		mola.add(c1);
		mola.add(c8);
		adyacentes.put(8,mola);
		
		mola=new ArrayList<Casilla>();
		mola.add(c9);
		mola.add(c8);
		mola.add(c3);
		mola.add(c5);
		mola.add(c4);
		mola.add(c10);
		adyacentes.put(9,mola);
		
		mola=new ArrayList<Casilla>();
		mola.add(c2);
		mola.add(c3);
		mola.add(c5);
		mola.add(c6);
		mola.add(c10);
		mola.add(c11);		
		adyacentes.put(3,mola);
		
		mola=new ArrayList<Casilla>();
		mola.add(c3);
		mola.add(c6);
		mola.add(c12);
		mola.add(c1);
		adyacentes.put(12,mola);
		
		mola=new ArrayList<Casilla>();
		mola.add(c2);
		mola.add(c4);
		mola.add(c6);
		mola.add(c11);		
		adyacentes.put(1,mola);
		
		mola=new ArrayList<Casilla>();
		mola.add(c5);
		mola.add(c4);
		mola.add(c10);
		mola.add(c11);	
		mola.add(c12);
		adyacentes.put(17,mola);
		
		mola=new ArrayList<Casilla>();
		mola.add(c10);
		mola.add(c4);
		mola.add(c6);
		mola.add(c12);		
		adyacentes.put(4,mola);
		
		mola=new ArrayList<Casilla>();
		mola.add(c5);
		mola.add(c6);
		mola.add(c11);		
		adyacentes.put(20,mola);
		
		
		g1.camino(c7,c12 , adyacentes);
	}

}
