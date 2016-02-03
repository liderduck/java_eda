package labo3_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class GraphHash {

	HashMap<String, ArrayList<String>> g;

	
	public void crearGrafo(){
		// Post: crea el grafo desde la lista de actores
		//       Los nodos son nombres de actores y títulos de películas 
           
            // COMPLETAR CÓDIGO
	
		ListaActores actorcillos = ListadoActores.getListadoActores().getListaActores();
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
	
		double prueba = 100;//numero de pares por los que empezar
		double media1;
		double media2= 0;
		double coef=0.6;//lo pongo asi para forzar el while
		double coferror=0.05;
	while(Math.abs(coef)>=coferror){//lo pongo en valor absoluto porque puede dar negativo
		media1=0;
				for(int i=0;i<prueba;i++){	
					String a1= ListadoActores.getListadoActores().actorRandom();
					String a2= ListadoActores.getListadoActores().actorRandom();
				
		
					double valor = estanConectados2(a1,a2).size();
					if (valor>1){
						 valor=(valor/2)-0.5;
					}else{
						valor=0;
					}
					
					media1=media1+valor;
				}	
			
		media1=media1/prueba;
		coef=media1-media2;
		media2=media1;			
		prueba=prueba*2;					
	}	
		return media2;
}
	
	public double centralidad(Actor a){
		
		ArrayList<String> camino = new ArrayList<String>();
		double prueba=25000;
		double cont=0;
		
		for(int i=0;i<prueba;i++){	
			String a1= ListadoActores.getListadoActores().actorRandom();
			String a2= ListadoActores.getListadoActores().actorRandom();
		
			
			//obtengo el camino
				camino=estanConectados2(a1,a2);
			//cuento las veces k sale en el camino			
			for(int g=0;g<camino.size();g++){
				if (a.getNombre().equals(camino.get(g))){
					cont++;
				}
			}
		}	
		cont=cont/prueba;
		return cont;
		
	}
	
	public ArrayList<String> losMasCentrales(int n){
		
		ArrayList<String> camino = new ArrayList<String>();
		ArrayList<String> central = new ArrayList<String>();
		ArrayList<String> nCentral = new ArrayList<String>();
		HashMap<String,Integer> ths1=new HashMap<String,Integer>();
		double prueba=20000;
		
		for(int i=0;i<prueba;i++){	
	
			String a1= ListadoActores.getListadoActores().actorRandom();
			String a2= ListadoActores.getListadoActores().actorRandom();
		
			//obtengo el camino
				camino=estanConectados2(a1,a2);
			
			if (camino.size()!=1){		
				for(int g=0;g<camino.size();g++){//obtenemos el camino,y cogemos todos los que salen en la array
					if((g%2)==0){
						if (!ths1.containsKey(camino.get(g))){
							ths1.put(camino.get(g), 1);
						}else{
							int contact=ths1.get(camino.get(g));
							contact++;
							ths1.put(camino.get(g),contact);
						}
					}
				}
			}			
		}
				
		if (n>ths1.size()){
			System.out.println(n+"es mayor al numero de elementos de la array");
			System.out.println("se ajustara el valor de N al tama�o de la array");
			n=ths1.size();
		}
		
		for (String s: ths1.keySet()){//pasa la hash a una array
			central.add(s);
		}
		
		//ordenar central.
		quickSortHash(central,0,central.size()-1,ths1);
		
		//sacar por detras los N mas altos.
		for(int f=central.size()-1;f>=central.size()-n;f--){
			nCentral.add(central.get(f));
		}

		return nCentral;
	}
	
	
	//un quickshor alterado para acceder a la hash para coger el numero de apariciones.
	private void quickSortHash(ArrayList<String>pLista, int inicio, int fin,HashMap<String,Integer> ths1){
		int i = inicio;
		int j = fin;
		String pivote = pLista.get((i+j)/2);
		do {
			while(ths1.get(pLista.get(i)) < ths1.get(pivote))
				{
					i++;
				}
			while(ths1.get(pLista.get(j)) > ths1.get(pivote))
				{
					j--;
				}if(i<=j)
					{//trozo reescrito,pues sin setNombre hay que separar las instrucciones.
						String aux = pLista.get(i);
						String aux2 = pLista.get(j);
						pLista.add(j, aux);pLista.remove(j+1);//uso el add que inserta en la posicion dicha,pero desplaza todo una posicion,por eso el remove siguiente.
						pLista.add(i, aux2);pLista.remove(i+1);
						i++;
						j--;
					}
			}while(i<=j);
		if(inicio<j){
			quickSortHash(pLista, inicio, j,ths1);
		}
		if(i<fin){
			quickSortHash(pLista, i, fin,ths1);
		}
		
	}	
	
	
}
