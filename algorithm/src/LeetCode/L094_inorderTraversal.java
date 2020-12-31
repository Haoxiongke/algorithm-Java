package LeetCode;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * L094_inorderTraversal
 * 树的中序遍历
 *
 * @author kehaoxiong
 * @date 2020/12/28
 */
public class L094_inorderTraversal {

    static List<Integer> list = new ArrayList<>();

    // 递归版本
    public static List<Integer> inorderTraversal(TreeNode root) {

        if (root == null)
            return null;

        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
        return list;
    }

    // 利用栈
    public static List<Integer> inorderTraversal2(TreeNode root) {

        if (root == null)
            return null;

        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }

    // 假设当前遍历到的节点为x,将x的左子树最右边的节点的右孩子指向x，这样在左子树遍历完成后我们通过这个指向走回了x
    public static List<Integer> inorderTraversal3(TreeNode root) {

        TreeNode predecessor = null;

        while (root != null) {
            if (root.left != null) {
                predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }

                if (predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                } else {
                    list.add(root.val);
                    predecessor.right = null;
                    root = root.right;
                }
            } else {
                list.add(root.val);
                root = root.right;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
//        System.out.println(inorderTraversal(root));
//        System.out.println(inorderTraversal2(root));
        System.out.println(inorderTraversal3(root));

    }
}
