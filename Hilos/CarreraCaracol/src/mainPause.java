/**
 * Created by margaret on 14/5/17.
 */
public class mainPause {

    public static void main(String args[]) throws InterruptedException {
        PauseExample p = new PauseExample();
        p.play();
        Thread.sleep(5000);
        p.pause();
        Thread.sleep(5000);
        p.resume();
        Thread.sleep(5000);
        p.stop();
    }


}
