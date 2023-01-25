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
    
    private void solve(TreeNode root, List<String> ans, StringBuilder temp){
        
        if(root == null)return;
        
        int len = temp.length();
        temp.append(root.val);
        
        if(root.left == null && root.right == null){
            ans.add(temp.toString());
        }else{
            temp.append("->");
            if(root.left != null)
                solve(root.left, ans, temp);
            if(root.right != null)
                solve(root.right, ans, temp);
        }
        
        temp.setLength(len);
    }
    
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        solve(root, ans, new StringBuilder());
        return ans;
    }
}