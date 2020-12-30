package multithreading;

class Res {
    String name;
    String sex;
    boolean flag = false;

    public synchronized void set(String name, String sex) {
        if (flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.name = name;
            this.sex = sex;
            notify();
        }
    }


    public synchronized void out() {
        if (!flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + "......" + sex);
            flag = false;
            notify();
        }
    }


}