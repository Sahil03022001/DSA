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
    
    private void solve(TreeNode root, List<Integer> ans){
        
        if(root == null)return;
        
        //call for left
        solve(root.left, ans);
        
        //call for right
        solve(root.right, ans);
        
        //add current value
        ans.add(root.val);
    }
    
    public List<Integer> postorderTraversal(TreeNode root) {
        
        List<Integer> ans = new ArrayList<>();
        solve(root, ans);
        return ans;
    }
}