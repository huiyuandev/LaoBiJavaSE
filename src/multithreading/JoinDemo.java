package multithreading;

class Join implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 70; i++) {
            System.out.println(Thread.currentThread().getName() + "..." + i);
        }
    }

}

/**
 * join
 * 当A线程执行到了B线程的join方法时，A就会等待，等到B线程全部执行完，A才会执行
 * join可以用来临时加入线程执行
 */
public class JoinDemo {

    public static void main(String[] args) throws InterruptedException {
        Join join = new Join();
        Thread t1 = new Thread(join);
        Thread t2 = new Thread(join);
        t1.start();
        t2.start();
        t1.join();
        for (int i = 0; i < 80; i++) {
            System.out.println("main..." + i);
        }
        System.out.println("over");
    }

}
