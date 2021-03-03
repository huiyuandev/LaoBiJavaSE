package function;

public class Fun {

    /**
     * 修饰符 返回值类型 函数名(参数类型 形式参数1,参数类型 形式参数2...)
     * {
     * 执行语句;
     * return 返回值;
     * }
     * 当函数运算后，没有具体的返回值时，这时返回值类型用一个特殊的关键字来标识。
     * 该关键字就是void，void代表的是函数没有具体返回值的情况
     * 当函数的返回值类型是void时，函数中的return语句可以省略不写
     */
    public static void getResult(int num) {
        System.out.println(num * 3 + 5);
        return;
    }

}
