package multithreading;

class Res {
    String name;
    String sex;
}

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
                if (x == 0) {
                    res.name = "tom";
                    res.sex = "male";
                } else {
                    res.name = "lili";
                    res.sex = "female";
                }
            }
            x = (x + 1) % 2;
        }
    }

}

class Output implements Runnable {

    private Res res;///////

    public Output(Res res) {
        this.res = res;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (res) {
                System.out.println(res.name + "......" + res.sex);
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
