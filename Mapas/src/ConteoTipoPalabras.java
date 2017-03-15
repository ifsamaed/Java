import java.util.*;

/**
 * Created by Margaret on 15/03/2017.
 */
public class ConteoTipoPalabras {

    private Map<String, Integer> mapa;
    private Scanner scanner;

    public ConteoTipoPalabras(){

        mapa = new HashMap<String, Integer>();//Creamos un objeto HashMap
        scanner = new Scanner(System.in);//Para la lectura de datos
        crearMapa();
        mostrarMapa();

    }

    //Crea un mapa a partir de los datos del usuario
    private void crearMapa() {
        System.out.println("Escriba una cadena guapi: ");
        String entrada = scanner.nextLine();

        StringTokenizer tokenizer = new StringTokenizer(entrada);

        //procesamientos del texto de entrada
        while ( tokenizer.hasMoreTokens()) // Mientras haya más entrada
        {
            String palabra = tokenizer.nextToken().toLowerCase(); //obtine una palabra

            //Si el mapa contiene la palabra
            if (mapa.containsKey(palabra)){
                int cuenta = mapa.get(palabra);
                mapa.put(palabra, cuenta+1);
            }else
            {
                mapa.put(palabra, 1); //agrega una nueva palbara con una nueva cuenta de 1 al mapa
            }
        }
    }

    private void mostrarMapa() {

        Set<String> claves = mapa.keySet(); //obtiene las claves

        //ordena las claves
        TreeSet<String> clavesOrdenadas = new TreeSet<String>(claves);

        System.out.println("El mapa contiene: \nClave\t\tValor");

        //genera la salida para cada clave en el mapa
        for (String clave : clavesOrdenadas)
            System.out.printf("%-10s%10s\n", clave, mapa.get(clave));

        System.out.printf("\nsize:%d\nisEmpty:%b\n", mapa.size(), mapa.isEmpty());
    }



}
