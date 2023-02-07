import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class BinarySearchTree {
    Node constructBST(int[] arr, int start, int end, Node root) {
        if (start > end)
            return null;
        int mid = (start + end) / 2;

        if (root == null)
            root = new Node(arr[mid]);

        root.left = constructBST(arr, start, mid - 1, root.left);
        root.right = constructBST(arr, mid + 1, end, root.right);

        return root;

    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();

        Arrays.sort(arr);
        Node root = null;
        BinarySearchTree bst = new BinarySearchTree();
        root = bst.constructBST(arr, 0, n - 1, root);

        Accio A = new Accio();
        A.targetSum(root, target);

        sc.close();
    }
}

class Pair {

	Node node;
	int state;

	Pair(Node n, int s){
		node = n;
		state = s;
	}
}

class Accio {

	private Node getNextInOrderNormal(Stack<Pair> st){

		while(!st.isEmpty()){
			Pair top = st.peek();

			if(top.state == 1){
				top.state++;
				if(top.node.left != null) st.push(new Pair(top.node.left, 1));
			}
			else if(top.state == 2){
				top.state++;
				if(top.node.right != null) st.push(new Pair(top.node.right, 1));
				return top.node;
			}
			else{
				st.pop();
			}
		}
		return null;
	}

	private Node getNextInOrderReverse(Stack<Pair> st){

		while(!st.isEmpty()){
			Pair top = st.peek();

			if(top.state == 1){
				top.state++;
				if(top.node.right != null) st.push(new Pair(top.node.right, 1));
			}
			else if(top.state == 2){
				top.state++;
				if(top.node.left != null) st.push(new Pair(top.node.left, 1));
				return top.node;
			}
			else{
				st.pop();
			}
		}
		return null;
	}

    public void targetSum(Node root, int tar)
    {
        // your code here

		Stack<Pair> normal = new Stack<>();
		Stack<Pair> reverse = new Stack<>();

		normal.push(new Pair(root, 1));
		reverse.push(new Pair(root, 1));

		Node left = getNextInOrderNormal(normal);
		Node right = getNextInOrderReverse(reverse);

		boolean flag = false;
		while(left.data < right.data){
			int sum = left.data + right.data;

			if(sum == tar){
				flag = true;
				System.out.println(left.data + " " + right.data);
				left = getNextInOrderNormal(normal);
				right = getNextInOrderReverse(reverse);
			}
			else if(sum < tar){
				left = getNextInOrderNormal(normal);
			}
			else{
				right = getNextInOrderReverse(reverse);
			}
		}

		if(!flag){
			System.out.println(-1);
		}
    }
}