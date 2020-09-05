package leet.sort;

import com.google.gson.Gson;

/**
 * 快排
 * @author zhangjinchun
 * @date 2020/9/5
 */
public class QuickSort {

    public static void quickSort(int[] nums) {
        quick(nums, 0, nums.length - 1);
    }

    private static void quick(int[] nums, int low, int high) {
        int i, j, temp, t;
        if (low > high) {
            return;
        }
        i = low;
        j = high;
        //temp就是基准位
        temp = nums[low];

        while (i < j) {
            //先看右边，依次往左递减
            while (temp <= nums[j] && i < j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp >= nums[i] && i < j) {
                i++;
            }
            //如果满足条件则交换
            if (i < j) {
                t = nums[j];
                nums[j] = nums[i];
                nums[i] = t;
            }

        }
        //最后将基准为与i和j相等位置的数字交换
        nums[low] = nums[i];
        nums[i] = temp;
        //递归调用左半数组
        quick(nums, low, j - 1);
        //递归调用右半数组
        quick(nums, j + 1, high);
    }

    public static void main(String[] args) {
        int[] nums = {5, 9, 8, 3, 2, 6, 8, 5, 9};
        quickSort(nums);
        System.out.println(new Gson().toJson(nums));
    }
}
