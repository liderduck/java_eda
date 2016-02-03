package labo3_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
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
		boolean colaVacia=false;
		HashMap<String,String> revisados = new HashMap<String,String>();
		Stack<String> pila = new Stack<String>();
		Queue<String> cola = new LinkedList<String>();
		
		ArrayList<String> aux = new ArrayList<String>();
		aux = g.get(a1);//array auxiliar con todas las peliculas del primer actor
		revisados.put(a1, null);
		
		if (g.containsKey(a1) && (g.containsKey(a2))){
			
				while (encontrado != true && colaVacia!=true){
				
				for(int i=0;i<aux.size();i++){//carga las pelis en la pila
					pila.push(aux.get(i));
				}
				
				while(!pila.isEmpty()){//mientras la pila de peliculas no este vacia
					String actual = pila.pop();//coge la primera pelicula de la parte superior a de la pila.
					if(!revisados.containsKey(actual)){//si la pelicula en actual no esta en la hashmap
						ArrayList<String> aux2 = new ArrayList<String>();
						aux2=g.get(actual);//arraylist auxiliar 2 con todos los actores de esa pelicula anterior
						for(int j=0;j<aux2.size();j++){//recorre la array de actores
							if(!revisados.containsKey(aux2.get(j))){//comprueba si el actor esta en la hashmap
								if (!aux2.get(j).equals(a2)){//comprueba que el actor que tenemos no es el objetivoo
									cola.add(aux2.get(j));//a�ade el actor a la cola para analizarlo luego
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
					colaVacia=true;
				}else{
				 a1= cola.poll();
				aux=g.get(a1);	
				}
			}	
		}return  encontrado;
	}
	
	public ArrayList<String> estanConectados2(String a1, String a2){
		
		boolean encontrado=false;
		HashMap<String,String> revisados = new HashMap<String,String>();
		Queue<String> cola = new LinkedList<String>();
		ArrayList<String> aux = new ArrayList<String>();
		
		cola.add(a1);
		revisados.put(a1, "");
		
		if (g.containsKey(a1) && (g.containsKey(a2))){
			
				while (encontrado != true && !cola.isEmpty()){

					String actual = cola.poll();
					

					for(int j=0;j<g.get(actual).size();j++){
						aux = g.get(actual);
						String current = aux.get(j);
							if(!revisados.containsKey(current)){
								if (!current.equals(a2)){
									cola.add(current);
									revisados.put(current, actual);
								}else{
									encontrado=true;
									revisados.put(current, actual);
								}
							}
						
					}		
			}	
		}
		
		ArrayList<String> fin =new ArrayList<String>();
		
		if(encontrado==true){
		Stack<String> inversor = new Stack<String>();
		String corredor = revisados.get(a2);
		inversor.push(a2);
		while(!corredor.equals("")){

			inversor.push(corredor);
			corredor=revisados.get(corredor);
		}	

		while(!inversor.isEmpty()){
			fin.add(inversor.pop());
		}
		return  fin;
		}else{
		   fin.add("no tienen conexion");
		   
			return fin;
		}
		
		
	}
	
	public double gradoRelaciones(){
		double contador= 0;
		ListaActores actorcillos = ListadoActores.getListadoActores().getListaActores();
		ArrayList<String> ver = new ArrayList<String>();
		int prueba = 5000;
	
	for(int i=0;i<prueba;i++){	
		Random r = new Random();
		Integer ran1 = r.nextInt(ListadoActores.getListadoActores().size());
		Integer ran2 = r.nextInt(ListadoActores.getListadoActores().size());
		String a1 = actorcillos.getActor(ran1).getNombre();
		String a2 = actorcillos.getActor(ran2).getNombre();
		
		//me muestra los dos actores escogidos
		System.out.println(a1);
		System.out.println(a2);
		//obtengo la lista
		ver=estanConectados2(a1,a2);
		//para ver la lista
		for(int g=0;g<ver.size();g++){
			System.out.print(ver.get(g)+" -> ");
		}
		System.out.println();
	
		double valor = Math.abs(estanConectados2(a1,a2).size()-2);
		if (valor>1){
			 if ((valor/2)%10!=0){
				 valor=(valor/2)-0.5;
			 }else{
				 valor=(valor/2)-1;
			 }
		}else{
			valor=0;
		}
		
		contador=contador+valor;
		System.out.println(valor);
	}	
		contador=contador/prueba;
		System.out.println((contador));
		
		return 0;
		
	}
}