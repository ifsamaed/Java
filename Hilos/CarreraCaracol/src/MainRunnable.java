public class MainRunnable implements Runnable{

    private Lobo lobo;
    private Caracol caracol;
    private long initialTime;

    public MainRunnable (Lobo lobo, Caracol caracol, long initialTime){
        this.caracol = caracol;
        this.lobo = lobo;
        this.initialTime = initialTime;
    }

    public static void main(String[] args) {

        Lobo lobo1 = new Lobo("Lobo 1", new int[] { 2, 2, 1, 5, 2, 3 });
        Lobo lobo2 = new Lobo("Lobo 2", new int[] { 1, 3, 5, 1, 1 });

        Caracol caracol1 = new Caracol("Caracol 1");
        Caracol caracol2 = new Caracol("Caracol 2");

        // Tiempo inicial de referencia
        long initialTime = System.currentTimeMillis();

        Runnable proceso1 = new MainRunnable(lobo1, caracol1, initialTime);
        Runnable proceso2 = new MainRunnable(lobo2, caracol2, initialTime);

        new Thread(proceso1).start();
        new Thread(proceso2).start();

    }

    @Override
    public void run() {
        this.caracol.procesarDefensa(this.lobo, this.initialTime);
    }

}
