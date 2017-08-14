import org.nevec.rjm.BigDecimalMath;
import org.nevec.rjm.Rational;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainDemo {


    public static BigInteger TWO = BigInteger.valueOf(2);

    public static long initialTime;

    public static void main(String[] args) {

        // Tiempo inicial de referencia
        initialTime = System.currentTimeMillis();

        //El principal problema es que un cifrado puede tardar mas tiempo de lo esperado mas de 45 min
        //Para reducir este tiempo debemos recudir el tiempo de ataque
        //Para ello debemos hacer uso de los hilos en tiempo de ejecución
        //Se debe crear crear hilos de manera exponecial,
        /*  Si el ataque tarda mas de 2 min se debe crear dos hilos

            Si tarda 3 min se debe crear 4 hilos
            Si tarda 4 min se debe crear 8 hilos
        */


        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0 ; i <10; i++){
            Runnable worker = new WorkerThread(""+i);
            executorService.execute(worker);
            ataqueCiclico(initialTime);
        }

        executorService.shutdown();
        while (!executorService.isTerminated()){
        }
        System.out.println("Finished all threads");


    }

    public static  void ataqueCiclico( long timeStamp){
        // TODO code application logic here
        BigInteger Ndec = new BigInteger("35");

        System.out.println("El resultado de N es: "+ Ndec);

        //String Ehex="010001";
        BigInteger Edec = BigInteger.valueOf(0);
        Edec= new BigInteger("5");
        System.out.println("El resultado de E es: "+ Edec);

        //String Chex="293D9E806D9F9040E52F71B4026FD5AA95D965E7319728F220ADB44794CEA3D6";
        BigInteger Cdec = BigInteger.valueOf(0);
        Cdec= new BigInteger("25");
        System.out.println("El resultado de C es: "+ Cdec);

        //ataque
        //C^e mod n = 507 mod 187 = 118
        BigInteger result = BigInteger.valueOf(0);
        // variable para no machacar Cdec original que se necesita
        BigInteger CdecNueva = BigInteger.valueOf(0);
        CdecNueva=Cdec;
        int cont=0;

        System.out.println("");
        System.out.println("");
        System.out.println("====================================");
        System.out.println("Ataque");

        //uso dowhile porque a la primera me lo tiene que hacer una vez sino no entraria
        do{
            System.out.println("Cdec original "+Cdec);// traza borrar
            System.out.println("");

            cont++;
            //Esta funcion es igua a esto C^e mod n
            result= CdecNueva.modPow(Edec, Ndec);
            System.out.println("Result Ronda "+cont+": "+result);
            System.out.println("-----------------------------------");
            //para continuar el ataque Cdecimal es el resultado anterior
            CdecNueva=result;
            System.out.println("Cdec original: "+Cdec+" CdecNueva: "+CdecNueva);// traza borrar

        }while(!(CdecNueva.equals(Cdec)));

        //
        System.out.println("El ataque ha demorado "+ (System.currentTimeMillis() - timeStamp) / 1000 + "seg");
    }

    public static void factorizacionFermat(long timeStamp){

        System.out.println("");
        System.out.println("");
        System.out.println("====================================");
        System.out.println("Ataque Factorizacion Fermat");

        BigDecimal Ndec=new BigDecimal("52841");
        System.out.println("El resultado de N es: "+ Ndec);

        Rational rt = new Rational(1,2); // sqrt 2
        BigDecimal sqrtNdec = BigDecimalMath.powRound(Ndec,rt).round(new MathContext(5, RoundingMode.HALF_UP));
        System.out.println("El resultado de sqrt(N) es: "+ sqrtNdec.toString());

        BigDecimal Ydec,sqrtY ;
        BigDecimal Xdec = sqrtNdec;

        try{
        do{
            System.out.println("");
            System.out.println("");

            System.out.println("El resultado de X es: "+ Xdec);

            Ydec = Xdec.pow(2).subtract(Ndec);
            System.out.println("El resultado de Y es: "+ Ydec);

            sqrtY= BigDecimalMath.powRound(Ydec, rt);
            System.out.println("El resultado de sqrt(Y) es: "+sqrtY);

            Xdec =  Xdec.add(BigDecimal.ONE);

        }while (sqrtY.remainder(BigDecimal.valueOf(2)).compareTo(BigDecimal.ZERO)!=0);

            System.out.println("El ataque ha demorado "+ (System.currentTimeMillis() - timeStamp) / 1000 + "seg");

}catch (ArithmeticException arithmeticException) {
    System.err.println("arithmeticException = " + arithmeticException);
    System.out.println("Encontrado el cuadrado perfecto");
}

    }
    public static void factorizacionPollard(long timeStamp){
        System.out.println("");
        System.out.println("");
        System.out.println("====================================");
        System.out.println("Ataque Factorizacion Pollard");

        BigInteger Xdec= TWO;
        BigInteger Ydec = TWO;
        BigInteger Ddec = BigInteger.ONE;
        BigInteger Ndec=new BigInteger("52841");

        System.out.println("El resultado de N es: "+ Ndec);
        System.out.println("El resultado de X es: "+ Xdec);
        System.out.println("El resultado de Y es: "+ Ydec);
        System.out.println("El resultado de D es: "+ Ddec);
        System.out.println("");
        System.out.println("");
        int cont=0;


        do {
            cont++;
            System.out.println("Result Ronda "+cont+": ");
            System.out.println("-----------------------------------");

            Xdec = funcionAleatoria(Xdec);
            System.out.println("El resultado de X es: "+ Xdec);

            Ydec = funcionAleatoria(funcionAleatoria(Ydec));
            System.out.println("El resultado de Y es: "+ Ydec);

            Ddec = Xdec.subtract(Ydec).gcd(Ndec);
            System.out.println("El resultado de D es: "+ Ddec);
            System.out.println("");

        }while(Ddec.compareTo(BigInteger.ONE)== 0);

        if (Ddec.compareTo(Ndec)==-1){
            //SE HA ENCONTRADO UN FACTOR NO TRIVIAL DISTINTO DE UNO
            System.out.println("Encontrado factor trivial");
            System.out.println("El ataque ha demorado "+ (System.currentTimeMillis() - timeStamp) / 1000 + "seg");


        }else {
            //NECESITAMOS CAMBIAR LA FUNCIÓN PSEUDOALEATORIA.
            System.out.println("No se ha encontrado ningún factor no trivial de n");
        }




    }

    public static BigInteger funcionAleatoria(BigInteger x){

        BigInteger Ndec=new BigInteger("52841");

        return (x.pow(2).add(BigInteger.ONE).mod(Ndec));
    }

}
