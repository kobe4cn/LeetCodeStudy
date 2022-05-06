
public class AddTwoNumbers_2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(-1);
        ListNode pre=dummy;
        int carry=0;
        while(l1!=null || l2!=null){
            int x= (l1!=null)?l1.val:0;
            int y=(l2!=null)?l2.val:0;
            int sum=carry+x+y;
            carry=sum/10;
            pre.next=new ListNode(sum%10);
            pre=pre.next;
            if(l1!=null) l1=l1.next;
            if(l2!=null) l2=l2.next;
        }
        if(carry>0){
            pre.next=new ListNode(carry);
        }
        return dummy.next;
    }


}
