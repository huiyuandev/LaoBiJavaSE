package multithreading;

class SaleTicket3 implements Runnable {

    private int ticket = 100;
    public boolean flag = false;

    @Override
    public void run() {

        if (flag) {
            while (true) {
                if (ticket > 0) {
                    synchronized (this) {
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + " 同步代码块：" + ticket--);
                    }
                }
            }
        } else {
            while (true) {
                show();
            }
        }

    }

    // 同步函数的锁是this
    private synchronized void show() {
        if (ticket > 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 同步函数：" + ticket--);
        }
    }

}

public class ThisLock {

    public static void main(String[] args) {
        SaleTicket3 t = new SaleTicket3();

        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);

        t1.start();

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t.flag = false;
        t2.start();

    }

}
