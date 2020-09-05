package leet.math;

import com.google.gson.Gson;
import leet.listnode.ListNode;

/**
 * 69. x 的平方根
 * @author zhangjinchun
 * @date 2020/9/5
 */
public class Sqrt {

    /**
     * 二分查找法
     * @param x
     * @return
     */
    public static int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        int left = 0, right = x >> 1;
        while (left < right) {
            int mid = left + (right - left)/2;
            long temp = mid * mid;
            if (temp == x) {
                return mid;
            }
            if (temp < x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left - 1;
    }

    public static void main(String[] args) {

        int result = mySqrt(20);
        System.out.println(new Gson().toJson(result));
    }
}
