package leet.treenode;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 剑指 Offer 32 - III. 从上到下打印二叉树 III
 * 之字形遍历二叉树
 *
 * @author zhangjinchun
 * @date 2020/9/6
 */
public class LevelOrder {

    /**
     * 层序遍历 + 双端队列
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> result = new ArrayList<>();
        int flag = 0;
        while (!queue.isEmpty()) {
            LinkedList<Integer> tmp = new LinkedList<>();
            for(int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if(result.size() % 2 == 0) {
                    tmp.addLast(node.val); // 偶数层 -> 队列头部
                } else {
                    tmp.addFirst(node.val); // 奇数层 -> 队列尾部
                }
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(tmp);
        }
        return result;
    }

    /**
     * 层序遍历 + 队列倒序
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root != null) {
            queue.add(root);
        }
        while(!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for(int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
            if(res.size() % 2 == 1) {
                Collections.reverse(tmp);
            }
            res.add(tmp);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode t3 = new TreeNode(4);
        TreeNode t1 = new TreeNode(2, t3, null);
        TreeNode t5 = new TreeNode(5);
        TreeNode t2 = new TreeNode(3, null, t5);
        TreeNode root = new TreeNode(1, t1, t2);

        List<List<Integer>> result = levelOrder(root);
        System.out.println(new Gson().toJson(result));
    }
}
