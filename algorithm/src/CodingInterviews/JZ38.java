package CodingInterviews;

import util.TreeNode;

public class JZ38 {

    public static void main(String[] args) {

    }

    public static int TreeDepth(TreeNode root) {
        if (root == null)
            return 0;

        int leftDepth = 1 + TreeDepth(root.left);
        int rightDepth = 1 + TreeDepth(root.right);
        return Math.max(leftDepth, rightDepth);
    }
}
