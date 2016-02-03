package arbol_prueba1;

public class Resultado<T> {
	 
    protected T elValor;
    protected TreeNode<T> elNodo;
     
     
    public Resultado(TreeNode<T> pElNodo, T pElValor)
    {
        this.elNodo=pElNodo;
        this.elValor=pElValor;
    }
     
}
