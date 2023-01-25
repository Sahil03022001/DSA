import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Main {
    static Node buildTree(String str) {
        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }
        String ip[] = str.split(" ");
        Node root = new Node(Integer.parseInt(ip[0]));
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (queue.size() > 0 && i < ip.length) {
            Node currNode = queue.peek();
            queue.remove();
            String currVal = ip[i];
            if (!currVal.equals("N")) {
                currNode.left = new Node(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }
            i++;
            if (i >= ip.length)
                break;
            currVal = ip[i];
            if (!currVal.equals("N")) {
                currNode.right = new Node(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        Node root = buildTree(s);
        Solution tree = new Solution();
        int ans = tree.solve(root);
        System.out.println(ans);

        sc.close();
    }
}

class Pair {
    
    Node node;
    int idx;
    
    Pair(Node n, int i){
        node = n;
        idx = i;
    }
}

class Solution {

    public int solve(Node root) {
        // your code here
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 1));
        
        int maxWidth = 0;
        
        while(q.size() > 0){
            int size = q.size();
            
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            
            while(size > 0){
                Pair curPair = q.poll();
                
                min = Math.min(min, curPair.idx);
                max = Math.max(max, curPair.idx);
                
                if(curPair.node.left != null)q.add(new Pair(curPair.node.left, 2 * curPair.idx));
                if(curPair.node.right != null)q.add(new Pair(curPair.node.right, 2 * curPair.idx + 1));
                
                size--;
            }
            
            maxWidth = Math.max(maxWidth, max - min + 1);
        }
        
        return maxWidth;
    }
}
