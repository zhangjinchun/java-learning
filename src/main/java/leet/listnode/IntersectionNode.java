package leet.listnode;

import com.google.gson.Gson;

/**
 * 160. 相交链表
 * @author zhangjinchun
 * @date 2020/9/5
 */
public class IntersectionNode {

    /**
     * 先计算距离，再双指针法
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode tempA = headA, tempB = headB;
        int lenA = 0, lenB = 0;
        while (tempA != null) {
            lenA++;
            tempA = tempA.next;
        }

        while (tempB != null) {
            lenB++;
            tempB = tempB.next;
        }
        int diff = 0;
        if (lenA > lenB) {
            diff = lenA - lenB;
            while (diff > 0) {
                headA = headA.next;
                diff--;
            }
        }else if (lenA < lenB) {
            diff = lenB - lenA;
            while (diff > 0) {
                headB = headB.next;
                diff--;
            }
        }
        ListNode result = null;
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return result;
    }

    public static ListNode getIntersectionNodeA(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while(pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    public static void main(String[] args) {
        ListNode nodeA = new ListNode(4);
        ListNode nodeB = new ListNode(1);
        ListNode nodeC = new ListNode(8);
        ListNode nodeD = new ListNode(4);
        ListNode nodeE = new ListNode(5);
        nodeA.next = nodeB;
        nodeB.next = nodeC;
        nodeC.next = nodeD;
        nodeD.next = nodeE;

        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = nodeC;


        ListNode result = getIntersectionNodeA(nodeA, node1);
        System.out.println(new Gson().toJson(result));
    }
}
