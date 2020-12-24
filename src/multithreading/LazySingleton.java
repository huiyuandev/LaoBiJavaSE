package multithreading;

/**
 * 单例设计模式
 * <p>
 * <p>
 * 懒汉式
 */
public class LazySingleton {

    // 1.构造函数私有
    private LazySingleton() {
    }

    private static volatile LazySingleton lazySingleton = null;

    public static LazySingleton getInstance() {
        // 双重判断防止多线程访问时出现安隐患
        if (lazySingleton == null) {
            synchronized (LazySingleton.class) {
                if (lazySingleton == null) {
                    lazySingleton = new LazySingleton();
                }
            }
        }
        return lazySingleton;
    }

}
