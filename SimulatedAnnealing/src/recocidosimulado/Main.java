/**
* Clase para ejecutar un proceso de optimizacion usando recocido simulado
* @author Benjamin Torres Saavedra
* @version 0.1
*/
package recocidosimulado;
import static java.lang.System.out;
import java.util.Collections;    
public class Main{
   public static void main(String []args){
        int iteraciones=100;
        Lector lector = new Lector("./Djibouti.txt");
        //Lector lector = new Lector("./qatar.txt");
        String[] coordenadas = lector.dameLineas();
        for(int i = 0;i < coordenadas.length;i++){
        	String[] aux = coordenadas[i].split("\\s+");
        	AdministradorSoluciones.agregaPunto(new Punto(Double.parseDouble(aux[1]),Double.parseDouble(aux[2]),i));
        }
        RecocidoSimulado recocido = new RecocidoSimulado();
        Solucion s = new Solucion();
        out.println("La distancia de la solucion inicial es: " + s.evaluar() + "\n");
        for(iteraciones = 1000; iteraciones > 0; iteraciones--){
        	s = recocido.ejecutar(s);     
        }
        out.println("La distancia de la solucion es: " + s.evaluar() + "\n" + s.toString());
   }
}
