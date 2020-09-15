package designpatt.singleton;

/**
 * 饿汉式单例
 * @author zhangjinchun
 * @date 2020/9/14
 */
public class Singleton {
    private static Singleton singleton = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return singleton;
    }
}
