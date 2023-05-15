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
    public boolean isValidBST(TreeNode root) {
       if (root.left==null && root.right == null) return true; 
return valid_check(root, null, null);

}
private boolean valid_check(TreeNode root, Integer low, Integer high) {
        if (root == null) {
            return true;
        }
        if ((low != null && Integer.valueOf(root.val) <= low) || (high != null && Integer.valueOf(root.val)  >= high)) {
            return false;
        }

        return valid_check(root.right, root.val, high) && valid_check(root.left, low, root.val);
}
}