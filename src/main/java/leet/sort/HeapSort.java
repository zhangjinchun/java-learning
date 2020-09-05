package leet.sort;

import com.google.gson.Gson;

/**
 * 堆排序
 * @author zhangjinchun
 * @date 2020/9/5
 */
public class HeapSort {

    public static void heapSort(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return;
        }
        for (int i = (nums.length - 1) / 2; i >= 0; i--) {
            adjustHeap(nums, i, nums.length - 1);
        }
        for (int j = nums.length - 1; j > 0; j--) {
            int temp = nums[0];
            nums[0] = nums[j];
            nums[j] = temp;
            adjustHeap(nums, 0, j - 1);
        }
    }

    private static void adjustHeap(int[] nums, int parent, int len) {
        int temp = nums[parent];
        int lChild = parent * 2 + 1;
        while (lChild <= len) {
            int rChild = lChild + 1;
            if (rChild <= len && nums[rChild] > nums[lChild]) {
                lChild++;
            }
            if (temp < nums[lChild]) {
                nums[parent] = nums[lChild];
            }
            parent = lChild;
            lChild = parent * 2 + 1;
        }
        nums[parent] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {5, 9, 8, 3, 2, 6, 8, 5, 9};
        heapSort(nums);
        System.out.println(new Gson().toJson(nums));
    }
}
