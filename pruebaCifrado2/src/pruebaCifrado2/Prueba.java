package pruebaCifrado2;

import java.util.LinkedList;
import java.util.Queue;

public class Prueba {

	public void cifrar(String cadena,Queue<Integer> posiciones){
		Character[] salida = new Character[cadena.length()];
		
		
	
	
		for(int i=0;i<cadena.length();i++){
			char letra=cadena.charAt(i);
			int clave=posiciones.poll();
			posiciones.add(clave);
			char nLetra=obtenerPosicion(letra,clave);
			salida[i]=nLetra;
		}
		
	
		for (int i=0;i<salida.length;i++){
		System.out.print(salida[i]);
		}
		
	}
	
	public char obtenerPosicion(Character actual,Integer nActual){
		
	
		char  nLetra;
		nLetra=(char)((int)actual + nActual);
		
		return nLetra;
		
	}
	
	public static void main(String[] args){
		Prueba p = new Prueba();
	
		
		String s="pajaro";
		Queue<Integer> posicion = new LinkedList<Integer>();
		
		posicion.add(3);
		posicion.add(2);
		posicion.add(-19);
		posicion.add(19);
		
	
		
		p.cifrar(s, posicion);
	}
	

}
