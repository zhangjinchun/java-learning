package leet.listnode;

import com.google.gson.Gson;

/**
 * 剑指 Offer 18. 删除链表的节点
 * @author zhangjinchun
 * @date 2020/9/5
 */
public class RemoveNthFromEnd {
    /**
     * 先遍历出链表长度，再移动指针
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        ListNode p = head, q = head;
        int count = 0;
        while (p != null) {
            count++;
            p = p.next;
        }
        int i = count - n;
        if (i == 0) {
            return head.next;
        }

        while (i > 1) {
            q = q.next;
            i--;
        }
        q.next = q.next.next;
        return head;
    }

    /**
     * 双指针fa
     * @param head
     * @param k
     * @return
     */
    public static ListNode removeNthFromEnd2(ListNode head, int k) {
        ListNode former = head, latter = head;
        for(int i = 0; i < k; i++) {
            former = former.next;
        }
        if (former == null) {
            return head.next;
        }
        former = former.next;
        while(former != null) {
            former = former.next;
            latter = latter.next;
        }
        latter.next = latter.next.next;
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

        ListNode result = removeNthFromEnd2(nodeA, 1);
        System.out.println(new Gson().toJson(result));
    }
}
