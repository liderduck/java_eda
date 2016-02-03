package pruebas;

import java.util.LinkedList;
import java.util.Queue;

public class Prueba {
	
	public static void sort(int[]a,int maxCifras){
		LinkedList<Integer>[] colas= (LinkedList<Integer>[])new LinkedList[10];
		
	
		
		for(int i=0;i<colas.length;i++){
		  colas[i]=new LinkedList<Integer>();	
		}
		int pot10=1;
		int digitos;
		
		for(int j=0;j<maxCifras;j++){
			for(int h=0;h<a.length;h++){
				digitos=(a[h]/pot10)%10;
				colas[digitos].add(a[h]);
			}
			int z=0;
			for(int k=0;k<colas.length;k++){
				while(!colas[k].isEmpty()){
				a[z]=colas[k].removeFirst();
				z++;
				}
			}
		pot10=pot10*10;
		}
		for(int o=0;o<a.length;o++){
			System.out.print(" "+a[o]);
		}
	}
	
	public static void main(String[] args){
		int[]a;
		a=new int[3];
		a[0]=170;
		a[1]=45;
		a[2]=790;
		
		sort(a,3);
		
	}
}
