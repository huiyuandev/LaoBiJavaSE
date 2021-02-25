package loop;

public class ForNest {

    public static void main(String[] args) {
//        printSymbol();
        printSymbol2();
//        printSymbol3();
    }

    /**
     * 需求：
     * 打印如下图形(尖朝下)
     * #####
     * ####
     * ###
     * ##
     * #
     */
    private static void printSymbol() {
        for (int i = 5; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("#");
            }
            System.out.println();
        }
    }

    /**
     * 需求：
     * 打印如下图形(尖朝上)
     * #
     * ##
     * ###
     * ####
     * #####
     */
    private static void printSymbol2() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("#");
            }
            System.out.println();
        }
    }

    /**
     * 需求：
     * 打印如下图形(尖朝上)
     * 1
     * 12
     * 123
     * 1234
     * 12345
     */
    private static void printSymbol3() {
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

}
