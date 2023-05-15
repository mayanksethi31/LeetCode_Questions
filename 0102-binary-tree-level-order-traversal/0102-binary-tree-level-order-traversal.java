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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> fin = new ArrayList<>();
        if (root == null ) return fin;

        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.addLast(root);

        int size;
        while (!q.isEmpty())
        {
        size = q.size();
        TreeNode check; 
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<size; i++)
        {
            check = q.removeFirst();
            if (check.left!=null) q.addLast(check.left);
            if (check.right!=null) q.addLast(check.right);
            result.add(check.val);
        }
        fin.add(result);
        }
        return fin;
    }
}