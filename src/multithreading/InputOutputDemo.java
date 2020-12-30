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
            if (x == 0) {
                res.set("tom", "male");
            } else {
                res.set("lili", "female");
            }
            x = (x + 1) % 2;
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
            res.out();
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
