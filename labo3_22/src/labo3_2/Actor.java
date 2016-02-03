package labo3_2;



public class Actor {

	private String nombre;
	private ListaPeliculas lPelicula;

	public Actor(String pNombre) {
		nombre = pNombre;
		lPelicula = new ListaPeliculas();
	}

	public String getNombre() {
		return nombre;
	}

	public void agregarPelicula(Pelicula pPelicula) {
		lPelicula.agregarPelicula(pPelicula);
	}

	public int size() {
		return lPelicula.size();
	}
	public ListaPeliculas getListaPeliculas(){
		return lPelicula;
	}
	public void setNombre(String pNombre){
		this.nombre=pNombre;
	}

	public void imprimirNombreActor() {
		System.out.println(this.getNombre());
	}
}
