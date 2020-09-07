package leet.listnode;

import com.google.gson.Gson;

import java.util.List;

/**
 * 92. 反转链表 II
 * @author zhangjinchun
 * @date 2020/9/6
 */
public class ReverseBetween {
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        int i = 1;
        ListNode prev = null, cur = head;
        ListNode beginPre = null, begin = null;
        while(i <= n) {
            i++;
            if (i == m + 1) {
                beginPre = prev;
                begin = cur;
            }
            if (i <= m) {
                prev = cur;
                cur = cur.next;
            } else {
                ListNode temp = cur.next;
                cur.next = prev;
                prev = cur;
                cur = temp;
            }
        }
        if (m > 1) {
            beginPre.next = prev;
        }
        begin.next = cur;

        if (m == 1) {
            return prev;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode nodeA = new ListNode(1);
        ListNode nodeB = new ListNode(2);
        ListNode nodeC = new ListNode(3);
        ListNode nodeD = new ListNode(4);
        nodeA.next = nodeB;
        nodeB.next = nodeC;
        nodeC.next = nodeD;

        ListNode result = reverseBetween(nodeA, 2, 3);
        System.out.println(new Gson().toJson(result));
    }
}
