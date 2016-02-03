package arbol_prueba1;

public class TreeNode<T> {
	 
    protected T data;
    protected TreeNode<T> left;
    protected TreeNode<T> right;
     
     
    public TreeNode(T dd)
    {
        this.data=dd;
        this.left=null;
        this.right=null;
    }
     
}
