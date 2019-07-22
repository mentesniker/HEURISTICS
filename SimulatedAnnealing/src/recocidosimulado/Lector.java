/**
* Clase para leer de un archivo
* @author Luis Eduardo Martinez Hernandez
* @version 0.1
*/
package recocidosimulado;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Lector{
	String nombreArchivo;

	/**
    * Inicializa el nombre del archivo 
    * @param nombreArchivo,String con la ruta y nombre del archivo
    */
	public Lector(String nombreArchivo){
		this.nombreArchivo =  nombreArchivo;
	}

	/**
    * Metodo para leer de un archivo
    * @return String[] un arreglo con las lineas
    * del archivo 
    * 
    */
	 public String[] dameLineas(){
	 	BufferedReader lector;
		String[] coordenadas = new String[38];
		int aux = 0;
		try {
			lector = new BufferedReader(new FileReader(nombreArchivo));
			String linea = lector.readLine();
			while (linea != null) {
				coordenadas[aux] = linea;
				aux++;
				linea = lector.readLine();
			}
			lector.close();
		} catch (IOException e){
			System.out.println("No se ha encontrado el archivo.");
			return coordenadas;
		}
		return coordenadas;
	}
}