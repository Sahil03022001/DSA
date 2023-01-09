public boolean isPalindrome(ListNode head) {
        
    if(head == null || head.next == null)return true;
    
    ListNode fast = head;
    ListNode slow = head;
    ListNode tail = head;
    while(fast != null && fast.next != null){
        tail = fast;
        fast = fast.next.next;
        slow = slow.next;
    }
    if(fast == null)tail = tail.next;
    else tail = tail.next.next;
    reverse(slow);
    ListNode c1 = head;
    ListNode c2 = tail;
    while(c1 != slow && c2 != null){
        if(c1.val != c2.val)return false;
        c1 = c1.next;
        c2 = c2.next;
    }
    return true;
}
private ListNode reverse(ListNode head){
    if(head == null || head.next == null)return head;
    ListNode newHead = reverse(head.next);
    head.next.next = head;
    head.next = null;
    return newHead;
}