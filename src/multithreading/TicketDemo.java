package multithreading;

/**
 * 需求：简单的卖票程序，多个窗口同时卖票
 */
class SaleTicket extends Thread {

    private static int ticket = 100; // 不建议使用静态

    @Override
    public void run() {
        while (true) {
            if (ticket > 0) {
                System.out.println(currentThread().getName() + " sale ..." + ticket--);
            }
        }
    }

}


public class TicketDemo {

    public static void main(String[] args) {
        SaleTicket t1 = new SaleTicket();
        SaleTicket t2 = new SaleTicket();
        SaleTicket t3 = new SaleTicket();
        SaleTicket t4 = new SaleTicket();

        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }

}
