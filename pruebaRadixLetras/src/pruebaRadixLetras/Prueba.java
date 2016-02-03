package pruebaRadixLetras;

import java.util.LinkedList;
import java.util.Queue;

public class Prueba {
	
	public static void ordRaiz(String[] a,int maxLetras){
		Queue<String>[] colas=(LinkedList<String>[])new LinkedList[26];
		
		for(int i=0;i<colas.length;i++){
			colas[i]=new LinkedList<String>();
		}
		
		int pos = maxLetras-1;
		char letra;
		for(int j=0;j<maxLetras;j++){
			for(int k=0;k<a.length;k++){
				letra=a[k].charAt(pos);
				int beta=poschar(letra);
				colas[beta].add(a[k]);
			}
			int z=0;
			for(int h=0;h<colas.length;h++){
				while(!colas[h].isEmpty()){
					a[z]=colas[h].poll();
					z++;
				}
			}
			pos--;
		}
		
		for(int o=0;o<a.length;o++){
			System.out.print(" "+a[o]);
		}
	}

	private static int poschar(char letra) {
		// TODO Auto-generated method stub
		int posicion=0;
		if (letra =='a'){
			posicion=0;		
		}else if (letra=='e'){
			posicion= 4;
		}else if (letra =='y'){
			posicion= 24;
		}
		return posicion;
	}
	
	
	public static void main(String[] args){
		String[]a;
		a=new String[4];
		a[0]="aye";
		a[1]="yea";
		a[2]="aya";
		a[3]="yay";
		
		ordRaiz(a,3);
		
	}

}
