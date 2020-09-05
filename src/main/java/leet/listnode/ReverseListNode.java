package leet.listnode;

import com.google.gson.Gson;

import java.util.LinkedList;

/**
 * 206. 反转链表
 * @author zhangjinchun
 * @date 2020/9/5
 */
public class ReverseListNode {

    /**
     * 原地反转，空间复杂度为O(1)
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null, cur = head, temp = null;
        while (cur != null) {
            temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }

    /**
     * 递归解法
     * @param head
     * @return
     */
    public static ListNode reverseListB(ListNode head) {
        //递归终止条件是当前为空，或者下一个节点为空
        if (head == null || head.next == null) {
            return head;
        }

        //这里的cur就是最后一个节点
        ListNode cur = reverseListB(head.next);
        //如果链表是 1->2->3->4->5，那么此时的cur就是5
        //而head是4，head的下一个是5，下下一个是空
        //所以head.next.next 就是5->4
        head.next.next = head;
        //防止链表循环，需要将head.next设置为空
        head.next = null;
        //每层递归函数都返回cur，也就是最后一个节点
        return cur;
    }

    /**
     * 利用栈的额外空间，空间复杂度O(n)
     * @param head
     * @return
     */
    public static ListNode reverseListA(ListNode head) {
        if (head == null) {
            return null;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        while (head != null) {
            stack.add(head.val);
            head = head.next;
        }
        ListNode res = new ListNode(stack.pollLast());
        ListNode result = res;
        while (!stack.isEmpty()) {
            res.next = new ListNode(stack.pollLast());
            res = res.next;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode nodeA = new ListNode(1);
        ListNode nodeB = new ListNode(2);
        ListNode nodeC = new ListNode(3);
        nodeA.next = nodeB;
        nodeB.next = nodeC;

        ListNode result = reverseListB(nodeA);
        System.out.println(new Gson().toJson(result));
    }
}
