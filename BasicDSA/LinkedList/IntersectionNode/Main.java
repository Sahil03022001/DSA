public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
    int len1 = findLength(headA);
    int len2 = findLength(headB);
    int index = Math.max(len1, len2) - Math.min(len1, len2);
    
    if(len2 > len1){
        ListNode temp = headA;
        headA = headB;
        headB = temp;
    }
    
    ListNode cur1 = headA;
    while(index > 0){
        cur1 = cur1.next;
        index--;
    }
    
    ListNode cur2 = headB;
    while(cur1 != null && cur2 != null){
        if(cur1 == cur2)return cur1;
        cur1 = cur1.next;
        cur2 = cur2.next;
    }
    return null;
}

private int findLength(ListNode head){
    
    int n = 0;
    ListNode curr = head;
    while(curr != null){
        curr = curr.next;
        n++;
    }
    return n;
}
