package labo3_2;



public class Pelicula {

	private String titulo;
	private ListaActores lActores;

	public Pelicula(String pTitulo) {
		titulo = pTitulo;
		lActores = new ListaActores();
	}

	public String getTitulo() {
		return titulo;
	}
	
	public String verTitulo(){
		return titulo;
	}

	public ListaActores getListaActores() {
		return lActores;
	}
	
	public void agregarActor(Actor pActor) {
		lActores.agregarActor(pActor);
	}

}
