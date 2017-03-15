import java.math.BigInteger;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        gcd(new BigInteger("12"), new BigInteger("18"));

        modulo(new BigInteger("397"), new BigInteger("244"));

        modInverse(new BigInteger("397"), new BigInteger("244"));

        probablePrime(21);

        nextPrime(new BigInteger("397"));

    }


    public static void gcd(BigInteger bi1, BigInteger bi2) {

        // create 3 BigInteger objects
        BigInteger bi3;

        System.out.println("Bin of " + bi1 + " is " + bi1.toString(2));
        System.out.println("The number of bits in the two's complemen " + " is " + bi1.bitCount());
        System.out.println("The number of bits in the minimal two's-complement, excluding a sign bit is " + bi1.bitLength());
        System.out.println("The index of the rightmost one bit is " + bi1.getLowestSetBit());
        // assign gcd of bi1, bi2 to bi3
        bi3 = bi1.gcd(bi2);


        String str = "GCD of " + bi1 + " and " + bi2 + " is " + bi3;

        // print bi3 value
        System.out.println(str);
    }

    public static void modulo(BigInteger bi1, BigInteger bi2) {
        BigInteger bi3, bi4;

        // perform mod operation on bi1 using bi2
        try {

            bi3 = bi1.mod(bi2);
            String str = bi1 + " mod " + bi2 + " is " + bi3;
            // print bi3 value
            System.out.println(str);
            // perform remainder operation on bi1 using bi2

            bi4 = bi1.remainder(bi2);

            str = bi1 + " % " + bi2 + " is " + bi4;
            // print bi3 value
            System.out.println("Remainder result for " + str);

        } catch (ArithmeticException e) {
            System.out.println("El modulo no puede ser menor de cero");
        }
    }

    public static void modInverse(BigInteger bi1, BigInteger bi2) {
        BigInteger bi3;

        try {
            // perform modInverse operation on bi1 using bi2
            bi3 = bi1.modInverse(bi2);

            String str = bi1 + "^-1 mod " + bi2 + " is " + bi3;

            // print bi3 value
            System.out.println(str);


        } catch (ArithmeticException e) {
            System.out.println("El modulo no puede ser menor de cero");
        }


    }

    public static void probablePrime(int bitLength) {
        try {

            // create a BigInteger object
            BigInteger bi;

            // create a random object
            Random rnd = new Random();

            // assign probablePrime result to bi using bitLength and rnd
            // static method is called using class name
            bi = BigInteger.probablePrime(bitLength, rnd);

            String str = "ProbablePrime of bitlength " + bitLength + " is " + bi;

            // print bi value
            System.out.println(str);
        } catch (ArithmeticException e) {

            System.out.println("bitlength no puede ser menor de 2");

        }
    }

    public static void nextPrime(BigInteger bi1) {

        // create 2 BigInteger objects
        BigInteger bi2;

        // assign nextProbablePrime value of bi1 to bi2
        bi2 = bi1.nextProbablePrime();

        String str = "Next probable prime after " + bi1 + " is " + bi2;

        // print bi2 value
        System.out.println(str);
    }


}