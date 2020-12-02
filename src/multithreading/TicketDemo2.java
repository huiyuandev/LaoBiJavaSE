package multithreading;

/**
 * 需求：简单的卖票程序，多个窗口同时卖票
 * 实现Runnable接口
 */
class SaleTicket2 implements Runnable {

    private static int ticket = 100; // 不建议使用静态

    @Override
    public void run() {
        while (true) {
            synchronized (this){
                if (ticket > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " sale ..." + ticket--);
                }
            }
        }
    }

}


public class TicketDemo2 {

    public static void main(String[] args) {
        SaleTicket2 t = new SaleTicket2();

        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        Thread t3 = new Thread(t);
        Thread t4 = new Thread(t);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }

}
