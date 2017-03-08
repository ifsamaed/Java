public class Main {


    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    static void sumergir(Pila pila, int dato) throws PilaVacia {
        int elem;
        if (!pila.pilaVacia()){
            elem = pila.despilar ();
            sumergir(pila, dato);
            pila.apilar (elem);
        }
        else{
            pila.apilar(dato);
        }
    }

    static void hacerCapicua (Pila pila) throws PilaVacia{
        int elem;

        if (!pila.Vacia()){
            elem = pila.desapilar ();
            hacerCapicua(pila);
            sumergir(pila, elem);
            pila. apilar(elem);
        }
        
    }
}
