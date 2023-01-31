/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    void solve(TreeNode root, StringBuilder sb){
        
        if(root == null){
            sb.append("null,");
            return;
        }
        
        sb.append(root.val + ",");
        
        solve(root.left, sb);
        solve(root.right, sb);
    }
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        solve(root, sb);
        return sb.toString();
    }

    
    // Decodes your encoded data to tree.
    int idx = 0;
    TreeNode solve(String[] input){
        
        String data = input[idx];
        idx++;
        
        if(idx == input.length)return null;
        
        if(data.equals("null"))return null;
        
        int val = Integer.parseInt(data);
        TreeNode root = new TreeNode(val);
        
        root.left = solve(input);
        root.right = solve(input);
        
        return root;
    }
    public TreeNode deserialize(String data) {
        
        String[] input = data.split(",");
        TreeNode root = solve(input);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));