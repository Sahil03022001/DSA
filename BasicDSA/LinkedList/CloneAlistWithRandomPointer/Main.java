public Node copyRandomList(Node head) {
        
    if(head == null)return head;
    
    Node original = head;
    while(original != null){
        Node newNode = new Node(original.val);
        newNode.next = original.next;
        original.next = newNode;
        original = original.next.next;
    }
    
    original = head;
    while(original != null){
        if(original.random != null)
        original.next.random = original.random.next;
        else original.next.random = null;
        original = original.next.next;
    }
    
    original = head;
    Node clone = original.next;
    Node copy = clone;
    while(original != null){
        original.next = original.next.next;
        if(copy.next != null)
        copy.next = copy.next.next;
        original = original.next;
        copy = copy.next;
    }
    return clone;
}
