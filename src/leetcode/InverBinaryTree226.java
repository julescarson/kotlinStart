package leetcode;
import java.util.LinkedList;

public class InverBinaryTree226 {
      public class TreeNode {
      int val;
     TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public TreeNode invertTree(TreeNode root) {


          /* == Recursive Version
            if (root == null) return root;
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            invertTree(root.left);
            invertTree(root.right);
            return root;
           */
        if (root == null) return null;
        LinkedList<TreeNode> treeNodes = new LinkedList<TreeNode>();
        treeNodes.add(root);

        //node with unswapped children added to treeNodes, not remove until attempt at swap (even on nulls)
        while (!treeNodes.isEmpty()) {
            TreeNode curr = treeNodes.poll();
            if (curr.left != null) {
                treeNodes.add(curr.left);
            }
            if (curr.right != null) {
                treeNodes.add(curr.right);
            }
            TreeNode temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;
        }
        return root;
    }
}
