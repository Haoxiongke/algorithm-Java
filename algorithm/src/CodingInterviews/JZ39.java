package CodingInterviews;

import util.TreeNode;

/**
 * 判断一棵树是否为平衡树，左右子树相差高度不超过1
 */
public class JZ39 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        System.out.println(IsBalanced_Solution(root));
    }

    /**
     * 判断一棵树是否为平衡树
     *
     * @param root 根结点
     * @return true 平衡树 false 非平衡树
     */
    public static boolean IsBalanced_Solution(TreeNode root) {

        return getDepth(root) != -1;
    }

    /**
     * @param root 树的根结点
     * @return 若平衡树，返回最大深度了;非平衡树，返回-1
     */
    private static int getDepth(TreeNode root) {
        if (root == null)
            return 0;

        int left = getDepth(root.left);
        if (left == -1) return -1; // 如果左子树为非平衡树，则整棵树为非平衡树
        int right = getDepth(root.right);
        if (right == -1) return -1; // 如果右子树为非平衡树，则整棵树为非平衡树
        return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right); // 如果左右子树为平衡树，则树的深度+1
    }
}
