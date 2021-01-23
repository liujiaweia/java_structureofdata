package Linklist;


import java.util.List;

public class Linklistofleetcode {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    //206
    public ListNode reverseList(ListNode head) {
        ListNode p = head;
        ListNode q = null;
        while(p!=null){
            ListNode cur = p.next;
            p.next = q;
            q = p;
            p = cur;
        }
        return q;

    }
    public ListNode reverseList1(ListNode head) {
        if(head ==null||head.next==null)
            return head;
        ListNode res = reverseList1(head.next);
        //反转
        head.next.next = head;
        head.next = null;
        return res;

    }
    //141
    public boolean hasCycle(ListNode head) {
        if(head==null||head.next==null)
            return false;
        ListNode slow = head;
        ListNode fast= head.next;
        while(fast!=null&&fast.next!=null){
            if(fast==slow)
                return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
    //876
    public ListNode middleNode(ListNode head) {
       if(head.next==null){
           return head;
       }
       ListNode fast = head;
       ListNode slow = head;
       while(fast.next!=null&&fast.next.next!=null){
           fast = fast.next.next;
           slow = slow.next;
           if(fast.next == null){
               //偶数
               return slow.next;
           }
       }
       return slow;

    }
    //83
    public ListNode deleteDuplicates(ListNode head) {
       if(head==null){
           return head;
       }
       ListNode p = head;
       while(p.next!=null){
           if(p.val==p.next.val){
               p.next = p.next.next;
           }else{
               p = p.next;
           }
       }
       return p;
    }
    //203
    public ListNode removeElements(ListNode head, int val) {
        while(head!=null&&head.val == val){
            head = head.next;
        }
        if(head==null)
            return head;
        ListNode p = head;
        while(p.next!=null){
            if(p.next.val == val){
                p.next = p.next.next;
            }else{
                p = p.next;
            }
        }
        return head;

    }

}
