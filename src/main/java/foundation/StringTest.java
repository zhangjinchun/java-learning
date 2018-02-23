package foundation;

import com.alibaba.fastjson.JSON;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by zhangjinchun on 2017/12/15.
 */
public class StringTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        add(list,10);
        String s = list.get(0);
    }

    public static void add(List list,Object o){
        list.add(o);
    }
}
