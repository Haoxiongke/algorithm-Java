package LeetCode;

import util.TreeNode;

/**
 * L101_isSymmetric
 *
 * @author kehaoxiong
 * @date 2020/12/31
 */
public class L101_isSymmetric {
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        return help(root.left, root.right);

    }

    private static boolean help(TreeNode left, TreeNode right) {

        if (left == null && right == null) return true;
        else if (left == null || right == null) return false;

        if (left.val != right.val) return false;

        return help(left.left, right.right) && help(left.right, right.left);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
//        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);
//        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        System.out.println(isSymmetric(root));

    }
}
