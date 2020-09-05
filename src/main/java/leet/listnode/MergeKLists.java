package leet.listnode;

import com.google.gson.Gson;

/**
 * 23. 合并K个升序链表
 * @author zhangjinchun
 * @date 2020/9/5
 */
public class MergeKLists {

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) {
            return null;
        }
        int len = lists.length;
        if (len == 0) {
            return null;
        }
        if (len == 1) {
            return lists[0];
        }
        ListNode mergeNode = new ListNode();
        mergeNode.next = lists[0];
        for (int i = 1; i < len ; i++){
            if (lists[i] == null) {
                continue;
            }
            generateMergeNode(mergeNode.next, lists[i], mergeNode);
        }
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

        ListNode nodeW = new ListNode(3);
        ListNode nodeY = new ListNode(12);
        nodeW.next = nodeY;

        ListNode[] lists = new ListNode[3];
        lists[0] = nodeA;
        lists[1] = node1;
        lists[2] = nodeW;

        ListNode result = mergeKLists(lists);
        System.out.println(new Gson().toJson(result));
    }
}
