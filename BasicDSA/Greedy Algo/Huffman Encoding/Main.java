class Node implements Comparable<Node>{
    
    int data;
    Node left;
    Node right;
    
    Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
    
    @Override
    public int compareTo(Node o){
        if(this.data == o.data){
            return 1;
        }
        return this.data - o.data;
    }
}

class Solution {
    
    private void preOrderTraversal(Node root, ArrayList<String> ans, String temp){
        
        if(root.left == null && root.right == null){
            ans.add(temp);
            return;
        }
        
        preOrderTraversal(root.left, ans, temp + "0");
        preOrderTraversal(root.right, ans, temp + "1");
    }
    
    public ArrayList<String> huffmanCodes(String S, int f[], int N)
    {
        // Code here
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i = 0; i < N; i++){
            Node node = new Node(f[i]);
            pq.add(node);
        }
        
        while(pq.size() > 1){
            Node node1 = pq.poll();
            Node node2 = pq.poll();
            
            Node root = new Node(node1.data + node2.data);
            root.left = node1;
            root.right = node2;
            
            pq.add(root);
        }
        
        Node root = pq.poll();
        
        ArrayList<String> ans = new ArrayList<>();
        preOrderTraversal(root, ans, "");
        return ans;
    }
}