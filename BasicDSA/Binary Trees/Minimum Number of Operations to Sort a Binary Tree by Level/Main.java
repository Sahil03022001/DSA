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
    public int minimumOperations(TreeNode root) {
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int res = 0;
        while(q.size() > 0){
            int size = q.size();
            int[] arr = new int[size];
            int k = 0;
            while(size-- > 0){
                TreeNode node = q.poll();
                arr[k++] = node.val;
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            res += minSwaps(arr);
        }
        
        return res;
    }
    
    //pair class for storing number and index pair
    class Pair {
    int num;
    int idx;
    
    Pair(int n, int i){
        num = n;
        idx = i;
    }
}
    
    public int minSwaps(int nums[])
    {
        // Code here
        int n = nums.length;
        List<Pair> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            Pair p = new Pair(nums[i], i);
            list.add(p);
        }
        
        Collections.sort(list, (a, b) -> a.num - b.num);
        
        int cnt = 0;
        for(int i = 0; i < n; i++){
            if(i == list.get(i).idx) continue;
            swap(list, i);
            cnt++;
            i--;
        }
        
        return cnt;
    }
    
    void swap(List<Pair> list, int i){
        Pair p = list.get(i);
        int j = p.idx;
        Pair temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}