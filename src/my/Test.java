package my;

import java.util.Scanner;

/**
 * 分解质因数
 * 案例：将一个正整数分解质因数。例如:输入 100 : 打印 100 = 2 * 2 * 5 * 5
 *
 * 思路分析：对n进行分解质因数，应先找到一个最小的质数k，然后按下述步骤完成：
 *
 * 1.如果这个质数恰等于n，则说明分解质因数的过程已经结束，打印出即可。
 * 2.如果n>k，但n能被k整除，则应打印出k的值，并用n除以k的商,作为新的正整数你n,重复执行第一步。
 * 3.如果n不能被k整除，则用k+1作为k的值,重复执行第一步。
 * ————————————————
 * 版权声明：本文为CSDN博主「cui_yonghua」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/cui_yonghua/article/details/93975617
 */
public class Test {

    public static void main(String[] args) {
        System.out.print("请输入一个大于2的正整数:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.print(n + " = ");
        f(n);
    }

    private static int k = 2;

    private static void f(int n) {
        while (k <= n) {
            if (k == n) {
                System.out.print(n);
                break;
            } else if (n % k == 0) {
                System.out.print(k + " * ");
                n = n / k;
                f(n);
                break;
            } else if (n % k != 0) {
                k++;
                f(n);
                break;
            }
        }
    }

}
