import java.util.Scanner;

class TreeNode  {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(){
        val = 0;
        left = null;
        right = null;
    }

    TreeNode(int value){
        val = value;
    }
}

class Main {
    public static void main(String[] args) {
        
        TreeNode root = constructBinaryTree();
        printTree(root);
    }

    static TreeNode constructBinaryTree(){

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the value of Node : ");
        int val = sc.nextInt();
        TreeNode root = new TreeNode(val);

        if(val == -1){
            return null;
        }

        System.out.println("Enter the left value : ");
        root.left = constructBinaryTree();

        System.out.println("Enter the right value : ");
        root.right = constructBinaryTree();

        return root;
 
    }

    static void printTree(TreeNode root){

        if(root == null){
            return;
        }

        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }
}