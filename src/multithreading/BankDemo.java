package multithreading;

/**
 * 需求：
 * 银行有一个金库，有两个储户分别存300元，存3次，每次存100
 */
class Bank {

    private int sum = 0;

    // 同步函数
    public synchronized void add(int n) {
        sum += n;
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sum = " + sum);
    }

}

class Cus implements Runnable {

    private Bank bank = new Bank();

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            bank.add(100);
        }
    }

}

public class BankDemo {

    public static void main(String[] args) {
        Cus cus = new Cus();
        Thread t1 = new Thread(cus);
        Thread t2 = new Thread(cus);
        t1.start();
        t2.start();
    }

}
