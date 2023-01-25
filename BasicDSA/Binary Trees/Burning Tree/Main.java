class Solution
{
    /*class Node {
    	int data;
    	Node left;
    	Node right;
    
    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }*/
    
    //finding target node
    static Node findTargetNode(Node root, int target){
        
        if(root == null){
            return null;
        }
        
        if(root.data == target){
            return root;
        }
        
        Node left = findTargetNode(root.left, target);
        if(left != null && left.data == target)return left;
        
        Node right = findTargetNode(root.right, target);
        if(right != null && right.data == target)return right;
        
        return root;
    }
    
    //mapping child to parent
    static void findParents(Node root, Map<Node, Node> map){
        
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
    
    //doing level order traversal making targetNode as root and finding time required to burn tree
    static int findTimeToBurnTree(Node root, Map<Node, Node> map){
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        Set<Node> set = new HashSet<>();
        set.add(root);
        
        int count = 0;
        
        while(q.size() > 0){
            int size = q.size();
            boolean valid = false;
            
            while(size > 0){
                Node node = q.poll();
                
                if(node.left != null && !set.contains(node.left)){
                    q.add(node.left);
                    set.add(node.left);
                    valid = true;
                }
                
                if(node.right != null && !set.contains(node.right)){
                    q.add(node.right);
                    set.add(node.right);
                    valid = true;
                }
                
                if(map.containsKey(node) && !set.contains(map.get(node))){
                    q.add(map.get(node));
                    set.add(map.get(node));
                    valid = true;
                }
                
                size--;
            }
            
            if(valid)count++;
        }
        
        return count;
    }
    
    public static int minTime(Node root, int target) 
    {
        // Your code goes here
        
        //finding target node
        Node targetNode = findTargetNode(root, target);
        
        //mapping child to its parents
        Map<Node, Node> map = new HashMap<>();
        findParents(root, map);
        
        //finding required time to burn tree
        int ans = findTimeToBurnTree(targetNode, map);
        return ans;
    }
}