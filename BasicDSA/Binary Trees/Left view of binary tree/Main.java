import java.util.*;
import java.io.*;

class Node{
    int val;
    Node left, right;
    Node(int val){
        this.val = val;
        left = null;
        right = null;
    }
}
class BST{
    Node root = null;
    BST(){

    }
    Node insert(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(val < root.val){
            root.left = insert(root.left, val);
        }else{
            root.right = insert(root.right, val);
        }
        return root;
    }
}

public class Main {
    
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        BST t = new BST();
        for(int i = 0; i < n; i++){
            t.root = t.insert(t.root, input.nextInt());
        }
        
        Solution Accio=new Solution();
        Accio.letfView(t.root);
    }
}

class Solution
{
    public static void letfView(Node root)
    {
        // Your code here
		if(root == null){
			return;
		}

		Queue<Node> q = new LinkedList<>();
		q.add(root);

		while(q.size() > 0){
			int size = q.size();
			int currSize = q.size();

			while(size > 0){
				Node node = q.poll();

				if(size == currSize){
					System.out.print(node.val + " ");
				}

				if(node.left != null)q.add(node.left);
				if(node.right != null)q.add(node.right);

				size--;
			}
		}
    }
    
}