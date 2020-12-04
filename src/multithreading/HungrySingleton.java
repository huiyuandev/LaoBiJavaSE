package multithreading;

/**
 * 单例设计模式
 * 饿汉式
 */
public class HungrySingleton {

    private HungrySingleton() {
    }

    private static final HungrySingleton hungrySingleton = new HungrySingleton();

    public static HungrySingleton getInstance() {
        return hungrySingleton;
    }

}
