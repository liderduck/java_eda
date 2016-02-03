package labo3_2;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class ListaActores {

	private ArrayList<Actor> listaActores;

	public ListaActores() {
		listaActores = new ArrayList<Actor>();
	}

	public void agregarActor(Actor pActor) {
		this.listaActores.add(pActor);
	}

	public int size() {
		return listaActores.size();
	}

	public ArrayList<Actor> getListaActores() {
		return listaActores;
	}

	public boolean esta(Actor pActor) {
		boolean esta = false;
		Iterator<Actor> actor = getIterador();
		while (actor.hasNext() && !esta) {
			Actor nombre = actor.next();
			if (nombre.getNombre().equals(pActor.getNombre())) {
				esta = true;
			}
		}
		return esta;
	}

	public Iterator<Actor> getIterador() {
		return listaActores.iterator();
	}

	public Actor buscarActor(String pActor) {
		Actor nActor = null;
		boolean esta = false;
		Iterator<Actor> actor = getIterador();
		while (actor.hasNext() && !esta) {
			Actor nombre = actor.next();
			if (nombre.getNombre().equals(pActor)) {
				nActor = nombre;
				esta = true;
			}
		}
		return nActor;
	}

	public void ordenar() {
		quickSort(this.listaActores, 0, this.size()-1);
	}
	private void quickSort(ArrayList<Actor>pLista, int inicio, int fin){
		int i = inicio;
		int j = fin;
		String pivote = pLista.get((i+j)/2).getNombre();
		do {
			while(pLista.get(i).getNombre().compareToIgnoreCase(pivote)<0)
				{
					i++;
				}
			while(pLista.get(j).getNombre().compareToIgnoreCase(pivote)>0)
				{
					j--;
				}if(i<=j)
					{
						String aux = pLista.get(i).getNombre();
						pLista.get(i).setNombre(pLista.get(j).getNombre());
						pLista.get(j).setNombre(aux);
						i++;
						j--;
					}
			}while(i<=j);
		if(inicio<j){
			quickSort(pLista, inicio, j);
		}
		if(i<fin){
			quickSort(pLista, i, fin);
		}
		
	}	
	public Actor getActor(int posicion) {
		return listaActores.get(posicion);
	}

	public void borrarActor(Actor actor) {
		int posicion = -1;
		boolean esta = false;
		Iterator<Actor> actorIt = getIterador();
		while (actorIt.hasNext() && !esta) {
			Actor nombre = actorIt.next();
			if (nombre.getNombre().equals(actor.getNombre())) {
				esta = true;
			}
			posicion++;
		}
		if (esta) {
			listaActores.remove(posicion);
		}
	}
	
	public void verActores(){
		
		for (int i = 0; i < listaActores.size(); i++) {
			System.out.print(" ### "+listaActores.get(i).getNombre());
		}
	}

	public void mostrar() {
		Iterator<Actor> itr=this.getIterador();
		Actor actorAux=null;
		
		while(itr.hasNext())
		{
			actorAux=itr.next();
			actorAux.imprimirNombreActor();
		}
		
	}
	
	public String actorRandom() {
		ListaActores actorcillos = ListadoActores.getListadoActores().getListaActores();
		Random r = new Random();
		Integer ran = r.nextInt(ListadoActores.getListadoActores().size());
		String a = actorcillos.getActor(ran).getNombre();
		return a;
	}
	
	

}
