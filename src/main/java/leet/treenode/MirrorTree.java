package leet.treenode;

import com.google.gson.Gson;

import java.util.List;

/**
 * 剑指 Offer 27. 二叉树的镜像
 * @author zhangjinchun
 * @date 2020/9/6
 */
public class MirrorTree {

    public static TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirrorTree(root.left);
        mirrorTree(root.right);

        return root;
    }

    public static void main(String[] args) {
        TreeNode t3 = new TreeNode(4);
        TreeNode t1 = new TreeNode(2, t3, null);
        TreeNode t5 = new TreeNode(5);
        TreeNode t2 = new TreeNode(3, null, t5);
        TreeNode root = new TreeNode(1, t1, t2);

        TreeNode result = mirrorTree(root);
        System.out.println(new Gson().toJson(result));
    }
}
