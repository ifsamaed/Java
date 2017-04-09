import java.util.EmptyStackException;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        try {

        Stack st = new Stack();

            System.out.println("stack: " + st);
            Main.hacerCapicua(st);

        } catch ( EmptyStackException pilaVacia) {
            System.out.println("empty stack");
        }

    }

     static void sumergir(Stack pila, int dato)  {
        int elem;
        if (!pila.empty()){
            elem = (int) pila.pop ();
            sumergir(pila, dato);
            pila.push (elem);
        }
        else{
            pila.push(dato);
        }
    }

    static void hacerCapicua (Stack pila) {
        int elem;
        if (!pila.empty()){
            elem = (int) pila.pop ();
            hacerCapicua(pila);
            sumergir(pila, elem);
            pila.push(elem);
        }

    }
}
