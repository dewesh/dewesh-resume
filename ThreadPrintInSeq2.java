public class ThreadPrintInSeq2 {


    public static void main(String[] args) {

        PrintEven printEven = new PrintEven();
        PrintOdd printOdd = new PrintOdd();
        Thread t1 = new Thread(printEven);
        Thread t2 = new Thread(printOdd);
        t1.start();
        t2.start();
    }
}

class PrintOdd implements Runnable {

    int i = 1;
    @Override
    public void run() {
        try {
            Thread.sleep(100);
            Thread.currentThread().wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(i);
        i = i+2;
        Thread.currentThread().notifyAll();
    }
}

class PrintEven implements Runnable {

    int i = 0;
    @Override
    public void run() {
        System.out.println(i);
        Thread.currentThread().notifyAll();
        i = i+2;
        try {
            Thread.currentThread().wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
