package nowcoder;

import java.util.*;

/**
 * @author zhangjinchun
 * @date 2021/2/25
 */
public class ScannerDemo {
    public static void main(String[] args) {
        scA();
    }

    /** 字符串 一直输入 ，号间隔
     a,c,bb
     f,dddd
     nowcoder
     *
     a,bb,c
     dddd,f
     nowcoder
     */
    public static void scA() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String[] strs = in.nextLine().split(",");
            Arrays.sort(strs);
            // System.out.println(String.join(",",s));
            String res = "";
            for (String s : strs) {
                res += s + ",";
            }
            System.out.println(res.substring(0, res.length() - 1));
        }
    }
}
