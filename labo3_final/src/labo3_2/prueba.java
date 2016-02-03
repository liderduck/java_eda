package labo3_2;

import java.util.ArrayList;

public class prueba {
	
	public static void visualizarNodo(ArrayList<String> lista){
		for(int i=0;i<lista.size();i++){
			System.out.print(lista.get(i)+" -> ");
		}
	}
	
	public static void main(String[] args){
		
		ListadoPeliculas lisPeliculas = ListadoPeliculas.getListadoPeliculas();
		ListadoActores lisActores = ListadoActores.getListadoActores();
		new Leer(lisPeliculas, lisActores);
		GraphHash g = new GraphHash();
		g.crearGrafo(lisActores);
		g.print(); 
		ArrayList<String> ver = new ArrayList<String>();
	
		System.out.println();
		
		//pruebas
		System.out.println("############");
		System.out.println("Probando a  ");
		if(g.estanConectados("Lawrence, Jeniffer", "Oldman, Gary")){
		System.out.println("Son colegas");
		}else{
			System.out.println("No son colegas");
		}	
				
		System.out.println();
	/*	
		System.out.println("############");
		System.out.println("Veamos lo que une a ");
		ver=g.estanConectados2("Ludacris", "Cage, Nicolas");
		visualizarNodo(ver); 
		
		System.out.println();
		System.out.println();  */
		
//		g.gradoRelaciones();
		
		
	}
}