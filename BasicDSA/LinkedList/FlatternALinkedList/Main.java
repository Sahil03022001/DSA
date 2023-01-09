Node flatten(Node root){
        
    if(root == null || root.next == null){
        return root;
    }
    root.next = flatten(root.next);
    return merge(root, root.next);
}
Node merge(Node head1, Node head2){
    
    if(head1 == null)return head2;
    if(head2 == null)return head1;
    
    Node c1 = head1;
    Node c2 = head2;
    Node dummy = new Node(0);
    Node c3 = dummy;
    
    while(c1 != null && c2 != null){
        
        if(c1.data < c2.data){
            c3.bottom = c1;
            c3 = c3.bottom;
            c1 = c1.bottom;
        }else{
            c3.bottom = c2;
            c3 = c3.bottom;
            c2 = c2.bottom;
        }
    }
    
    if(c1 != null)c3.bottom = c1;
    if(c2 != null)c3.bottom = c2;
    
    return dummy.bottom;
}
