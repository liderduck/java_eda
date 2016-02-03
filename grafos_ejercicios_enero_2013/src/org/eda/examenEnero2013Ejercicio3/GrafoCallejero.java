package org.eda.examenEnero2013Ejercicio3;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class GrafoCallejero extends GraphAL<String> {

	
	
	public SimpleLinkedList<String> buscarCamino(String inicio, String fin, SimpleLinkedList<String> enObras)
	{
		SimpleLinkedList<String> l1= new SimpleLinkedList<String>();
		HashMap<String,String> hs1=new HashMap<String,String>();
		int posIni=buscarPosicionVertice(inicio);
		int posFin=buscarPosicionVertice(fin);
		boolean enc=false;
		if (posIni==-1){
			System.out.println("no existe");
		}else if (posFin==-1){
			System.out.println("no existe");
		}else{
			Queue<String> cola= new LinkedList<String>();
			
			Node<String> current=enObras.first;
			while (current!=null){
				hs1.put(current.data,"en obras");
				current=current.next;
			}
			
			cola.add(inicio);
			hs1.put(inicio, "1");
			while (!cola.isEmpty()&& enc==false){
				String calleActual=cola.poll();
				int posCalleActual=buscarPosicionVertice(calleActual);
				
				if(calleActual==fin){
					enc=true;
				}else{
					Node<Integer> actual= adjList[posCalleActual].first;
					
					while(actual!=null){
						String calle= vertices[actual.data];
						if (!hs1.containsKey(calle)){
							cola.add(calle);
							hs1.put(calle, calleActual);
						}
					actual=actual.next;
					}
				}
			}
		}
		
		if (enc==true){
			l1.add(fin);
			String calle = hs1.get(fin);
			while(calle!="1"){
				l1.add(calle);
				calle=hs1.get(calle);
			}
		}
		l1.visualizarNodos();
		return l1;
	}
	
}
