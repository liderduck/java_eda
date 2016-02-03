package org.eda.examenJulio2013Ejercicio3;



public class SimpleLinkedList<T> {

	protected NodeSimple<T> first;
	
	
	public SimpleLinkedList()
	{
		this.first=null;
	}
	
	
	public boolean isEmpty()
	{
		return this.first==null;
	}
	
	public int size()
	{
		if(this.isEmpty())
		{
			return 0;
		}
		else
		{
			int count=1;
			NodeSimple<T> current=this.first;
			
			while(current.next!=null)
			{
				current=current.next;
				count++;
			}
			
			return count;
			
		}
	}
	
	
	public void add(T elem)
	{
		NodeSimple<T> nuevoNodo=new NodeSimple<T>(elem);
		
		if(this.isEmpty())
		{
			this.first=nuevoNodo;
		}
		else
		{
			NodeSimple<T> current= this.first;
			
			while(current.next!=null)
			{
				current=current.next;
			}
			
			current.next=nuevoNodo;
		}
	}
	
	public void resetear()
	{
		this.first=null;
	}
	
	public boolean contains(T elem) {
		//Determina si la lista contiene un elemento concreto
			      if (isEmpty())
			          return false;

			      NodeSimple<T> current=this.first;
			     // Empieza con el segundo elemento
			     
			      boolean encontrado=false;
			      
			      while(!encontrado && current!=null)
			      {
			    	  if(current.data.equals(elem))
			    	  {
			    		  encontrado=true;
			    	  }
			    	  else{
			    	  current=current.next;}
			      }
			      
			      return encontrado;
			     
			   }

	
	
	
	public void visualizarNodos() {
			System.out.println(this.toString());
		}


		@Override
		public String toString()
		{
			
		
			
			if(this.isEmpty())
			{
				return "No contiene nodos para visualizar";
			}
			else
			{
				NodeSimple<T> current= this.first;
				
				String result = new String();
			
				while (current.next!=null) 
				{
					T elem = current.data;
					current=current.next;
					result = result + "[" + elem.toString() + "] ";
				}	
				T elem= current.data;
				result = result + "[" + elem.toString() + "] \n";
				return "SimpleLinkedList \n" + result ;
			}
			
			
		}
	
	
	
	
	
	
	
	
	
	
}
