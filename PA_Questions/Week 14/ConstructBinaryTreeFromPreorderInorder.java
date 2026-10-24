import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderInorder {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    private static int preorderIndex = 0;
    private static Map<Integer, Integer> inorderIndexMap = new HashMap<>();

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        inorderIndexMap.clear();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        return helper(preorder, 0, inorder.length - 1);
    }

    private static TreeNode helper(int[] preorder, int left, int right) {
        if (left > right) return null;
        int rootVal = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootVal);
        int index = inorderIndexMap.get(rootVal);

        root.left = helper(preorder, left, index - 1);
        root.right = helper(preorder, index + 1, right);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode root = buildTree(preorder, inorder);
        System.out.println("Root: " + root.val);
        System.out.println("Left: " + root.left.val);
        System.out.println("Right: " + root.right.val);
    }
}
