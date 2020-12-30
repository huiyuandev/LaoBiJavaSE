package multithreading;

class Input implements Runnable {

    private Res res;

    public Input(Res res) {
        this.res = res;
    }

    @Override
    public void run() {
        int x = 0;
        while (true) {
            synchronized (res) {
                if (res.flag) {
                    try {
                        res.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (x == 0) {
                        res.name = "tom";
                        res.sex = "male";
                    } else {
                        res.name = "lili";
                        res.sex = "female";
                    }
                }
            }
            x = (x + 1) % 2;
            res.flag = true;
            res.notify();
        }
    }

}

class Output implements Runnable {

    private Res res;

    public Output(Res res) {
        this.res = res;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (res) {
                if (!res.flag) {
                    try {
                        res.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(res.name + "......" + res.sex);
                res.flag = false;
                res.notify();
            }
        }
    }

}

/**
 * 线程间通信
 */
public class InputOutputDemo {
    public static void main(String[] args) {
        Res res = new Res();

        Input input = new Input(res);
        Output output = new Output(res);

        Thread t1 = new Thread(input);
        Thread t2 = new Thread(output);

        t1.start();
        t2.start();

    }
}
