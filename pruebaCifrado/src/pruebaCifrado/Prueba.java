package pruebaCifrado;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Prueba {
	
	HashMap<Character,Integer> g= new HashMap<Character,Integer>();
	Character[] a = new Character[27];
	
	public void cargarHash(){
		g.put('a',0);
		g.put('b',1);
		g.put('c',2);
		g.put('d',3);
		g.put('e',4);
		g.put('f',5);
		g.put('g',6);
		g.put('h',7);
		g.put('i',8);
		g.put('j',9);
		g.put('k',10);
		g.put('l',11);
		g.put('m',12);
		g.put('n',13);
		g.put('ñ',14);
		g.put('o',15);
		g.put('p',16);
		g.put('q',17);
		g.put('r',18);
		g.put('s',19);
		g.put('t',20);
		g.put('u',21);
		g.put('v',22);
		g.put('w',23);
		g.put('x',24);
		g.put('y',25);
		g.put('z',26);
	}
	
	public void cargarArray(){
		a[0]='a';
		a[1]='b';
		a[2]='c';
		a[3]='d';
		a[4]='e';
		a[5]='f';
		a[6]='g';
		a[7]='h';
		a[8]='i';
		a[9]='j';
		a[10]='k';
		a[11]='l';
		a[12]='m';
		a[13]='n';
		a[14]='ñ';
		a[15]='o';
		a[16]='p';
		a[17]='q';
		a[18]='r';
		a[19]='s';
		a[20]='t';
		a[21]='u';
		a[22]='v';
		a[23]='w';
		a[24]='x';
		a[25]='y';
		a[26]='z';
	}
	
	public void cifrar(String cadena,Integer[] posiciones){
		Character[] salida = new Character[6];
		Queue<Character> cola = new LinkedList<Character>();
	
		
		
		for(int i=0;i<cadena.length();i++){
			cola.add(cadena.charAt(i));
		}
		int z=0;
		while(!cola.isEmpty()){
			char actual=cola.poll();
			int nActual= posiciones[z];
			char letra= obtenerPosicion(actual,nActual);
			salida[z]=letra;
			z++;
		}
		for (int i=0;i<salida.length;i++){
		System.out.print(salida[i]);
		}
		
	}
	
	public char obtenerPosicion(Character actual,Integer nActual){
		
		int n =g.get(actual);
		int f=n+nActual;
		
		
		if(f<0){
			f=27+n+nActual;
		}else if(f>26){
			f=nActual+n-27;
		}
		char nLetra=a[f];
		return nLetra;
		
	}
	
	public static void main(String[] args){
		Prueba p = new Prueba();
		
		p.cargarArray();
		p.cargarHash();
		
		String s="pajaro";
		Integer[] posicion = new Integer[6];
		
		posicion[0]=3;
		posicion[1]=2;
		posicion[2]=5;
		posicion[3]=-4;
		posicion[4]=-19;
		posicion[5]=19;
		
		p.cifrar(s, posicion);
	}
	

}
