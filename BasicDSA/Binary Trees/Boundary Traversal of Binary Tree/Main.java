import java.util.*;

class Node {

  int data;
  Node left, right;
}

class Solution{
    static void printBoundary(Node root)
    {
        // Your code here
		ArrayList<Integer> ans = new ArrayList<>();
		ans = boundary(root);

		for(int val : ans){
			System.out.print(val + " ");
		}
    }

	static boolean isLeaf(Node node){
        if(node.left == null && node.right == null)return true;
        return false;
    }
    
    static void addLeftNodes(Node root, ArrayList <Integer> ans){
        
        Node curr = root;
        while(curr != null){
            if(!isLeaf(curr))ans.add(curr.data);
            if(curr.left != null)curr = curr.left;
            else curr = curr.right;
        }
    }
    
    static void addLeafNodes(Node root, ArrayList <Integer> ans){
        
        if(root == null)return;
        
        if(isLeaf(root)){
            ans.add(root.data);
            return;
        }
        
        addLeafNodes(root.left, ans);
        addLeafNodes(root.right, ans);
    }
    
    static void addRightNodes(Node root, ArrayList<Integer> ans){
        
        Node curr = root;
        Stack<Integer> st = new Stack<>();
        while(curr != null){
            if(!isLeaf(curr))st.push(curr.data);
            if(curr.right != null)curr = curr.right;
            else curr = curr.left;
        }
        
        while(st.size() > 0){
            ans.add(st.pop());
        }
    }
    
	static ArrayList <Integer> boundary(Node root)
	{
	    ArrayList <Integer> ans = new ArrayList<>();
	    
	    if(!isLeaf(root))ans.add(root.data);
	    addLeftNodes(root.left, ans);
	    addLeafNodes(root, ans);
	    addRightNodes(root.right, ans);
	    
	    return ans;
	}
}
public class Main {

  static Node getNode(int data) {
    // Allocate memory
    Node newNode = new Node();

    // put in the data
    newNode.data = data;
    newNode.left = newNode.right = null;
    return newNode;
  }

  static Node LevelOrder(Node root, int data) {
    if (root == null) {
      root = getNode(data);
      return root;
    }
    if (data <= root.data) root.left =
      LevelOrder(root.left, data); else root.right =
      LevelOrder(root.right, data);
    return root;
  }

  static Node constructBst(int arr[], int n) {
    if (n == 0) return null;
    Node root = null;

    for (int i = 0; i < n; i++) root = LevelOrder(root, arr[i]);

    return root;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] tree = new int[n];
    for (int i = 0; i < n; i++) tree[i] = sc.nextInt();
    sc.close();
    Node root = constructBst(tree, n);
    Solution.printBoundary(root);
  }
}
