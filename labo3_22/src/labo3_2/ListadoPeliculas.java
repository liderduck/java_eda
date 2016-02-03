package labo3_2;



public class ListadoPeliculas {

	private ListaPeliculas lista;
	private static ListadoPeliculas mListadoPeliculas = new ListadoPeliculas();

	private ListadoPeliculas() {
		this.lista = new ListaPeliculas();
	}

	public static ListadoPeliculas getListadoPeliculas() {
		return mListadoPeliculas;
	}

	public void agregarPelicula(Pelicula pPelicula) {
		if (!this.esta(pPelicula)) {
			lista.agregarPelicula(pPelicula);
		}
	}

	public boolean esta(Pelicula pPelicula) {
		return this.lista.esta(pPelicula);
	}

	public int size() {
		return this.lista.size();
	}
	
	public Pelicula buscarPelicula(String pPelicula) {
		Pelicula pelicula = lista.buscarPelicula(pPelicula);
		if (pelicula == null) {
			System.out.println("estoy aki");
			Pelicula noExiste = new Pelicula("Sin titulo");
			return noExiste;
		}
		return pelicula;
	}
}
