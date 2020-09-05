package leet.treenode;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的前序、中序、后序遍历
 * @author zhangjinchun
 * @date 2020/9/5
 */
public class TraversalTreeNode {

    public static int[][] threeOrders(TreeNode root) {
        List<Integer> preList = new ArrayList<Integer>(),
                inList = new ArrayList<Integer>() ,
                postList = new ArrayList<Integer>();
        TreeNode cur = root;
        preOrder(cur, preList);
        cur = root;
        inOrder(cur, inList);
        cur = root;
        postOrder(cur, postList);

        int[] pre = new int[preList.size()];
        int[] in = new int[inList.size()];
        int[] post = new int[postList.size()];
        for (int i= 0; i < preList.size(); i++) {
            pre[i] = preList.get(i);
            in[i] = inList.get(i);
            post[i] = postList.get(i);
        }
        int[][] result = new int[3][preList.size()];
        result[0] = pre;
        result[1] = in;
        result[2] = post;
        return result;
    }

    private static void preOrder(TreeNode root, List<Integer> arrs) {
        if (root == null) {
            return;
        }
        arrs.add(root.val);
        preOrder(root.left, arrs);
        preOrder(root.right, arrs);
    }

    private static void inOrder(TreeNode root, List<Integer> arrs) {
        if (root == null) {
            return;
        }

        inOrder(root.left, arrs);
        arrs.add(root.val);
        inOrder(root.right, arrs);
    }

    private static void postOrder(TreeNode root, List<Integer> arrs) {
        if (root == null) {
            return;
        }

        postOrder(root.left, arrs);
        postOrder(root.right, arrs);
        arrs.add(root.val);
    }

    public static void main(String[] args) {
        TreeNode t3 = new TreeNode(1);
        TreeNode t4 = new TreeNode(3);
        TreeNode t1 = new TreeNode(2, t3, t4);
        TreeNode t2 = new TreeNode(9);
        TreeNode root = new TreeNode(6, t1,t2);

        int[][] result = threeOrders(root);
        System.out.println(new Gson().toJson(result));
    }
}
