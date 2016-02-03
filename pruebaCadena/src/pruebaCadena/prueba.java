package pruebaCadena;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;

public class prueba {
	
	public static void delimitador(String cadena){
		boolean estado = true;
		Stack<Character> pila = new Stack<Character>();
		
		for(int i=0;i<cadena.length();i++){
			char letra = cadena.charAt(i);
			if  (letra=='{' || letra=='['|| letra=='('){
				pila.push(letra);
			}else if (letra=='}' || letra==']'|| letra==')'){
				if(pila.isEmpty()){
					System.out.println("pila vacia cuando deberia no estarlo");
					estado=false;
				}else{
					char letrab= pila.pop();
					if(letrab =='[' && letra!=']'){
						estado=false;
					}else if(letrab=='(' && letra!=')'){
						estado=false;
					}if(letrab=='{' && letra!='}'){
						estado=false;
					}
				}
			}
		}
		if(!pila.isEmpty()){
			estado=false;
		}
		
		if (estado==false){
			System.out.println("cadena incorrecta");
		}else{
			System.out.println("cadena correcta");
		}
	/*	
		String[] hola= new String[10];
						
		hola[0]= "hola";
		
		ArrayList<String> adios = new ArrayList<String>();
		
		adios.add("adios");
		
		*/
		
		
	}
	
	public static void main(String[] args){
		String a = "ABCDEF}";
		delimitador(a);
		
		String a1 = "A(B{C[D]E}F)";
		delimitador(a1);
		
		String a2 = "A{}BCDEF}";
		delimitador(a2);
	}

}
