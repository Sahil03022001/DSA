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
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        
        TreeNode targetNode = findNode(root, x);
        return checkCanWin(targetNode, n);
    }
    
    int count(TreeNode root){
        if(root == null){
            return 0;
        }
        return count(root.left) + count(root.right) + 1;
    }
    
    boolean checkCanWin(TreeNode root, int n){
        
        if(root == null){
            return false;
        }
        
        int countLeft = count(root.left);
        int countRight = count(root.right);
        int countParent = n - (countLeft + countRight + 1);
        
        if(countParent > countLeft + countRight || countLeft > countParent + countRight || countRight > countLeft + countParent){
            return true;
        }else{
            return false;
        }
    }
    
    TreeNode findNode(TreeNode root, int x){
        
        if(root == null){
            return null;
        }
        
        if(root.val == x){
            return root;
        }
        
        TreeNode filc = findNode(root.left, x);
        if(filc != null){
            return filc;
        }
        
        TreeNode firc = findNode(root.right, x);
        if(firc != null){
            return firc;
        }
        
        return null;
    }
}