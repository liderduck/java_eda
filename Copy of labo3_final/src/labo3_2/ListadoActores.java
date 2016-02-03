package labo3_2;

import java.io.File;
import java.util.HashSet;
import java.util.Scanner;

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
	
	public String actorRandom(){
		return lista.actorRandom();
	}
	
public void leer() {
		
		File archivo = new File("C:\\Users\\anahe\\Desktop\\actor.txt");
		
		try {
			@SuppressWarnings("resource")
			Scanner entrada = new Scanner(archivo);
			String linea;
			HashSet<Actor> actors = new HashSet<Actor>();
			
			while (entrada.hasNext()) {//recorre los actores
				linea = entrada.nextLine();
				String[] prueba = linea.split("\\s###\\s");
				
				Actor actor = new Actor(prueba[0]);
				
				if(!actors.contains(actor)){
						ListadoActores.getListadoActores().agregarActor(actor);
						actors.add(actor);
						for (int i = 1; i < prueba.length; i++) {//recorre las peliculas
								Pelicula pelicula = new Pelicula(prueba[i]);
								actor.agregarPelicula(pelicula);
						}
				}
			}

		} catch (Exception e) {
			System.out.println("############Error de cargado############");

		}
	
	}
	
}
