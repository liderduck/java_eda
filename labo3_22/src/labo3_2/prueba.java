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
		System.out.println("Probando a Christian Bale con Brad Pitt.El resultado esperado es que sean colegas");
		if(g.estanConectados("Trejo, Danny", "Drury, Archie")){
		System.out.println("Son colegas");
		}else{
			System.out.println("No son colegas");
		}
		
		System.out.println("############");
		System.out.println("Probando a Christian Bale con Rebeca Linares.El resultado esperado es que sean colegas");
		if(g.estanConectados("Pell, Rhoda", "Lange, Allison")){
		System.out.println("Son colegas");
		}else{
			System.out.println("No son colegas");
		}
		
		System.out.println("############");
		System.out.println("Probando a Christian Bale con Carmen electra.El resultado esperado es que NO sean colegas");
		if(g.estanConectados("Huntington, Alaine", "Pell, Rhoda")){
			System.out.println("Son colegas");
			}else{
				System.out.println("No son colegas");
			}
		
		System.out.println();
		
		System.out.println("############");
		System.out.println("Veamos lo que une a Christian Bale con Rebeca Linares");
		ver=g.estanConectados2("Trejo, Danny", "Drury, Archie");
		visualizarNodo(ver); 
		
		System.out.println();
		System.out.println();
		
		System.out.println("############");
		System.out.println("Veamos lo que une a Christian Bale con Brad Pitt");
		ver=g.estanConectados2("Pell, Rhoda", "Lange, Allison");
		visualizarNodo(ver);
		
		System.out.println();
		System.out.println();
		
		System.out.println("############");
		System.out.println("Veamos lo que une a Christian Bale con Carmen Electra");
		ver=g.estanConectados2("Huntington, Alaine", "Pell, Rhoda");
		visualizarNodo(ver);
		
	}
}