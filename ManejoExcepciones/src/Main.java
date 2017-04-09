import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

//Para un mejor uso se debe implentar una clase que maneje las excepciones
    public static void main(String[] args) {
        System.out.println("División entre cero:");
        Scanner explorador = new Scanner(System.in);
        boolean continuarCiclo = true; //determina si se necesitan más datos

        do {

            try {

                System.out.println("Introduzca un numerador entero: ");
                int numerador = explorador.nextByte();
                System.out.println("Introduzca un denominador entero: ");
                int denominador = explorador.nextByte();

                int resultado = cociente(numerador, denominador);

                System.out.printf("Resultado: %d / %d = %d\n", numerador, denominador, resultado);
                continuarCiclo = false;

            } catch (InputMismatchException inputMismatchException) { // Si introduce una cadena

                System.err.println("inputMismatchException = " + inputMismatchException);
                explorador.nextLine();//Descartamos la entrada para que el usuario intento otra vez
                System.out.println("Debe introducir elementos enteros. Intente  de nuevo .\n");

            } catch (ArithmeticException arithmeticException) {
                System.err.println("arithmeticException = " + arithmeticException);
                System.out.println("Cero es un denominador invalido. Intente  de nuevo .\n");
            }
        } while (continuarCiclo);

    }

    private static int cociente(int numerador, int denominador)
            throws ArithmeticException {
        return numerador / denominador;

    }

}
