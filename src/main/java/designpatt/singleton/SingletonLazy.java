package designpatt.singleton;

/**
 * 懒汉式单例
 * @author zhangjinchun
 * @date 2020/9/14
 */
public class SingletonLazy {
    public static SingletonLazy singletonLazy;

    private SingletonLazy() {}

    public static SingletonLazy getInstance() {
        if (singletonLazy == null) {
            return new SingletonLazy();
        }
        return singletonLazy;
    }
}
