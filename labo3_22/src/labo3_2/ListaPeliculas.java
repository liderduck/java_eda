package labo3_2;



import java.util.ArrayList;
import java.util.Iterator;

public class ListaPeliculas {

	private ArrayList<Pelicula> listaPeliculas;

	public ListaPeliculas() {
		listaPeliculas = new ArrayList<Pelicula>();
	}

	public void agregarPelicula(Pelicula pPelicula) {
		listaPeliculas.add(pPelicula);
	}

	public ArrayList<Pelicula> getListaPeliculas() {
		return listaPeliculas;
	}

	public int size() {
		return listaPeliculas.size();
	}

	public boolean esta(Pelicula pPelicula) {
		boolean esta = false;
		Iterator<Pelicula> peliculas = getIterador();
		while (peliculas.hasNext() && !esta) {
			Pelicula titulo = peliculas.next();
			if (titulo.getTitulo().equals(pPelicula.getTitulo())) {
				esta = true;
			}
		}
		return esta;
	}

	public Iterator<Pelicula> getIterador() {
		return listaPeliculas.iterator();
	}
	
	public void verPeliculas(){
		for (int i = 0; i < listaPeliculas.size(); i++) {
			System.out.print(" ### "+listaPeliculas.get(i).verTitulo());
		}
	}
	
	public Pelicula buscarPelicula(String pPelicula) {
		Pelicula nPelicula = null;
		boolean esta = false;
		Iterator<Pelicula> pelicula = getIterador();
		while (pelicula.hasNext() && !esta) {
			Pelicula titulo = pelicula.next();
			if (titulo.getTitulo().equals(pPelicula)) {
				nPelicula = titulo;
				esta = true;
			}
		}
		return nPelicula;
	}

	public Pelicula getPelicula(int posicion) {
		return listaPeliculas.get(posicion);
	}
	
	
}
