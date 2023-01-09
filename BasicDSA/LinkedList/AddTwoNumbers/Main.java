public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
    int len1 = findLength(l1);
    int len2 = findLength(l2);
    
    if(len2 > len1){
        ListNode temp = l1;
        l1 = l2;
        l2 = temp;
    }
    
    ListNode cur1 = l1;
    ListNode cur2 = l2;
    ListNode dummy = new ListNode();
    ListNode cur3 = dummy;
    
    int carry = 0, sum = 0;
    while(cur1 != null || cur2 != null){
        sum = 0;
        sum += carry;
        if(cur1 != null){
            sum += cur1.val;
        }
        if(cur2 != null){
            sum += cur2.val;
        }
        carry = sum / 10;
        
        
        ListNode newNode = new ListNode(sum%10);
        cur3.next = newNode;
        cur3 = cur3.next;
        
        cur1 = cur1.next;
        if(cur2 != null){
            cur2 = cur2.next;
        }
    }
    
    if(carry > 0){
        ListNode newNode = new ListNode(carry);
        cur3.next = newNode;
        cur3 = cur3.next;
    }
    return dummy.next;
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
