package labo3_2;

import java.util.ArrayList;

public class prueba {
	
	public static void visualizarNodo(ArrayList<String> lista){
		for(int i=0;i<lista.size();i++){
			System.out.print(lista.get(i)+" -> ");
		}
	}
	
	public static void main(String[] args){
		long TInicio,TFin,tiempo; 					//sirve para obtener el tiempo al final
		TInicio=System.currentTimeMillis();
		ArrayList<String> centrales=new ArrayList<String>();
		
		ListadoActores.getListadoActores().leer();
		double media=0;
		double centralidad=0;
		
		
		GraphHash g = new GraphHash();
		g.crearGrafo();
		System.out.println("############Grafo creado############");

		
		//@@@@@@@@@@@@@@@@@@@@@@@@@PRACTICA A@@@@@@@@@@@@@@@@@@@@

		media=g.gradoRelaciones();
		System.out.println("############");
		System.out.println("La media de conexion es de:");
		System.out.println(media);
	
		//######################PRACTICA B#########################
		Actor a1 = new Actor("Jackman, Hugh");
		centralidad=g.centralidad(a1);
		System.out.println("############");
		System.out.println("Veamos la centralidad de :Jackman, Hugh");
		System.out.println(centralidad);
	
		// &&&&&&&&&&&&&&&&&   PRACTICA C &&&&&&&&&&&&&&&&&&&&&&&&
		int n=1000;//numero de actores ha mostrar
		centrales=g.losMasCentrales(n);
		
		System.out.println("###############");
		System.out.println("Los "+n+" actores mas centrales son,por orden descendente:");
		for(int i=0;i<centrales.size();i++){
			System.out.print(centrales.get(i)+" >> ");
		}
		System.out.println();
		
		
		TFin=System.currentTimeMillis();
		tiempo=TFin-TInicio;
		tiempo= (tiempo/1000);
		System.out.println("el tiempo de computacion ha sido de "+tiempo);
		
		
		
	}
}