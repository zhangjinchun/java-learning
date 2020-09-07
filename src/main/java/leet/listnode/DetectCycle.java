package leet.listnode;

import com.google.gson.Gson;

/**
 * 142. 环形链表 II
 * @author zhangjinchun
 * @date 2020/9/5
 */
public class DetectCycle {
    /**
     * 双指针法
     * @param head
     * @return
     */
    public static ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode f = head, s = head;
        while (f != null && f.next != null) {
            f = f.next.next;
            s = s.next;
            if (f == s) {
                break;
            }
        }
        if (f == null || f.next == null) {
            return null;
        }
        f = head;
        while (f != s) {
            f = f.next;
            s = s.next;
        }
        return f;
    }

    public static void main(String[] args) {
        ListNode nodeA = new ListNode(1);
        ListNode nodeB = new ListNode(2);
        ListNode nodeC = new ListNode(3);
        nodeA.next = nodeB;
        nodeB.next = nodeC;
        nodeC.next = nodeB;

        ListNode result = detectCycle(nodeA);
        System.out.println(new Gson().toJson(result.val));
    }
}
