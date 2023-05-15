/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int count=0;
    public int goodNodes(TreeNode root) {
    int max = root.val;
    good_node(root, max);
    return count;
    }
    private void good_node(TreeNode root, Integer max)
    {   
        if (root == null) return;
        if (root.val>=max) {
            this.count++;
            max = root.val;
        }
        good_node(root.left, max);
        good_node(root.right, max);
    }
}