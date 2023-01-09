public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
    ListNode dummy = new ListNode();
    ListNode temp = dummy;
    
    ListNode l1 = list1;
    ListNode l2 = list2;
    
    while(l1 != null && l2 != null){
        
        if(l1.val < l2.val){
            temp.next = l1;
            temp = temp.next;
            l1 = l1.next;
        }else{
            temp.next = l2;
            temp = temp.next;
            l2 = l2.next;
        }
    }
    
    if(l1 != null){
        temp.next = l1;
    }
    if(l2 != null){
        temp.next = l2;
    }
    
    return dummy.next;
}