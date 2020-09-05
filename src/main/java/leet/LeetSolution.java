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
public class LeetSolution {

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

    public static class Node {
        int key, val;
        Node prev;
        Node next;
        Node() {
        }
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
        Node(int key, int val, Node prev, Node next) {
            this.key = key;
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
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

    public static TreeNode exchangeNode(TreeNode node) {
        if (node == null) {
            return null;
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(node);
//        TreeNode resTree = new TreeNode();
        while (!queue.isEmpty()) {
            TreeNode temp = queue.pop();
            TreeNode tmp = temp.left;
            temp.left = temp.right;
            temp.right = tmp;
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
        try {
            Class<?> clsType = People.class;
            Class.forName("main.java.serializable.People.java");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return node;
    }

    public static int max = 0;

    public static int fastNode(TreeNode tree) {
        if (tree == null) {
            return 0;
        }
        int leftDis = fastNode(tree.left);
        int rightDis = fastNode(tree.right);
        int disNow = Math.max(leftDis, rightDis) + 1;
        max = Math.max(max, leftDis + rightDis);
        return disNow;
    }

    public static int[] mergeArray(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) {
            return nums2;
        }
        if (nums2 == null || nums2.length == 0) {
            return nums1;
        }
        int[] numsNew = new int[nums1.length + nums2.length];
        int m = 0, n = 0, r = 0;
        while (m < nums1.length || n < nums2.length) {
            if (m >= nums1.length || nums1[m] > nums2[n]) {
                numsNew[r++] = nums2[n++];
            }else if (n >= nums2.length || nums1[m] < nums2[n]) {
                numsNew[r++] = nums1[m++];
            } else if (nums1[m] == nums2[n]) {
                numsNew[r++] = nums1[m++];
                n++;
            }
        }
        if (r<=numsNew.length) {
            int[] result = new int[r];
            result = numsNew.clone();
            return result;
        }
        return numsNew;
    }

    public static int temp = Integer.MIN_VALUE;
    public static int s;

    public static int findMaxK(TreeNode node, int k) {
        if (node == null) {
            return -1;
        }
        s = k;
        dfs(node);

        return temp;
    }

    private static void dfs(TreeNode node) {
        if (node.right != null) {
            dfs(node.right);
        };
        s--;
        if (s == 0) {
            temp = node.val;
            return;
        }
        if (node.left != null) {
            dfs(node.left);
        }
        return;
    }

    public static int[] findM(int[] nums, int m) {
        if (nums == null) {
            return null;
        }
        int l, r;
        int left = 0, right = nums.length -1;
        while (left < right) {
            int mid = (left + right)/2;
            if (nums[mid] < m) {
                left = mid + 1;
            } else if (nums[mid] >= m) {
                right = mid -1;
            }
        }
        l = nums[left] == m ? left : left +1;
        left = 0; right = nums.length -1;
        while (left < right) {
            int mid = (left + right)/2;
            if (nums[mid] <= m) {
                left = mid + 1;
            } else if (nums[mid] > m) {
                right = mid - 1;
            }
        }
        r = nums[right] == m ? right : right -1;
        int[] result = new int[r-l+1];
        int x =0;
        while (l<=r) {
            result[x++] = l++;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode t3 = new TreeNode(1);
        TreeNode t4 = new TreeNode(3);
        TreeNode t1 = new TreeNode(2, t3, t4);
        TreeNode t2 = new TreeNode(9);
        TreeNode root = new TreeNode(6, t1,t2);
        int[] nums = {5, 9, 8, 3, 2, 6, 8, 5, 6, 6, 9};
        String s = "102627";
        String p = "dss";
        String target = "VIV";
        int[] nums1 = {2, 3, 5, 8, 9};
        int[] nums2 = {5, 5, 5, 5,5,5};

        int[] result = findM(nums2, 5);
        System.out.println(new Gson().toJson(result));
    }
}
