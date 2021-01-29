package LeetCode;

import util.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * L652_findDuplicateSubtrees
 *
 * @author kehaoxiong
 * @date 2021/1/21
 */
public class L652_findDuplicateSubtrees {

    // 记录所有子树以及出现的次数
    static HashMap<String, Integer> memo = new HashMap<>();
    // 记录重复的子树根节点
    static LinkedList<TreeNode> res = new LinkedList<>();

    public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return res;
    }

    private static String traverse(TreeNode root) {

        if (root == null) return "#";

        String left = traverse(root.left);
        String right = traverse(root.right);
        String subString = left + "," + right + "," + root.val;

        int num = memo.getOrDefault(subString, 0);

        if (num == 1)
            res.add(root);

        memo.put(subString, num + 1);

        return subString;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.left.left = new TreeNode(4);
        findDuplicateSubtrees(root).forEach(s -> System.out.println(s.val));
    }
}
