/**
* Interface con los metodos necesarios para implementar el metodo
* de recocido simulado junto con la solucion a un problema particular.
* @author Benjamin Torres
* @version 0.1
*/
package recocidosimulado;
import java.lang.Math;
import java.util.Random;

public class RecocidoSimulado{
  private float temperatura;
  private float deltaE;
  private double decaimiento;


  /**
  * Inicializa los valores necesarios para realizar 
  * recocido simulado durante un numero determinado de iteraciones
  */
  public RecocidoSimulado(){
      temperatura = 10000;
      deltaE = 0;
      decaimiento = 0.003;
  }

  /**
  * Funcion que calcula una nueva temperatura en base a
  * la anterior y el decaemiento usado.
  * @return nueva temperatura
  */
  public float nuevaTemperatura(){
    return this.temperatura *= 1-decaimiento;
  }

  /**
  * Genera y devuelve la solucion siguiente dependiendo de su valor
  * y de la probabilidad de elegir una solucion peor
  * @param Solucion que sera usada como base para elegir a la siguiente
  * @return Solucion nueva
  */
  public Solucion seleccionarSiguienteSolucion(Solucion s){
  	Random rnd = new Random();
  	int auxP1 = rnd.nextInt(s.numeroDePuntos());
    int auxP2 = rnd.nextInt(s.numeroDePuntos());
  	Punto p1 = s.getPuntoi(auxP1);
    Punto p2 = s.getPuntoi(auxP2);

    s.setPunto(auxP1,p2);
    s.setPunto(auxP2,p1);

    return s;  
  }

  //Metodo auxiliar de la clase
  //Sirve para calcular la probabilidad
  private double CalculaProbabilidad(){
    return Math.exp((this.deltaE) / this.temperatura);
  }

  /**
  * Ejecuta el algoritmo con los parametros con los que fue inicializado
  * devuelve una solucion.
  * @param solucion actual,la solucion a partir de la cual queremos
  * empezar el enfriamiento
  * @return Solucion al problema
  */
  public Solucion ejecutar(Solucion actual){
  float auxTemperatura = temperatura;
  Solucion mejor = new Solucion(actual.getSolucion());
  while(this.temperatura > 1){
      Solucion siguiente = new Solucion(actual.getSolucion());
      siguiente = seleccionarSiguienteSolucion(actual);
      deltaE = siguiente.evaluar() - actual.evaluar();
      if(this.deltaE < 0) 
        //siguiente = actual;
        actual = siguiente;
      else{
        if (CalculaProbabilidad() > Math.random())
            actual = new Solucion(siguiente.getSolucion());
      }
      if (actual.evaluar() < mejor.evaluar())
          mejor = new Solucion(actual.getSolucion());
      deltaE = 0;
      this.temperatura = nuevaTemperatura();
  }
  this.temperatura = auxTemperatura;
  return mejor;
  }
}
