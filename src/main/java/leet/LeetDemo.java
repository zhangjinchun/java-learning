package leet;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import org.apache.commons.lang.CharUtils;
import org.apache.commons.lang.StringUtils;
import serializable.People;

import javax.management.StandardEmitterMBean;
import javax.swing.tree.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

/**
 * @author zhangjinchun
 * @date 2020/6/16
 */
public class LeetDemo {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static int numDecodings(String s) {
        return getAns(s, 0);
    }

    private static int getAns(String s, int start) {
        //划分到了最后返回 1
        if (start == s.length()) {
            return 1;
        }
        //开头是 0,0 不对应任何字母，直接返回 0
        if (s.charAt(start) == '0') {
            return 0;
        }
        //得到第一种的划分的解码方式
        int ans1 = getAns(s, start + 1);
        int ans2 = 0;
        //判断前两个数字是不是小于等于 26 的
        if (start < s.length() - 1) {
            int ten = (s.charAt(start) - '0') * 10;
            int one = s.charAt(start + 1) - '0';
            if (ten + one <= 26) {
                ans2 = getAns(s, start + 2);
            }
        }
        return ans1 + ans2;
    }

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

    public static void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode tempRight = root.right;
        root.right = root.left;
        flatten(root.left);
        root = root.right;
        flatten(tempRight);


    }


    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(5);
        TreeNode root = new TreeNode(1, t1,t2);
        flatten(root);
        int[] nums = {5, 9, 8, 3, 2, 6, 8, 5, 6, 6, 9};
        String s = "102627";
        String p = "dss";
        String target = "VIV";

        heapSort(nums);
        System.out.println(new Gson().toJson(nums));
    }
}
