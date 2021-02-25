package loop;

public class BreakAndContinue {

    public static void main(String[] args) {
//        breakUse();
//        continueUse();
        continueUse2();
    }

    // break用法；break默认跳出离其最近的循环
    private static void breakUse() {
        // 标号
        flag:
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 4; y++) {
                System.out.println("x = " + x);
                break flag;
            }
        }
    }

    private static void continueUse() {
        for (int x = 1; x <= 10; x++) {
            if (x % 2 == 1) {
                continue;
            }
            System.out.println("x = " + x);
        }
    }

    private static void continueUse2() {
        // 标号
        flag:
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 4; y++) {
                System.out.println("x = " + x);
                continue flag;
            }
        }
    }


}
