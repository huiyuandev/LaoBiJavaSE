package multithreading;

/**
 * 死锁：同步中嵌套同步，而锁却不同
 */
class TestDeadLock implements Runnable {

    private boolean flag;

    TestDeadLock(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        if (flag) {
            while (true) {
                synchronized (MyLock.lockA) {
                    System.out.println("if lockA");
                    synchronized (MyLock.lockB) {
                        System.out.println("if lockB");
                    }
                }
            }
        } else {
            while (true) {
                synchronized (MyLock.lockB) {
                    System.out.println("else lockB");
                    synchronized (MyLock.lockA) {
                        System.out.println("else lockA");
                    }
                }
            }
        }
    }

}

class MyLock {
    final static Object lockA = new Object();
    final static Object lockB = new Object();
}

public class DeadLock {

    public static void main(String[] args) {
        Thread t1 = new Thread(new TestDeadLock(true));
        Thread t2 = new Thread(new TestDeadLock(false));
        t1.start();
        t2.start();
    }

}
