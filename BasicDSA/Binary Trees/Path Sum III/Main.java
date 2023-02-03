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
    
    static int cnt;
    private void helper(TreeNode root, int targetSum, Map<Long, Integer> map, long sum){
        
        if(root == null){
            return;
        }
        
        sum += root.val;
        
        if(sum == targetSum)cnt++;
        if(map.containsKey(sum - targetSum))cnt += map.get(sum - targetSum);
    
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        helper(root.left, targetSum, map, sum);
        helper(root.right, targetSum, map, sum);
        map.put(sum, map.get(sum) - 1);
        if(map.get(sum) == 0){
            map.remove(sum);
        }
        
    }
    
    public int pathSum(TreeNode root, int targetSum) {
        cnt = 0;
        Map<Long, Integer> map = new HashMap<>();
        helper(root, targetSum, map, 0);
        return cnt;
    }
}