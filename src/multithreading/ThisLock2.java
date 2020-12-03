package multithreading;

class SaleTicket4 implements Runnable {

    private static int ticket = 100;
    public boolean flag = false;

    @Override
    public void run() {

        if (flag) {
            while (true) {
                if (ticket > 0) {
                    synchronized (SaleTicket4.class) {
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

    // 静态的同步方法，使用的锁是该方法所在类的字节码文件对象
    private static synchronized void show() {
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

public class ThisLock2 {

    public static void main(String[] args) {
        SaleTicket4 t = new SaleTicket4();

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
