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
    
    private TreeNode solve(int[] po, int psi, int pei, int[] io, int isi, int iei){
        
        if(psi > pei)return null;
        if(isi > iei)return null;
        
        TreeNode root = new TreeNode(po[psi]);
        
        int cnt = 0;
        int itr = isi;
        int val = root.val;
        while(io[itr] != val){
            cnt++;
            itr++;
        }
        
        root.left = solve(po, psi + 1, psi + cnt, io, isi, itr - 1);
        root.right = solve(po, psi + cnt + 1, pei, io, itr + 1, iei);
        
        return root;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = solve(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        return root;
    }
}