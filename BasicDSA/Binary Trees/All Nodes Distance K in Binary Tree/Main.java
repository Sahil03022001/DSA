/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    //mapping child to parents in hashmap
    private void findParents(TreeNode root, Map<TreeNode, TreeNode> map){
        
        if(root == null)return;
        
        if(root.left != null){
            map.put(root.left, root);
        }
        
        if(root.right != null){
            map.put(root.right, root);
        }
        
        findParents(root.left, map);
        findParents(root.right, map);
    }
    
    //doing level order traversal to find the Answer node values
    private void levelOrderTraversal(TreeNode root, int k, Map<TreeNode, TreeNode> map, List<Integer> ans){
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        Set<TreeNode> set = new HashSet<>();
        set.add(root);
        
        while(q.size() > 0){
            int size = q.size();
            
            if(k == 0){
                while(q.size() > 0){
                    ans.add(q.poll().val);
                }
                return;
            }
            
            while(size > 0){
                TreeNode node = q.poll();
                
                if(node.left != null && !set.contains(node.left)){
                    set.add(node.left);
                    q.add(node.left);
                }
                
                if(node.right != null && !set.contains(node.right)){
                    set.add(node.right);
                    q.add(node.right);
                }
                
                if(map.containsKey(node) && !set.contains(map.get(node))){
                    set.add(map.get(node));
                    q.add(map.get(node));
                }
                
                size--;
            }
            
            k--;
        }
    }
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        Map<TreeNode, TreeNode> map = new HashMap<>();
        findParents(root, map);
        
        List<Integer> ans = new ArrayList<>();
        levelOrderTraversal(target, k, map, ans);
        return ans;
    }
}