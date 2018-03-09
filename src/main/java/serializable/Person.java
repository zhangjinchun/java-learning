package serializable;

import java.io.Serializable;

/**
 * @author zhangjinchun
 * @date 2018/3/9
 */
class Person extends People implements Serializable {

    private static final long serialVersionUID = -6081209512666029982L;

    String name;
    int age;

    public Person(int num,String name,int age){
        super(num);				//调用父类中的构造函数
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString(){
        return super.toString()+"\tname:"+name+"\tage:"+age;
    }
}