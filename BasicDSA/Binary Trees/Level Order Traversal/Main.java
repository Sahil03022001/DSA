class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> ans = new ArrayList<>();
        
        if(root == null){
            return ans;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            
            List<Integer> list = new ArrayList<>();
            
            while(size > 0){
                TreeNode node = q.poll();
                
                list.add(node.val);
                
                if(node.left != null)q.offer(node.left);
                if(node.right != null)q.offer(node.right);
                
                size--;
            }
            
            ans.add(list);
        }
        
        return ans;
    }
}