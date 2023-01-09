static int findLength(Node head){
        
    int n = 0;
    Node c = head;
    while(c != null){
        n++;
        c = c.next;
    }
    return n;
}

static Node reverse(Node head, Node tail){
    
    if(head == tail)return head;
    Node newHead = reverse(head.next, tail);
    head.next.next = head;
    head.next = null;
    return newHead;
}

public static Node getListAfterReverseOperation(Node head, int n, int b[]) {
    // Write your code here.
    if(head == null || head.next == null)return head;
    int len = findLength(head);
    Node curr = head;
    Node prev = null;
    for(int i = 0; i < n; i++){
        if(b[i] == 0)continue;
        Node tail = curr;
        int j = b[i];
        if(j > len){
            while(tail.next != null)tail = tail.next;
        }else{
            while(j > 1){
            j--;
            tail = tail.next;
            }
        }
        Node tNext = tail.next;
        reverse(curr, tail);
        if(prev == null)head = tail;
        if(prev != null)prev.next = tail;
        prev = curr;
        curr.next = tNext;
        curr = curr.next;
        if(curr == null)break;
        len -= b[i];
    }
    return head;
}
