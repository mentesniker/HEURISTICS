
/**
* Interface para representar soluciones que pueden ser usadas
* en el metodo de recocido simulado
* @author Benjamin Torres
* @version 0.1
*/
package recocidosimulado;
import java.util.ArrayList;
import java.util.Collections;
public class Solucion{
    private ArrayList<Punto> solucion = new ArrayList<Punto>();
    private int longitud = 0;

    /**
    * Metodo constructor sin parametros de una solucion a un problema
    * Construye una solucion aleatoria
    */
    public Solucion(){
        for (int i = 0; i < AdministradorSoluciones.numeroDePuntos(); i++){
          solucion.add(AdministradorSoluciones.getPunto(i));
        }
        this.longitud = 0;
        Collections.shuffle(this.solucion);
    }
    /**
    * Metodo constructor de una solucion a un problema
    * @param solucion,un arrayList de los puntos de la solucion a
    * partir de la cual queremos construir una nueva solucion
    */
    public Solucion(ArrayList<Punto> solucion){
        this.solucion = (ArrayList<Punto>)solucion.clone();
    }
    
    /**
    * Metodo get de la clase
    * @return solucion,el arraylist de la clase que tiene
    * los puntos de la solucion
    */
    public ArrayList getSolucion(){
        return this.solucion;
    }

    /**
    * Metodo para regresar el numero de puntos en la lista de puntos
    * @return el numero de puntos de la lista de puntos
    */
    public int numeroDePuntos(){
        return solucion.size();
    }

    /**
    * Metodo get de la clase
    * @param indice,el indice del punto que queremos
    * @return solucion,el arraylist de la clase que tiene
    * los puntos de la solucion
    */
    public Punto getPuntoi(int indice){
        return this.solucion.get(indice);
    }

    /**
    * Metodo set de la clase
    * @param indice,el indice en que queremos insertar el elemento
    * @param punto,el punto que queremos insertar
    */
    public void setPunto(int indice, Punto p){
        solucion.set(indice,p);
        longitud = 0;
    }
    
    /**
    * Asigna un valor a la solucion que invoca el metodo
    * @return evaluacion de la solucion
    */
    public int evaluar(){
        if (this.longitud == 0) {
            int longitudSolucion = 0;
            for (int i=0; i < this.solucion.size(); i++){
                Punto p1 = solucion.get(i);
                Punto p2;
                if(i + 1 < this.solucion.size()){
                    p2 = solucion.get(i+1);
                }
                else{
                    p2 = solucion.get(0);
                }
                longitudSolucion += p1.distancia(p2);
            }
            this.longitud = longitudSolucion;
        }
        return this.longitud;
    }
    
    /**
    * Metodo para imprimir a una solucion
    * @return Representacion de cadena para la solucion
    */
    @Override
    public String toString() {
        String aux = "La solucion es: [" + solucion.get(0).toString() + ",";
        for (int i = 1; i < solucion.size() - 2; i++) {
            aux += "" + solucion.get(i).toString() + ",";
        }
        aux += solucion.get(solucion.size() - 1).toString() + "]";
        return aux;
    }
}
