package multithreading;

class DaemonThread implements Runnable {

    @Override
    public synchronized void run() {
        System.out.println(Thread.currentThread().getName() + "......run");
    }

}

// 守护线程
public class DaemonThreadDemo {

    public static void main(String[] args) {
        DaemonThread st = new DaemonThread();
        Thread t1 = new Thread(st);
        Thread t2 = new Thread(st);
        t1.setDaemon(true);
        t2.setDaemon(true);
        int num = 0;
        while (true) {
            if (num++ == 60) {
                break;
            }
            System.out.println(Thread.currentThread().getName() + "..." + num);
        }
        System.out.println("over");
    }


}
