public ListNode removeNthFromEnd(ListNode head, int n) {
        
    int len = findLength(head);
    int i = len - n;
    if(i == 0){
        head = head.next;
        return head;
    }
    
    ListNode curr = head;
    while(i > 1){
        i--;
        curr = curr.next;
    }
    curr.next = curr.next.next;
    return head;
}

private int findLength(ListNode head){
    
    ListNode curr = head;
    int num = 0;
    while(curr != null){
        num++;
        curr = curr.next;
    }
    return num;
}