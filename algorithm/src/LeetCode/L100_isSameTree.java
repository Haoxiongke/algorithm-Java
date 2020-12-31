package LeetCode;

import util.TreeNode;

/**
 * L100_isSameTree
 *
 * @author kehaoxiong
 * @date 2020/12/30
 */
public class L100_isSameTree {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        else if (p == null || q == null) return false;

        if (!isSameTree(p.left, q.left)) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {

    }
}
