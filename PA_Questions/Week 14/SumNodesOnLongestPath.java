public class SumNodesOnLongestPath {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    private static int maxLen = 0;
    private static int maxSum = 0;

    public static int sumOfLongRootToLeafPath(TreeNode root) {
        maxLen = 0;
        maxSum = 0;
        dfs(root, 0, 0);
        return maxSum;
    }

    private static void dfs(TreeNode node, int len, int sum) {
        if (node == null) return;
        sum += node.val;
        len++;

        if (node.left == null && node.right == null) {
            if (len > maxLen) {
                maxLen = len;
                maxSum = sum;
            } else if (len == maxLen) {
                maxSum = Math.max(maxSum, sum);
            }
            return;
        }

        dfs(node.left, len, sum);
        dfs(node.right, len, sum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.left.right.left = new TreeNode(6);

        System.out.println("Max Sum on Longest Path: " + sumOfLongRootToLeafPath(root)); // 13 (4->2->1->6)
    }
}
