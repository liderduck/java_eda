package labo3_2;



import java.io.File;
import java.util.Scanner;

public class Leer {

	public Leer(ListadoPeliculas lisPeliculas, ListadoActores lisActores) {
		
		File archivo = new File("C:\\Users\\anahe\\Desktop\\jona.txt");
		
		try {
			@SuppressWarnings("resource")
			Scanner entrada = new Scanner(archivo);
			String linea;
			
			while (entrada.hasNext()) {
				linea = entrada.nextLine();
				String[] prueba = linea.split("\\s###\\s");
				String nombre = prueba[0];
				Actor actor = new Actor(nombre);
				
				for (int i = 0; i < prueba.length; i++) {
					if (i == 0) {
						lisActores.agregarActor(actor);
					} else {
						String titulo = prueba[i];
						Pelicula pelicula = new Pelicula(titulo);
						if (!lisPeliculas.esta(pelicula)) {
							lisPeliculas.agregarPelicula(pelicula);
						} 
						actor.agregarPelicula(pelicula);
						Pelicula pel = lisPeliculas.buscarPelicula(pelicula.getTitulo());
						pel.agregarActor(actor);
						
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	}
