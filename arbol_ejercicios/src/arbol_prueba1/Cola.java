package arbol_prueba1;

public class Cola<T> {
    
    
    private Node<T> front;
    private Node<T> rear;
    private int count;
     
     
    public Cola()
    {
        this.front=null;
        this.rear=null;
        this.count=0;
    }
     
    public boolean isEmpty()
    {
        return this.size()==0;
    }
     
    public int size()
    {
        return this.count;
    }
     
    public T first()
    {
        if(this.isEmpty())
        {
            return null;
        }
        else
        {
            return this.front.data;
        }
    }
     
    public T remove()
    {
        if(this.isEmpty())
        {
            return null;
        }
        else
        {
            T elem=this.front.data;
            if(this.size()==1)
            {
                this.front=null;
                this.rear=null;
            }
            else
            {           
                this.front=this.front.next;
            }
 
            this.count--;
            return elem;
        }
    }
     
    public void insert(T elem)
    {
        Node<T> nuevoNodo= new Node<T>(elem);
         
        if(this.isEmpty())
        {
            this.front=nuevoNodo;
        }
        else
        {
            this.rear.next=nuevoNodo;
        }
            this.rear=nuevoNodo;
            this.count++;
    }
     
     
    public void visualizarCola()
    {
        System.out.println(this.toString());
    }
     
    public String toString()
    {
        if(this.isEmpty())
        {
            return "Cola vacia. No se pueden visualizar los elementos";
        }
        else
        {
            Node<T> current=this.front;
            String resul= new String();
             
            while(current!=null)
            {
                resul= resul+"["+current.data.toString()+"]";
                current=current.next;
            }
            return "Cola ligada: "+ resul+"\n";
             
        }
    }
     
     
     
    public void resetear()  
    {
        this.front=null;
        this.rear=null;
        this.count=0;
    }
 
}
