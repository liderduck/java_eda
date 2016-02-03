package arbol_prueba1;

public class BinSearchTree<T> extends BinTree<T> {
	  
    public BinSearchTree()
    {
        super();
    }
     
    public BinSearchTree(T elem)
    {
        super(elem);
    }
     
     
     
    public void addElement(T elem)
    {
        TreeNode<T> nuevoNodo= new TreeNode<T>(elem);
        @SuppressWarnings("unchecked")
		Comparable<T> comparableElement= (Comparable<T>) elem;
         
        //Casos:   1- Arbol vacio
         
        //1- si el arbol esta vacio
        if(this.isEmpty())
        {
            this.root= nuevoNodo;
        }
        else
        {
            TreeNode<T> current= this.root;
            boolean added=false;
             
            while(!added)
            {       //si el elemento a introducir es menor que el nodo Current
                if(comparableElement.compareTo(current.data)<0)
                {   //si no hay hijo izquierdo se introduce en esa posicion
                    if(current.left==null)
                    {
                        current.left=nuevoNodo;
                        added=true;
                    }   //si hay hijo entonces se avanza en profundidad
                    else
                    {
                        current=current.left;
                    }
                }
                else
                {
                    if(current.right==null)
                    {
                        current.right=nuevoNodo;
                        added=true;
                    }
                    else
                    {
                        current=current.right;
                    }
                }   
     
            }//while
        }//if
         
        count++;
    }
     
     
    public boolean isEmpty()
    {
        return root==null;
    }
     
    public T find(T elem)
    {
        return this.find(this.root, elem);
    }
     
    @SuppressWarnings("unchecked")
	private T find(TreeNode<T> raiz, T elem)
    {
        Comparable<T> comp;
             
        //si el nodo raiz esta vacio devolvera false
        if(raiz==null)
        {
            return null;
        }
        else
        {
            comp= (Comparable<T>) raiz.data;
             
            //Si el nodo raiz es igual a ELEM devuelve el contenido porque serie TRUE
            if(comp.compareTo(elem)==0)
            {
                return raiz.data;
            }
            else if(comp.compareTo(elem)>0)
            {
                return this.find(raiz.left, elem);
            }
            else
            {
                return this.find(raiz.right,elem);
            }
        }
    }
     
     
    public T findMin()
    {
        //SE PRESUPONE QUE EL ARBOL NO ESTA VACIO
         
        return this.findMin(this.root);
    }
     
    private T findMin(TreeNode<T> raiz)
    {
 
        if(raiz.left==null)
        {
            return raiz.data;
        }
        else
        {
            return this.findMin(raiz.left);
        }
    }
     
     
    public T findMax()
    {
        //SE PRESUPONE QUE EL ARBOL NO ESTA VACIO
         
        return this.findMax(this.root);
    }
     
    private T findMax(TreeNode<T> raiz)
    {
        if(raiz.right==null)
        {
            return raiz.data;
        }
        else
        {
            return this.findMax(raiz.right);
        }
    }
     
     
    public T removeMin()
    {
        //SE PRESUPONE QUE EL ARBOL NO ESTA VACIO
         
        //3 posibles casos:     1- El arbol solo tiene raiz por lo que es el minimo
        //                      2- El arbol no tiene subarbol izquierdo pero si derecho. Por lo que el minimo es la propia raiz
        //                      3- El arbol tiene subarbol izquierdo, por lo que hay que recorrerlo entero hasta llegar al final con un nodo explorador
         
        TreeNode<T> current= this.root;
         
        //Si el nodo actual no tiene 
        if(current.left==null)
        {
            if(current.right==null) //solo tiene raiz. por lo cual la raiz misma es el minimo
            {
                T temp= current.data;
                this.root=null;
                this.count=0;
                return temp;
            }
            else //si llega aqui quiere decir que no tiene subarbol derecho, pero si izquierdo. por lo que la raiz es el minimo tambien
            {
                T temp= current.data;
                this.root= this.root.right;
                this.count--;
                return temp;
            }
        }
        else //si llegas aqui quiere decir que existe subarbol izquierdo y hay que recorrerlo con un explorador
        {
            TreeNode<T> explorador= current.left;
             
            //cada vez que hace un loop el explorador va un paso por delante del nodo current.
            while(explorador.left!=null)
            {
                current=current.left;
                explorador=current.left;
            }
            T temp= explorador.data;
            current.left=explorador.right;
            this.count--;
            return temp;
        }
         
    }
 
    public T RemoveMinRec()
    {
        Resultado<T> res= this.removeMinRec(this.root);
        this.root= res.elNodo;
        return res.elValor;
    }
     
     
    private Resultado<T> removeMinRec(TreeNode<T> raiz)
    {
        //si no hay subarbol izquierdo el minimo es la raiz
        if(raiz.left==null)
        {
            return new Resultado<T>(raiz.right, raiz.data);
        }
        else //si hay subarbol hay que tirar a la izquierda
        {
            Resultado<T> result= this.removeMinRec(raiz.left);
            raiz.left=result.elNodo;
            result.elNodo= raiz;
            return result;
        }
    }
     
    public T removeElement(T elem)
    {
        Resultado<T> res= this.removeElement(root,elem);
        this.root= res.elNodo;
        return res.elValor;
    }
     
    public Resultado<T> removeElement(TreeNode<T> raiz,T elem)
    {
        @SuppressWarnings("unchecked")
		Comparable<T> comp= (Comparable<T>) elem;
         
        if(raiz!=null)
        {
            T valorDeNodo= raiz.data;
            if(comp.compareTo(valorDeNodo)==0)  //elem esta en la raiz del subarbol de raiz nodo
            {
                if(raiz.left==null && raiz.right==null) //Si el nodo no tiene hijos (es hoja)
                {   
                    this.count=0;
                    return new Resultado<T>(null,valorDeNodo);
                }
                else if( raiz.left==null && raiz.right!=null)   //subarbol izquierdo vacio y derecho no
                {
                    this.count--;
                    return new Resultado<T>(raiz.right,  valorDeNodo);
                }
                else if(raiz.left!=null && raiz.right==null)    //subarbol derecho vacio e izquierdo no
                {
                    this.count--;
                    return new Resultado<T>(raiz.left,valorDeNodo);
                }
                else    //subarbol izquierdo no vacio y derecho tampoco
                {
                    Resultado<T> result= this.removeMinRec(raiz.right);
                    raiz.right=result.elNodo;
                    T nuevaRaiz= (T)result.elValor;
                    raiz.data= nuevaRaiz;
                    this.count--;
                    return new Resultado<T>(raiz,nuevaRaiz);          
                }
            }
            else //elem no esta en la raiz
            {       
                if(comp.compareTo(valorDeNodo)<0) //raiz del subarbol>elem
                {
                    Resultado<T> result= this.removeElement(raiz.left, elem);
                    root.left=result.elNodo;    //modificamos el arbol original
                    result.elNodo=raiz;
                    return result;
                }
                else
                {
                    Resultado<T> result= this.removeElement(this.root.right, elem);
                    this.root.right=result.elNodo;  //aqui modificamos el arbol original
                    result.elNodo= raiz;
                    return result;
                }
            }//if del comp.compareTo
        }//if de raiz
        else
        {
            return new Resultado<T>(null,null);
        }
     
    }
 
}