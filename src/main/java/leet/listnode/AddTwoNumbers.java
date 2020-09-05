package leet.listnode;

import com.google.gson.Gson;

/**
 * 02.05. 链表求和
 *
 * @author zhangjinchun
 * @date 2020/9/5
 */
public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode l3 = new ListNode(0);
        ListNode p = l3;
        while (l1 != null || l2 != null || carry > 0) {
            int sum = carry;
            sum += l1 == null ? 0 : l1.val;
            sum += l2 == null ? 0 : l2.val;

            p.next = new ListNode(sum % 10);
            p = p.next;
            carry = sum / 10;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        return l3.next;
    }

    public static void main(String[] args) {
        ListNode nodeA = new ListNode(1);
        ListNode nodeB = new ListNode(2);
//        ListNode nodeC = new ListNode(3);
        nodeA.next = nodeB;
//        nodeB.next = nodeC;

        ListNode node1 = new ListNode(7);
        ListNode node2 = new ListNode(8);
        ListNode node3 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;

        ListNode result = addTwoNumbers(nodeA, node1);
        System.out.println(new Gson().toJson(result));
    }
}
