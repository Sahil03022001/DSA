import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

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
            if (i >= ip.length) break;
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
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        Node root1 = buildTree(s1);
        Solution g = new Solution();
        g.binaryTreeZigZagTraversal(root1);
    }
}


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

class Solution {
	static void print(List<Integer> list, int level){

		if(level % 2 == 0){
			for(int val : list){
				System.out.print(val + " ");
			}
		}else{
			for(int i = list.size() - 1; i > - 1; i--){
				System.out.print(list.get(i) + " ");
			}
		}
	}
	
    public static void binaryTreeZigZagTraversal(Node root) {
        // Your code here
		if(root == null){
            return;
        }
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int level = 0;
        
        while(q.size() > 0){
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            
            while(size > 0){
                Node node = q.poll();
                
                list.add(node.data);
                
                if(node.left != null)q.add(node.left);
                if(node.right != null)q.add(node.right);
                
                size--;
            }
            
            print(list, level);
            
            level++;
        }
    }
}