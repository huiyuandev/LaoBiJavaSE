package multithreading;

/**
 * 创建两个线程和主线程交替执行
 */
class Test extends Thread {

//    private String name;

//    Test(String name) {
//        super(name);
////        this.name = name;
//    }

    @Override
    public void run() {
        for (int i = 0; i < 60; i++) {
//            System.out.println("Test " + name + " run..." + i);
            System.out.println((Thread.currentThread() == this) + "..." + getName() + " run..." + i);
        }
    }

}

public class ThreadTest {

    public static void main(String[] args) {
//        Test t1 = new Test("one");
//        Test t2 = new Test("two");
        Test t1 = new Test();
        Test t2 = new Test();
        t1.start();
        t2.start();

        for (int i = 0; i < 60; i++) {
            System.out.println("main run..." + i);
        }
    }

}
