package arbol_prueba1;

public class prueba {
	
	

	TreeNode<String> root;
	public void print(BinSearchTree<String> arb_1){
		TreeNode<String> roota=arb_1.root;
		print2(roota);
	}
	
	
	public void print2(TreeNode<String> root){
		if (root==null){
			System.out.println("fin");
		}else{
			System.out.println(root.data);
			print2(root.right);
			print2(root.left);
		}
	}
	
	//####		EJERCICIO 1	     ######
	// MISMA ESTRUCTURA
	public boolean mismExt(BinSearchTree<Integer> arb_1,BinSearchTree<Integer> arb_2){
		
		TreeNode<Integer> root1= arb_1.root;
		TreeNode<Integer> root2= arb_2.root;
		
		Boolean solucion;
		solucion= mismExt2(root1,root2);
		return solucion;
	}
	
	private boolean mismExt2(TreeNode<Integer> root1,TreeNode<Integer> root2){
		boolean valor=true;
		if (root1==null && root2!=null){
			valor=false;
		}else if(root1!=null && root2==null){
			valor=false;
		}else if(root1==null && root2==null){
			valor=true;
		}else{
			boolean valorI=mismExt2(root1.right,root2.right);
			boolean valorD=mismExt2(root1.left,root2.left);
			
			if(valorD==false || valorI==false){
				valor=false;
			}
		}
		return valor;
	}
	
	
	//####		EJERCICIO 2	     ######
	//MAXIMO NUMERO POR NIVEL
	
	public int maxValor(BinSearchTree<Integer> arb_1,int n){
		int cont=1;
		TreeNode<Integer> raiz= arb_1.root;
		int valor=maxValor2(raiz,n,cont);
		
		return valor;
	}
	
	private int maxValor2(TreeNode<Integer> root,int n,int cont){
		int valorMax=0;
		if(root.left==null && root.right==null || cont>=n){
			return root.data;
		}else{
			cont++;
			int valorI=maxValor2(root.left,n,cont);
			int valorD=maxValor2(root.right,n,cont);
			if (valorI>valorD){
				valorMax=valorI;
			}else{
				valorMax=valorD;
			}
			
			if (valorMax<root.data){
				valorMax=root.data;
			}
		}
		
		return valorMax;
	}
	
	//####		EJERCICIO 3	     ######
		//Nº de nodos por nivel
	
	public int num_nodos(BinSearchTree<Integer> arb_1,int n){
		int fin=0;
		TreeNode<Integer> root= arb_1.root;
		int cont=1;
		
		
		fin= num_nodos2(root,cont,n);		
		return fin;
	}
	
	private int num_nodos2(TreeNode<Integer> root,int cont,int n){
		int nNodos=0;
		if(root==null){
			return 0;
		}else if (root!=null && cont==n){
			return 1;
		}else{
			cont++;
			int valorD=num_nodos2(root.right,cont,n);
			int valorI=num_nodos2(root.left,cont,n);
			nNodos=valorD+valorI;
			return nNodos;
		}
		
	}
	//####		EJERCICIO 4	     ######
			//Arbol espejo
	
	public BinSearchTree<Integer> espejo(BinSearchTree<Integer> arb_1){
		BinSearchTree<Integer> fin= new BinSearchTree<Integer>();
		BinSearchTree<Integer> espejo = new BinSearchTree<Integer>();
		espejo=arb_1;
		TreeNode<Integer> rootb=arb_1.root;
		fin=espejo2(espejo,rootb);
		return fin;
	}
	
	private BinSearchTree<Integer> espejo2(BinSearchTree<Integer> espejo,TreeNode<Integer> rootb){
		if (rootb.right==null && rootb.left==null){
			return espejo;
		}else{
			TreeNode<Integer> aux= new TreeNode<Integer>(rootb.left.data);
			rootb.left=rootb.right;
			rootb.right=aux;
			espejo=espejo2(espejo,rootb.left);
			espejo=espejo2(espejo,rootb.right);
			return espejo;
		}
	}
	//####		EJERCICIO 5	     ######
	//de arbol a lista
	
	public SimpleLinkedList<Integer> listaOrdenada(BinSearchTree<Integer> arb_1){
		TreeNode<Integer> root=arb_1.root;
		SimpleLinkedList<Integer> fin= new SimpleLinkedList<Integer>();
		fin=listaOrdenada2(root,fin);
		return fin;
	}
	
	private SimpleLinkedList<Integer> listaOrdenada2(TreeNode<Integer> root,SimpleLinkedList<Integer> fin){
		if (root==null){
			return fin;
		}else{
			Node<Integer> nuevo= new Node<Integer>(root.data);
			if(fin.isEmpty()){
				fin.last=nuevo;
				fin.first=nuevo;
			}else{
				if(nuevo.data>fin.last.data){
				fin.last.next=nuevo;
				fin.last=nuevo;
				}else if(nuevo.data<fin.first.data){
					nuevo.next=fin.first;
					fin.first=nuevo;
				}else{
					Node<Integer> actual=fin.first;
					Node<Integer> ant=null;
					while(nuevo.data>actual.data){
						ant=actual;
						actual=actual.next;
					}
					ant.next=nuevo;
					nuevo.next=actual;
				}
			}
		fin=listaOrdenada2(root.right,fin);
		fin=listaOrdenada2(root.left,fin);
		return fin;
		}
	}
	
	//####		EJERCICIO exam JUNIO 2012     ######
	//numero medio de elementos
	
	public double numMedioDeElementos(BinSearchTree<String> arb_1,SimpleLinkedList<String> l){
		Double fin=0.0;
		Node<String> actual=l.first;
		
		while(actual!=null){
			fin=fin+nMDE(arb_1.root,actual.data);
			System.out.println(fin);
			actual=actual.next;
		}
		fin=fin/l.size();
		return fin;
	}
	
	private double nMDE(TreeNode<String> root, String data){
		if (root==null){
			return 0;
		}else{
			if(root.data==data){
				return 1;
			}else{
				double valorI= nMDE(root.left,data);
				double valorD=nMDE(root.right,data);
			
				if(valorI>valorD){
					return valorI+1;
				}else if(valorI<valorD){
					return valorD+1;
				}else{
					return 0;
				}
			}
		
		}
	}
	
	public static void main(String[] args){
/*	 
practica 1	
		BinSearchTree<Integer> b1= new BinSearchTree<Integer>();
		BinSearchTree<Integer> b2= new BinSearchTree<Integer>();
		prueba p=new prueba();
		
		boolean fin;
	
		b1.addElement(20);
		b1.addElement(15);
		b1.addElement(10);
		b1.addElement(25);
		b1.addElement(24);
		b1.addElement(27);
		
		b2.addElement(20);
		b2.addElement(15);
		b2.addElement(10);
		b2.addElement(25);
		b2.addElement(24);
		b2.addElement(27);
		
		fin=p.mismExt(b1,b2);
		System.out.println(fin);
  
practica2
		BinSearchTree<Integer> b1= new BinSearchTree<Integer>();
		prueba p=new prueba();
		
		int valor=0;
		b1.addElement(8);
		b1.addElement(5);
		b1.addElement(10);
		b1.addElement(4);
		b1.addElement(6);
		b1.addElement(9);
		b1.addElement(11);
		
		
		valor=p.maxValor(b1,2);
		System.out.println(valor);
practica 3	
		BinSearchTree<Integer> b1= new BinSearchTree<Integer>();
		prueba p=new prueba();
		int nivel=0;
		
		int valor=0;
		b1.addElement(20);
		b1.addElement(10);
		b1.addElement(30);
		b1.addElement(3);
		b1.addElement(16);
		b1.addElement(1);
		b1.addElement(14);
		b1.addElement(17);
		b1.addElement(21);
		b1.addElement(40);
		b1.addElement(35);
		b1.addElement(32);
		b1.addElement(36);
	
		valor=p.num_nodos(b1,nivel);
		System.out.println(valor);
		p.print(b1);
practica 4
		BinSearchTree<Integer> b1= new BinSearchTree<Integer>();
		prueba p=new prueba();
		

		b1.addElement(8);
		b1.addElement(5);
		b1.addElement(10);
		b1.addElement(9);
		b1.addElement(11);
		
		b1=p.espejo(b1);
		p.print(b1);
		
	
practica 5		
		BinSearchTree<Integer> b1= new BinSearchTree<Integer>();
		prueba p=new prueba();
		SimpleLinkedList<Integer> fin= new SimpleLinkedList<Integer>();

		b1.addElement(12);
		b1.addElement(5);
		b1.addElement(30);
		b1.addElement(3);
		b1.addElement(8);
		b1.addElement(20);
		b1.addElement(40);
		b1.addElement(1);
		b1.addElement(6);
		b1.addElement(9);
		b1.addElement(35);
		b1.addElement(33);
		b1.addElement(37);
		
		fin=p.listaOrdenada(b1);	
		
		Node<Integer> actual= fin.first;
		while(actual!=null){
			System.out.print(actual.data+" -> ");
			actual=actual.next;
		}
practica 6
*/		
		BinSearchTree<String> b1= new BinSearchTree<String>();
		SimpleLinkedList<String> fin= new SimpleLinkedList<String>();
		prueba p=new prueba();
		
		
		b1.addElement("n");
		b1.addElement("e");
		b1.addElement("q");
		b1.addElement("d");
		b1.addElement("j");
		b1.addElement("c");
		b1.addElement("f");
		b1.addElement("k");
		b1.addElement("o");
		b1.addElement("v");
		b1.addElement("t");
		b1.addElement("s");
		b1.addElement("u");
		
		fin.add("t");
		fin.add("n");
		fin.add("e");
		fin.add("s");
		
		double a = p.numMedioDeElementos(b1,fin);
		System.out.println(a);
	}

}
