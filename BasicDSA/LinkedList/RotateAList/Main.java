public ListNode rotateRight(ListNode head, int k) {
        
    if(head == null || head.next == null || k == 0)return head;
    
    int len = 0;
    ListNode curr = head;
    ListNode tail = head;
    while(curr != null){
        tail = curr;
        curr = curr.next;
        len++;
    }
    
    k = k % len;
    if(k == 0)return head;
    int index = len - k;
    curr = head;
    ListNode prev = null;
    while(index > 0){
        prev = curr;
        curr = curr.next;
        index--;
    }
    
    prev.next = null;
    tail.next = head;
    head = curr;
    return head;
}
