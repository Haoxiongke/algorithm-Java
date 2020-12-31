package LeetCode;

import util.TreeNode;

import java.util.Stack;

/**
 * L098_isValidBST
 * 参考https://leetcode.wang/leetCode-98-Validate-Binary-Search-Tree.html
 *
 * @author kehaoxiong
 * @date 2020/12/30
 */
public class L098_isValidBST {
    // 利用中序遍历递归解决
    private static long pre = Long.MIN_VALUE;

    public static boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        if (!isValidBST(root.left)) return false;
        if (root.val <= pre) return false;
        pre = root.val;
        return isValidBST(root.right);
    }

    // 利用中序遍历非递归解决
    public static boolean isValidBST2(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();

        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre != null && root.val <= pre.val) return false;
            pre = root;
            root = root.right;
        }
        return true;
    }

    // 利用区间的思路，根节点的区间为负无穷到正无穷
    // 左节点的上限为父节点的值，右节点的下限为父节点的值
    public static boolean isValidBST3(TreeNode root) {
        Long minValue = Long.MIN_VALUE;
        Long maxValue = Long.MAX_VALUE;
        return isValid(root, minValue, maxValue);

    }

    private static boolean isValid(TreeNode root, Long minValue, Long maxValue) {
        if (root == null) return true;

        if (root.val <= minValue) return false;
        if (root.val >= maxValue) return false;
        return isValid(root.left, minValue, (long) root.val) && isValid((root.right), (long) root.val, maxValue);
    }

    // 直接利用包装类
    public static boolean isValidBST4(TreeNode root) {
        return isValid2(root, null, null);
    }

    private static boolean isValid2(TreeNode root, Integer minValue, Integer maxValue) {
        if (root == null) return true;

        if (minValue != null && root.val <= minValue) return false;
        if (maxValue != null && root.val >= maxValue) return false;
        return isValid2(root.left, minValue, root.val) && isValid2(root.right, root.val, maxValue);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(-2147483648);
//        root.left = new TreeNode(1);
//        root.left.right=new TreeNode(3);
//        root.right = new TreeNode(3);
//        root.right.left = new TreeNode(3);
//        root.right.right = new TreeNode(6);
        System.out.println(isValidBST4(root));
    }
}
