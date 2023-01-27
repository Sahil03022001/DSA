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
    
    private TreeNode solve(int[] inorder, int isi, int iei, int[] postorder, int psi, int pei){
        
        if(isi > iei || psi > pei)return null;
        
        TreeNode root = new TreeNode(postorder[pei]);
        
        int cnt = 0;
        int val = root.val;
        int itr = isi;
        while(inorder[itr] != val){
            itr++;
            cnt++;
        }
        
        root.left = solve(inorder, isi, itr - 1, postorder, psi, psi + cnt - 1);
        root.right = solve(inorder, itr + 1, iei, postorder, psi + cnt, pei - 1);
        
        return root;
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode ans = solve(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
        return ans;
    }
}