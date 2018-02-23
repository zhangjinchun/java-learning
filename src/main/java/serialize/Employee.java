package serialize;

/**
 * @author zhangjinchun
 * @date 2018/2/23
 */
public class Employee implements java.io.Serializable
{
    public String name;
    public String identify;
    public void mailCheck()
    {
        System.out.println("This is the "+this.identify+" of our company");
    }
}
