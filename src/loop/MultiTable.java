package loop;

public class MultiTable {

    public static void main(String[] args) {
        print99();
    }

    /**
     * 打印九九乘法表
     */
    private static void print99() {
        for (int x = 1; x < 10; x++) {
            for (int y = 1; y <= x; y++) {
                System.out.print(y + " * " + x + " = " + y * x + "\t");
            }
            System.out.println();
        }
    }


}
