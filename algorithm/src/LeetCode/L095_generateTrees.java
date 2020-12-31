package LeetCode;

import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * L095_generateTrees
 *
 * @author kehaoxiong
 * @date 2020/12/29
 */
public class L095_generateTrees {

    // 方法一：利用递归
    public static List<TreeNode> generateTrees(int n) {
        if (n == 0)
            return new LinkedList<TreeNode>();

        return dfs(1, n);
    }

    // 深度优先
    private static List<TreeNode> dfs(int lo, int hi) {
        List<TreeNode> ret = new LinkedList<>();
        if (lo > hi) {
            ret.add(null);
            return ret;
        }
        for (int i = lo; i <= hi; i++) {
            List<TreeNode> left = dfs(lo, i - 1);
            List<TreeNode> right = dfs(i + 1, hi);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    ret.add(root);
                }
            }
        }
        return ret;
    }

    // 方法二：利用动态规划保存1...len 中的所有情况
    public static List<TreeNode> generateTrees2(int n) {

        List<TreeNode>[] dp = new ArrayList[n + 1];
        dp[0] = new ArrayList<TreeNode>();
        if (n == 0) return dp[0];
        dp[0].add(null);

        // 长度为1...n 利用dp保存所有可能
        for (int len = 1; len <= n; len++) {
            dp[len] = new ArrayList<>();
            for (int root = 1; root <= len; root++) {
                int left = root - 1;
                int right = len - root;
                for (TreeNode leftNode : dp[left]) {
                    for (TreeNode rightNode : dp[right]) {
                        TreeNode treeRoot = new TreeNode(root);
                        treeRoot.left = leftNode;
                        // 克隆右子树加上偏差
                        treeRoot.right = clone(rightNode, root);
                        dp[len].add(treeRoot);
                    }
                }
            }
        }
        return dp[n];
    }

    // 方法三：对于新加入的数字，只能在原来的基础上要么为根节点，要么为根节点的右孩子或者右孩子的右孩子
    // 思想也是利用动态规划，但是只保存上一个n的状态
    public static List<TreeNode> generateTrees3(int n) {

        List<TreeNode> pre = new LinkedList<>();
        if (n == 0) return pre;
        pre.add(null);

        // 每次增加一个数字
        for (int i = 1; i <= n; i++) {
            List<TreeNode> cur = new LinkedList<>();

            // 遍历之前的所有解
            for (TreeNode root : pre) {
                // 第一种情况，将节点插入到根节点中
                TreeNode insert = new TreeNode(i);
                insert.left = root;
                cur.add(insert);
                // 第二种情况，插入到原来根节点的右孩子或者右孩子的右孩子，遍历插入
                // 最多找n次孩子
                for (int j = 1; j < n; j++) {
                    TreeNode root_copy = treeCopy(root);  // 复制当前树
                    TreeNode right = root_copy;

                    int k = 1;
                    // 移动到当前要插入的位置
                    while (right != null && k < j) {
                        right = right.right;
                        k++;
                    }
                    // 代表右子树没有达到n，就已经到null了。直接进行下一轮
                    if (right == null) break;
                    TreeNode rightTree = right.right;
                    insert = new TreeNode(i);
                    right.right = insert;
                    insert.left = rightTree;
                    cur.add(root_copy);
                }
            }
            pre = cur;
        }
        return pre;
    }

    private static TreeNode clone(TreeNode Node, int offset) {
        if (Node == null)
            return null;

        TreeNode treeNode = new TreeNode(Node.val + offset);
        treeNode.left = clone(Node.left, offset);
        treeNode.right = clone(Node.right, offset);
        return treeNode;
    }

    private static TreeNode treeCopy(TreeNode root) {
        if (root == null) return root;
        TreeNode treeRoot = new TreeNode(root.val);
        treeRoot.left = treeCopy(root.left);
        treeRoot.right = treeCopy(root.right);
        return treeRoot;
    }


    public static void main(String[] args) {
        System.out.println(generateTrees3(5).size());
    }
}
