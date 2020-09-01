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

    public static class DoubleList {
        private Node head, tail;
        private int size;
        public void addFirst(Node node) {
            if (head == null) {
                head = tail = node;
            } else {
                Node n = head;
                n.prev = node;
                node.next = n;
                head = node;
            }
            size++;
        }
        public void remove(Node node) {
            if (head == node && tail == node) {
                head = null;
                tail = null;
            } else if (tail == node) {
                node.prev.next = null;
                tail = node.prev;
            } else if (head == node) {
                node.next.prev = null;
                head = node.next;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
            size--;
        }
        public Node removeLast() {
            Node node = tail;
            remove(tail);
            return node;
        }
        public int size() {
            return size;
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
