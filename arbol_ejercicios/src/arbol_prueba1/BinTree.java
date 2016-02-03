package arbol_prueba1;

import java.util.Iterator;

public class BinTree<T> {
 
    protected TreeNode<T> root;
    protected int count;
     
     
    public BinTree()
    {
        this.root=null;
        this.count=0;
    }
 
    public BinTree(T elem)
    {
        TreeNode<T> nuevoNodo= new TreeNode<T>(elem);
        this.root=nuevoNodo;
        this.count=1;
    }
     
     
     
    public void removeLeftSubTree()
    {
        this.count= this.count- this.numDescendants(root.left);
        this.root.left=null;
    }
     
    public void removeRightSubTree()
    {
        this.count= this.count- this.numDescendants(root.right);
        this.root.right=null;
    }
         
    private int numDescendants(TreeNode<T> subNodo)
    {
        if(subNodo==null)
        {
            return 0;
        }
        else
        {
            return 1+ this.numDescendants(subNodo.left)+this.numDescendants(subNodo.right);
        }
    }
     
     
    public boolean contains(T elem)
    {
        return this.contains(elem,root);
    }
     
    private boolean contains(T elem, TreeNode<T> temp)
    {
        //si esta vacio devuelve false
        if(temp==null)
        {
            return false;
        }
        //si el contenido del nodo es el del parametro ELEM devuelve true
        else if (temp.data.equals(elem))
        {
            return true;
        //sino busca en los dos hijos del nodo
        }else
        {
            return this.contains(elem, temp.left) || this.contains(elem, temp.right);
        }
 
    }
     
     
    public Iterator<T> iteradorPostOrden()
    {
        SimpleLinkedList<T> tempList= new SimpleLinkedList<T>();
         
        this.postOrden(this.root,tempList);
         
        return tempList.iterator();
    }
     
     
    private void postOrden(TreeNode<T> raiz, SimpleLinkedList<T> lista)
    {
        if(raiz!=null)
        {
            this.postOrden(raiz.left, lista);
            this.postOrden(raiz.right, lista);
            lista.add(raiz.data);
        }
    }
     
    public Iterator<T> iteradorPorNiveles()
    {
        SimpleLinkedList<T> tempList= new SimpleLinkedList<T>();
         
        this.porNiveles(this.root,tempList);
         
        return tempList.iterator();
         
    }
     
    private void porNiveles(TreeNode<T> raiz, SimpleLinkedList<T> lista)
    {
        if(raiz!=null)
        {
            Cola<TreeNode<T>> c1= new Cola<TreeNode<T>>();
             
            c1.insert(raiz);
             
            while(!c1.isEmpty())
            {
                TreeNode<T> temp= c1.remove();
                 
                lista.add(temp.data);
                 
                if(temp.left!=null)
                {
                    c1.insert(temp.left);
                }
                if(temp.right!=null)
                {
                    c1.insert(temp.right);
                }
            }
             
             
        }
    }
}
