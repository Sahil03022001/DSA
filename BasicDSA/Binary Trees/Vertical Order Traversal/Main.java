import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;
import java.lang.*;

class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class Pair implements Comparable<Pair> {
    
    int level;
    TreeNode node;
    
    Pair(TreeNode node, int level){
        this.node = node;
        this.level = level;
    }
    
    @Override
    public int compareTo(Pair o){
        if(this.level == o.level){
            return this.node.data - o.node.data;
        }
        
        return this.level - o.level;
    }
}

class Solution {
    
    static int minLevel = 0;
    static int maxLevel = 0;
    private void findWidthOfTree(TreeNode root, int curLevel){
        
        if(root == null)return;
        
        findWidthOfTree(root.left, curLevel - 1);
        findWidthOfTree(root.right, curLevel + 1);
        
        minLevel = Math.min(minLevel, curLevel);
        maxLevel = Math.max(maxLevel, curLevel);
    }
    
    public List<List<Integer>> VerticalTraversal(TreeNode root) {
        
        minLevel = 0;
        maxLevel = 0;
        findWidthOfTree(root, 0);
        int width = maxLevel - minLevel;
        int numberOfLevels = width + 1;
        
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < numberOfLevels; i++){
            ans.add(new ArrayList<>());
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(root, -minLevel));
        
        while(pq.size() > 0){
            int size = pq.size();
            
            PriorityQueue<Pair> cq = new PriorityQueue<>();
            while(size > 0){
                Pair curPair = pq.poll();
                
                ans.get(curPair.level).add(curPair.node.data);
                
                if(curPair.node.left != null)cq.add(new Pair(curPair.node.left, curPair.level - 1));
                if(curPair.node.right != null)cq.add(new Pair(curPair.node.right, curPair.level + 1));
                
                size--;
            }
            
            pq = cq;
        }
        
        return ans;
    }
}

class Main {

    static TreeNode buildTree(String str) {
        if(str.length()==0 || str.charAt(0)=='N')
            return null;

        String ip[] = str.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(ip[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            TreeNode currNode = queue.peek();
            queue.remove();
            String currVal = ip[i];
            if(!currVal.equals("N")) {
                currNode.left = new TreeNode(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }
            i++;
            if(i >= ip.length)
                break;
            currVal = ip[i];
            if(!currVal.equals("N")) {
                currNode.right = new TreeNode(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }
        return root;
    }

    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t > 0){
            String s = br.readLine();
            TreeNode root = buildTree(s);
            Solution ob = new Solution();
            List<List<Integer>> ans = ob.VerticalTraversal(root);
            for(int i = 0; i < ans.size(); i++) {
                for(int a : ans.get(i)) {
                    System.out.print(a + " ");
                }
                System.out.println();
            }
            // System.out.println();
            t--;
        }
    }
}