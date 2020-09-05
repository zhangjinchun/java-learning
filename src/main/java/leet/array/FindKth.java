package leet.array;

import com.google.gson.Gson;

/**
 * @author zhangjinchun
 * @date 2020/9/5
 */
public class FindKth {

    public static int findKth(int[] a, int n, int K) {
        if (a == null) {
            return -1;
        }

        return findK(a, 0, a.length-1, a.length - K);
    }

    private static int findK(int[] nums, int left, int right, int k) {
        int l = left, r = right;
        int temp = nums[left];
        while (l < r) {
            while (nums[r] > temp && l < r) {
                r--;
            }
            nums[l++] = nums[r];
            while (nums[l] <= temp && l < r) {
                l++;
            }
            nums[r] = nums[l];
        }
        nums[l] = temp;
        if (l == k) {
            return temp;
        } else if (l < k) {
            return findK(nums, l+1, right, k);
        } else {
            return findK(nums, left, l-1, k);
        }
    }

    public static void main(String[] args) {
        int[] arrs = {8, 7, 3, 9, 5, 5};
        int result = findKth(arrs, 6, 3);
        System.out.println(new Gson().toJson(result));
    }
}
