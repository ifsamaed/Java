public class Caracol {

    private String nombre;

    public Caracol(String nombre) {
        this.nombre = nombre;
    }

    // Constructor, getter y setter

    public void procesarDefensa(Lobo lobito, long timeStamp) {

        System.out.println("El caracol " + this.nombre +
                " COMIENZA A PROCESAR LA DEFENSA DEL LOBO " + lobito.getNombre() +
                " EN EL TIEMPO: " + (System.currentTimeMillis() - timeStamp) / 1000	+
                "seg");

        for (int i = 0; i < lobito.getlistadeDefensas().length; i++) {
            this.esperarXsegundos(lobito.getlistadeDefensas()[i]);
            System.out.println("\nProcesado el defensa " + (i + 1) +
                    " ->Tiempo: " + (System.currentTimeMillis() - timeStamp) / 1000 +
                    "seg");

            int timeCarrera = (int) (((System.currentTimeMillis() - timeStamp) / 1000)*10);

            for (int j = 0; j <timeCarrera; j++){
                System.out.printf(" ");
            }
            System.out.printf("@/'");
        }

        System.out.println("\nEl caracol " + this.nombre + " HA TERMINADO LA DEFENSA " +
                lobito.getNombre() + " EN EL TIEMPO: " +
                (System.currentTimeMillis() - timeStamp) / 1000 + "seg");

    }


    private void esperarXsegundos(int segundos) {
        try {

            Thread.sleep(segundos * 1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

}
