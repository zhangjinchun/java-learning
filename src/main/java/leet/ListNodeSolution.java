package leet;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangjinchun
 * @date 2020/9/5
 */
public class ListNodeSolution {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
//        LinkedList<Integer> stack = new LinkedList<>();
//        while (head != null) {
//            stack.add(head.val);
//            head = head.next;
//        }
//        ListNode res = new ListNode(stack.pollLast());
//        ListNode result = res;
//        while (!stack.isEmpty()) {
//            res.next = new ListNode(stack.pollLast());
//            res = res.next;
//        }
//        return result;

        ListNode prev = null, cur = head, temp = null;
        while (cur != null) {
            temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode nodeA = new ListNode(1);
        ListNode nodeB = new ListNode(2);
        ListNode nodeC = new ListNode(3);
        nodeA.next = nodeB;
        nodeB.next = nodeC;

        ListNode result = reverseList(nodeA);
        System.out.println(new Gson().toJson(result));
    }
}
