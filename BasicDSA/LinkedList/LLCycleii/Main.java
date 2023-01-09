public ListNode detectCycle(ListNode head) {
        
    if(head == null || head.next == null)return null;
    if(head.next == head)return head;
    ListNode fast = head;
    ListNode slow = head;
    while(fast != null && fast.next != null){
        fast = fast.next.next;
        slow = slow.next;
        if(fast == slow){
            fast = head;
            while(fast != null){
                if(fast == slow)return fast;
                fast = fast.next;
                slow = slow.next;
            }
        }
    }
    return null;
}
