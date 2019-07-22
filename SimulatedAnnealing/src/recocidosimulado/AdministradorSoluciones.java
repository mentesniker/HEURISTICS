/**
* Clase para administrar una lista de puntos
* que son los destinos 
* @author Luis Eduardo Martinez Hernandez
* @version 0.1
*/
package recocidosimulado;
import java.util.ArrayList;

public class AdministradorSoluciones {

    private static ArrayList<Punto> PuntosDestino = new ArrayList<Punto>();

    /**
    * Metodo para agregar un punto en la lista de puntos
    * @param p,el punto que quremos agregar
    */
    public static void agregaPunto(Punto p){
        PuntosDestino.add(p);
    }
    
    /**
    * Metodo get de la clase
    * @param indice,el indice del punto que queremos
    * @return punto,el punto el cual apunta el indice
    */
    public static Punto getPunto(int indice){
        return PuntosDestino.get(indice);
    }
    /**
    * Metodo para regresar el numero de puntos en la lista de puntos
    * @return el numero de puntos de la lista de puntos
    */
    public static int numeroDePuntos(){
        return PuntosDestino.size();
    }
}