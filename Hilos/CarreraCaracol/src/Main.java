public class Main {

    public static void main(String[] args) {


        Lobo lobo1 = new Lobo("Lobo 1", new int[] { 2, 2, 1, 5, 2, 3 });
        Lobo lobo2 = new Lobo("Lobo 2", new int[] { 1, 3, 5, 1, 1 });

        Caracol Caracol1 = new Caracol("Dolly");
        Caracol Caracol2 = new Caracol("Nuve");

        // Tiempo inicial de referencia
        long initialTime = System.currentTimeMillis();

        Caracol1.procesarDefensa(lobo1, initialTime);
        Caracol2.procesarDefensa(lobo2, initialTime);


    }
}

