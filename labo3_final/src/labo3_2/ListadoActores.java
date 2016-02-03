package labo3_2;



public class ListadoActores {

	private ListaActores lista;
	private static ListadoActores mListadoActores = new ListadoActores();

	private ListadoActores() {
		this.lista = new ListaActores();
	}

	public static ListadoActores getListadoActores() {
		return mListadoActores;
	}

	public ListaActores getListaActores() {
		return lista;
	}

	public void agregarActor(Actor pActor) {
		if (!esta(pActor)) {
			lista.agregarActor(pActor);
		}
	}

	public boolean esta(Actor pActor) {
		return lista.esta(pActor);
	}

	public int size() {
		return lista.size();
	}

	public Actor buscarActor(String pActor) {
		Actor actor = lista.buscarActor(pActor);
		if (actor == null) {
			Actor noExiste = new Actor("Sin Nombre");
			return noExiste;
		}
		return actor;
	}

	public void ordenar() {
		lista.ordenar();
	}

	public void borrarActor(Actor actor) {
		lista.borrarActor(actor);
	}

	public void mostrar() {
		lista.mostrar();
		
	}

	public void verActores() {
		lista.verActores();
		
	}
	
}
