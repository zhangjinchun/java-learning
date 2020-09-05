package leet.listnode;

import com.google.gson.Gson;

/**
 * 21. 合并两个有序链表
 * @author zhangjinchun
 * @date 2020/9/5
 */
public class MergeTwoLists {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode mergeNode = new ListNode();
        generateMergeNode(l1, l2, mergeNode);
        return mergeNode.next;
    }

    static void generateMergeNode(ListNode l1, ListNode l2, ListNode mergeList) {
        if (l1 == null) {
            mergeList.next = l2;
            return;
        }
        if (l2 == null) {
            mergeList.next = l1;
            return;
        }
        if (l1.val <= l2.val) {
            mergeList.next = l1;
            generateMergeNode(l1.next, l2, mergeList.next);
        } else {
            mergeList.next = l2;
            generateMergeNode(l1, l2.next, mergeList.next);
        }
    }

    public static void main(String[] args) {
        ListNode nodeA = new ListNode(1);
        ListNode nodeB = new ListNode(3);
        ListNode nodeC = new ListNode(4);
        ListNode nodeD = new ListNode(8);
        ListNode nodeE = new ListNode(9);
        nodeA.next = nodeB;
        nodeB.next = nodeC;
        nodeC.next = nodeD;
        nodeD.next = nodeE;

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(7);
        ListNode node3 = new ListNode(10);
        node1.next = node2;
        node2.next = node3;


        ListNode result = mergeTwoLists(nodeA, node1);
        System.out.println(new Gson().toJson(result));
    }
}
