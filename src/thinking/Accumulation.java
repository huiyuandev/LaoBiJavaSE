package thinking;


/**
 * 累加思想
 */
public class Accumulation {

    public static void main(String[] args) {
//        fun1();
        fun2();
    }

    // 需求：求1+2+3+...+100的和

    // 实现方式1:while循环
    private static void fun1() {
        // 1.定义变量用于存储不断变化的和
        int sum = 0;
        // 2.定义变量，记录住不断变化的被加的数
        int x = 1;
        while (x <= 100) {
//            sum = sum + x;
            sum += x;
            x++;
        }
        System.out.println(sum);
    }

    // 实现方式2:for循环
    private static void fun2() {
        int sum = 0;
        for (int x = 1; x <= 100; x++) {
            sum += x;
        }
        System.out.println(sum);
    }

}
