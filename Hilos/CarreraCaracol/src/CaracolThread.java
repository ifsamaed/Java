
public class CaracolThread extends  Thread{

    private String nombre;
    private Lobo lobo;
    private long initialTime;

    public CaracolThread(String s, Lobo lobo1, long initialTime) {
        this.lobo = lobo1;
        this.nombre = s;
        this.initialTime = initialTime;
    }


    @Override
    public void run(){
        System.out.println("El caracol " + this.nombre +
                " COMIENZA A PROCESAR LA DEFENSA CONTRA EL LOBO " + lobo.getNombre() +
                " EN EL TIEMPO: " + (System.currentTimeMillis() - initialTime) / 1000	+
                "seg");

        for (int i = 0; i < lobo.getlistadeDefensas().length; i++) {
            this.esperarXsegundos(lobo.getlistadeDefensas()[i]);
            System.out.println("Procesado la defensa " + (i + 1) +
                    " ->Tiempo: " + (System.currentTimeMillis() - initialTime) / 1000 +
                    "seg");
        }

        System.out.println("El caracol " + this.nombre + " HA TERMINADO DE PROCESAR " +
                lobo.getNombre() + " EN EL TIEMPO: " +
                (System.currentTimeMillis() - initialTime) / 1000 + "seg");

    }


    private void esperarXsegundos(int segundos) {
        try {

            Thread.sleep(segundos * 1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

}
