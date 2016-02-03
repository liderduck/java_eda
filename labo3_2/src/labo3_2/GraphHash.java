package labo3_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class GraphHash {

	HashMap<String, ArrayList<String>> g;

	
	public void crearGrafo(ListadoActores lActores){
		// Post: crea el grafo desde la lista de actores
		//       Los nodos son nombres de actores y títulos de películas 
           
            // COMPLETAR CÓDIGO
	
		ListaActores actorcillos = lActores.getListaActores();
	    g = new HashMap<String,ArrayList<String>>();
		
	    for (int i=0;i<actorcillos.size();i++){//recorremos la lista de actores
		ArrayList<String> aux = new ArrayList<String>();
		ListaPeliculas peliculillas = actorcillos.getActor(i).getListaPeliculas();
			
			if (!g.containsKey(actorcillos.getActor(i).getNombre())){//no contiene al actor como clave
				for (int j=0;j<peliculillas.size();j++){//recorremos la lista de peliculas del actor
					aux.add(peliculillas.getPelicula(j).getTitulo());
					ArrayList<String> aux2 = new ArrayList<String>();//para los actores
					if(!g.containsKey(peliculillas.getPelicula(j).getTitulo())){//si no contiene la pelicula como clave
						aux2.add(actorcillos.getActor(i).getNombre());
						g.put(peliculillas.getPelicula(j).getTitulo(),aux2);
					}else{
						aux2=g.get(peliculillas.getPelicula(j).getTitulo());
						aux2.add(actorcillos.getActor(i).getNombre());
						g.put(peliculillas.getPelicula(j).getTitulo(),aux2);
					}
				}
				g.put(actorcillos.getActor(i).getNombre(),aux);
			}
		}
	}
	
	public void print(){
		int i = 1;
		for (String s: g.keySet()){
			System.out.print("Element: " + i++ + " " + s + " --> ");
			for (String k: g.get(s)){
				System.out.print(k + " ### ");
			}
			System.out.println();
		}
	}
	
	public boolean estanConectados(String a1, String a2){
		
            // COMPLETAR CÓDIGO
		boolean encontrado=false;
		boolean pilaVacia=false;
		HashMap<String,String> revisados = new HashMap<String,String>();
		Stack<String> pila = new Stack<String>();
		Queue<String> cola = new LinkedList<String>();
		
		ArrayList<String> aux = new ArrayList<String>();
		aux = g.get(a1);
		
		if (g.containsKey(a1) && (g.containsKey(a2))){
			
				while (encontrado != true && pilaVacia!=true){
				
				for(int i=0;i<aux.size();i++){//carga las pelis en la pila
					pila.push(aux.get(i));
				}
				
				while(!pila.isEmpty() && encontrado != true){
					String actual = pila.pop();
					if(!revisados.containsKey(actual)){
						ArrayList<String> aux2 = new ArrayList<String>();
						aux2=g.get(actual);
						for(int j=0;j<aux2.size();j++){
							if(!revisados.containsKey(aux2.get(j))){
								if (!aux2.get(j).equals(a2)){
									cola.add(aux2.get(j));
									revisados.put(aux2.get(j), null);
									if(!revisados.containsKey(actual)){
										revisados.put(actual, null);
									}
								}else{
									encontrado=true;
								}
							}
						}
					}
				}
				if (cola.isEmpty()){
					pilaVacia=true;
				}
				String a3= cola.poll();
				aux=g.get(a3);	
			}	
		}return  encontrado;
	}
	
	public static void main(String[] args){
		ListadoPeliculas lisPeliculas = ListadoPeliculas.getListadoPeliculas();
		ListadoActores lisActores = ListadoActores.getListadoActores();
		new Leer(lisPeliculas, lisActores);
		GraphHash g = new GraphHash();
		g.crearGrafo(lisActores);
		g.print(); 
	if(g.estanConectados("Cristian, Bale", "Pitt, Brad")){
		System.out.println("true");
	}else{
		System.out.println("false");
	}
	
	if(g.estanConectados("Cristian, Bale", "Linares, Rebeca")){
		System.out.println("true");
	}else{
		System.out.println("false");
	}
	}
	
}