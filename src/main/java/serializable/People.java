package serializable;

/**
 * @author zhangjinchun
 * @date 2018/3/9
 */
class People{
    int num;

    public People(){
        this.num = num;
    }  			//默认的无参构造函数，没有进行初始化

    public People(int num){		//有参构造函数
        this.num = num;
    }

    @Override
    public String toString(){
        return "num:"+num;
    }
}
