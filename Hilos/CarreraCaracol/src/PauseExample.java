import java.util.Date;

public class PauseExample implements Runnable {

    private boolean paused = false;
    private boolean stopped = false;

    public void play() {
        paused = false;
        stopped = false;
        new Thread(this, "Player").start();
    }

    public synchronized void pause() {
        paused = true;
    }

    public synchronized void resume() {
        paused = false;
        notify();
    }

    public synchronized void stop() {
        stopped = true;
// If it was paused then resume and then stop
        notify();
    }

    PauseExample() {
    }

    public void run() {
        Date t0 = new Date();
        while (!stopped) {
            try {
                synchronized (this) {
                    if (paused) {
                        System.out.println("Paused");
                        wait();
                        System.out.println("Resumed");
                    }
                }
                long secs = ((new Date()).getTime() - t0.getTime()) / 1000;
                System.out.println(secs);
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.err.println(ex);
            }
        }
    }
}