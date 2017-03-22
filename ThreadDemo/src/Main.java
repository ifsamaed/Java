public class Main {

    public static void main(String[] args) {
        new ThreadClass();
        new ThreadClass();
        checkAccess();
        activeCount();


    }


    public static void activeCount(){
        System.out.println("================================================================");

        //Parameters: NA
        // Return: This method returns the number of active threads in the current thread's thread group.
        // Exception: NA
        Thread t = Thread.currentThread();
        t.setName("Admin Thread");

        // set thread priority to 1
        t.setPriority(1);

        // prints the current thread
        System.out.println("Thread = " + t);

        int count = Thread.activeCount();
        System.out.println("currently active threads = " + count);
          /* prints a stack trace of the current thread to the standard
         error stream, used for debugging, beca */
        Thread.dumpStack();

        Thread th[] = new Thread[count];
        // returns the number of threads put into the array
        Thread.enumerate(th);

        // prints active threads
        for (int i = 0; i < count; i++) {
            System.out.println(i + ": " + th[i]);
        }

    }

    public static void checkAccess(){
        System.out.println("================================================================");

        //Parameters: NA
        // Return: NA
        // Exception: SecurityException − if the current thread is not allowed to access this thread.

        new ThreadClass("A");
        Thread t = Thread.currentThread();

        try {
         /* determines if the currently running thread has permission to
            modify this thread */
            t.checkAccess();
            System.out.println("You have permission to modify");

        }


      /* if the current thread is not allowed to access this thread, then it
         result in throwing a SecurityException. */
        catch(Exception e) {
            System.out.println(e);
        }
    }

}

class ThreadClass implements Runnable {

    Thread t;
    String str;

    public ThreadClass() {
        System.out.println("================================================================");

        // main thread
        Thread currThread = Thread.currentThread();

        // thread created
        Thread t = new Thread(this, "Admin Thread");

        System.out.println("current thread = " + currThread);
        System.out.println("thread created = " + t);

        // this will call run() function
        t.start();
    }

    ThreadClass(String str) {
        System.out.println("================================================================");

        this.str = str;
        t = new Thread(this);

        // this will call run() function
        t.start();
    }



    public void run() {
        System.out.println("This is run() function");

    }
}

