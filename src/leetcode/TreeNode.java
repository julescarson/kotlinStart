package leetcode;

public class TreeNode {
    int val;
    InverBinaryTree226.TreeNode left;
    InverBinaryTree226.TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, InverBinaryTree226.TreeNode left, InverBinaryTree226.TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
