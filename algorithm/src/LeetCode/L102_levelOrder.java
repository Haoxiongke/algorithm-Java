package LeetCode;

import util.ListNode;
import util.TreeNode;

import java.util.*;

/**
 * L102_levelOrder
 *
 * @author kehaoxiong
 * @date 2020/12/31
 */
public class L102_levelOrder {

    // 利用深度优先遍历，添加元素
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        DFS(root, 0, list);
        return list;
    }

    private static void DFS(TreeNode root, int level, List<List<Integer>> list) {
        if (root == null) return;
        if (list.size() <= level) list.add(new ArrayList<>());
        list.get(level).add(root.val);
        DFS(root.left, level + 1, list);
        DFS(root.right, level + 1, list);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(levelOrder(root));
    }
}
