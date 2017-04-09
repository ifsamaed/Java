import java.io.IOException;

/**
 * Created by margaret on 9/3/17.
 */

public interface Pila {
    boolean pilaVacia ();
    void eliminarPila ();
    int cima () throws PilaVacia;
    void apilar (int x);
    int desapilar () throws PilaVacia;
    void decapitar () throws PilaVacia;
    void imprimirPila ();
    void leerPila () throws NumberFormatException, IOException;
    int numElemPila ();

}
