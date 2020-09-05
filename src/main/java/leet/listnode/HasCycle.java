package leet.listnode;

import com.google.gson.Gson;

/**
 * 141. 环形链表
 * @author zhangjinchun
 * @date 2020/9/5
 */
public class HasCycle {

    /**
     * 快慢指针法
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode p = head, q = head.next;
        while (p != null && q != null) {
            if (p == q) {
                return true;
            }
            if (q.next == null) {
                return false;
            }
            q = q.next.next;
            p = p.next;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode nodeA = new ListNode(1);
        ListNode nodeB = new ListNode(2);
        ListNode nodeC = new ListNode(3);
        nodeA.next = nodeB;
        nodeB.next = nodeC;
        nodeC.next = nodeB;

        boolean result = hasCycle(nodeA);
        System.out.println(new Gson().toJson(result));
    }
}
