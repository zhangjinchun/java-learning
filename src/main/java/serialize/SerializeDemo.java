package serialize;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author zhangjinchun
 * @date 2018/2/23
 */
public class SerializeDemo
{
    public static void main(String [] args)
    {
        Employee e = new Employee();
        e.name = "员工甲";
        e.identify = "General staff";
        try
        {
            // 打开一个文件输入流
            FileOutputStream fileOut =
                    new FileOutputStream("/Users/zhangjinchun/Public/employee1.db");
            // 建立对象输入流
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            //输出反序列化对象
            out.writeObject(e);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in /Users/zhangjinchun/Public/employee1.db");
        }catch(IOException i)
        {
            i.printStackTrace();
        }
    }
}
