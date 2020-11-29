package multithreading;

/**
 * 进程：
 * 是一个正在执行中的程序。每个进程执行都有一个执行顺序，该顺序是一个执行路径，或者叫一个控制单元
 * <p>
 * 线程：就是进程中的一个独立的控制单元，线程控制着进程的执行
 * 一个进程中至少有一个线程
 * <p>
 * <p>
 * Java VM 启动的时候会有一个进程java.exe
 * <p>
 * 该进程中至少有一个线程负责Java程序的执行
 * 而且这个线程运行的代码存在于main方法中，该线程称之为主线程
 * <p>
 * 扩展：更细节说明jvm，jvm启动不止一个线程，还有负责垃圾回收机制的线程
 */

class Demo extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 60; i++)
            System.out.println("demo run--" + i);
    }

}


public class ThreadDemo {

    public static void main(String[] args) {

        Demo d = new Demo();
        d.start();

        for (int i = 0; i < 60; i++)
            System.out.println("Hello World--" + i);

    }

}
