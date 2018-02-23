package aopdemo;

/**
 * Created by zhangjinchun on 2017/12/15.
 */
public class RealSubject implements Subject
{
    @Override
    public void rent()
    {
        System.out.println("I want to rent my house");
    }

    @Override
    public void hello(String str)
    {
        System.out.println("hello: " + str);
    }
}
