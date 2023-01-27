class Tree
{
    //Function to check whether all nodes of a tree have the value 
    //equal to the sum of their child nodes.
    public static int isSumProperty(Node root)
    {
        // add your code here
        if(root == null){
            return 1;
        }
        
        if(root.left == null && root.right == null){
            return 1;
        }
        
        
        int childSum = 0;
        if(root.left != null){
            childSum += root.left.data;
        }
        if(root.right != null){
            childSum += root.right.data;
        }
        
        int checkForLeftSubTree = isSumProperty(root.left);
        int checkForRightSubTree = isSumProperty(root.right);
        
        if(checkForLeftSubTree == 0 || checkForRightSubTree == 0 || childSum != root.data){
            return 0;
        }else{
            return 1;
        }
    }
}