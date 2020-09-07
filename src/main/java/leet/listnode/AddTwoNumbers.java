package leet.listnode;

import com.google.gson.Gson;

import java.util.Stack;

/**
 * 02.05. 链表求和
 *
 * @author zhangjinchun
 * @date 2020/9/5
 */
public class AddTwoNumbers {

    /**
     * 反向链表相加
     * @param l1
     * @param l2
     * @return
     */
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

    /**
     * 正向链表相加，先用栈接收链表数据
     * @param head1
     * @param head2
     * @return
     */
    public static ListNode addInList(ListNode head1, ListNode head2) {
        //定义两个栈，用来存放两个链表的元素，刚好其结构特性符合相加的步骤
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        //往栈里面添加元素
        ListNode node1 = head1;
        ListNode node2 = head2;
        while (node1 != null) {
            stack1.add(node1.val);
            node1 = node1.next;
        }
        while (node2 != null) {
            stack2.add(node2.val);
            node2 = node2.next;
        }
        //开始相加
        int carry = 0;
        ListNode node = new ListNode(0);
        ListNode result = node;
        while (!stack1.empty() || !stack2.empty() || carry != 0) {
            int a = 0;
            int b = 0;
            if (!stack1.empty()) {
                a = stack1.pop();
            }
            if (!stack2.empty()) {
                b = stack2.pop();
            }
            int sum = a + b + carry;
            int num = sum % 10;
            carry = sum / 10;
            ListNode nodeNum = new ListNode(num);
            node.next = nodeNum;
            node = node.next;
        }
        // 反转链表
        result = result.next;
        ListNode pre = result;
        ListNode next = null;
        while (result != null) {
            pre = result.next;
            result.next = next;
            next = result;
            result = pre;
        }
        return next;
    }

    public static void main(String[] args) {
        ListNode nodeA = new ListNode(3);
        ListNode nodeB = new ListNode(2);
        ListNode nodeC = new ListNode(3);
        nodeA.next = nodeB;
        nodeB.next = nodeC;

        ListNode node1 = new ListNode(7);
        ListNode node2 = new ListNode(8);
        ListNode node3 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;

        ListNode result = addInList(nodeA, node1);
        System.out.println(new Gson().toJson(result));
    }
}
