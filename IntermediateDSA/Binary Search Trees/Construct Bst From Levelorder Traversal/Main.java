import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;
import java.lang.*;

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

public class Main {

    static void printLevelOrder(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {

            Node tempNode = queue.poll();
            System.out.print(tempNode.data + " ");

            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i)
            arr[i] = sc.nextInt();
        Solution Obj = new Solution();
        Node ans = Obj.bstFromLevel(arr, n);
        printLevelOrder(ans);
        sc.close();
    }
}

class Pair {

	Node node;
	int lb;
	int ub;

	Pair (Node n, int min, int max){
		node = n;
		lb = min;
		ub = max;
	}
}

class Solution {
    Node bstFromLevel(int arr[], int n) {
        // write code here
		int idx = 1;
		Queue<Pair> q = new LinkedList<>();
		Node root = new Node(arr[0]);
		q.add(new Pair(root, Integer.MIN_VALUE, root.data));
		q.add(new Pair(root, root.data, Integer.MAX_VALUE));

		while(q.size() > 0){

			Pair rpair = q.poll();
			if(idx == arr.length)break;
			if(arr[idx] <= rpair.lb || arr[idx] >= rpair.ub)continue;

			int val = arr[idx];
			Node node = new Node(arr[idx++]);

			if(val < rpair.node.data){
				rpair.node.left = node;
			}else{
				rpair.node.right = node;
			}

			q.add(new Pair(node, rpair.lb, node.data));
			q.add(new Pair(node, node.data, rpair.ub));
		}

		return root;
    }
}