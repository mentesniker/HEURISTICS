/**
* Clase para representar un punto del plano cartesiano
* @author Luis Eduardo Martinez Hernandez
* @version 0.1
*/
package recocidosimulado;
import java.lang.Math;

public class Punto {
    private int identificador;
    private double x;
    private double y;
    /**
    * Inicializa los valores del punto 
    * @param x,coordenada x
    * @param y,coordenada y
    */
    public Punto(double x, double y,int identificador){
        this.identificador = identificador;
        this.x = x;
        this.y = y;
    }
    /**
    * Metodo get de la clase
    * @return x,la coordenada x del punto
    */
    public double getX(){
        return this.x;
    }
    /**
    * Metodo get de la clase
    * @return y,la coordenada y del punto
    */
    public double getY(){
        return this.y;
    }
    /**
    * Metodo que calcula la distancia entre dos puntos
    * @param Punto p,el punto que queremos obtener su distancia
    * @return la distancia entre dos puntos
    */
    public double distancia(Punto p){
        return Math.sqrt( (Math.pow(Math.abs(getX() - p.getX()),2)) + (Math.pow(Math.abs(getY() - p.getY()),2)) );
    }
    /**
    * Metodo para imprimir un punto
    * @return Representacion de cadena para un punto
    */
    @Override
    public String toString(){
        //return this.getX() + ", " + this.getY() + " ciudad: " + this.identificador;
        return "" + this.identificador;
    }
}