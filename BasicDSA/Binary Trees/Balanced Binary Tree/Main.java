import java.util.*;

public class Main {

  static Node getNode(int data) {
    // Allocate memory
    Node newNode = new Node();

    // put in the data
    newNode.data = data;
    newNode.left = newNode.right = null;
    return newNode;
  }

  // function to construct a BST from
  // its level order traversal
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

	static class Pair {

		int height;
		boolean iAmBalanced;

		Pair(){
			height = 0;
			iAmBalanced = true;
		}

		Pair(int height, boolean iAmBalanced){
			this.height = height;
			this.iAmBalanced = iAmBalanced;
		}
	}

	static Pair solve(Node root){

		if(root == null){
			return new Pair();
		}

		Pair leftSubTree = solve(root.left);
		Pair rightSubTree = solve(root.right);

		int diff = Math.abs(leftSubTree.height - rightSubTree.height);

		if(diff <= 1 && leftSubTree.iAmBalanced && rightSubTree.iAmBalanced){
			return new Pair(Math.max(leftSubTree.height, rightSubTree.height) + 1, true);
		}
		else{
			return new Pair(Math.max(leftSubTree.height, rightSubTree.height) + 1, false);
		}
	}
	
  public static boolean isBalanced(Node root) {
    // your code here
	  Pair ans = solve(root);
	  return ans.iAmBalanced;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] tree = new int[n];
    for (int i = 0; i < n; i++) tree[i] = sc.nextInt();
    sc.close();
    Node root = constructBst(tree, n);
    if (isBalanced(root)) System.out.println("true"); else System.out.println(
      "false"
    );
  }
}

class Node {

  int data;
  Node left, right;
}