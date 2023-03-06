import org.w3c.dom.ls.LSInput;

import java.util.List;

public class addTwoNumbers {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){
            this.val =  val;
        }
        ListNode(int val,ListNode next){
            this.val = val;
            this.next = next;
        }
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
//        ListNode l2 = new ListNode(4);
//        ListNode l3 = new ListNode(3);
//        l1.next = l2;
//        l2.next = l3;
        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(9);
        ListNode l6 = new ListNode(9);
        ListNode l7 = new ListNode(9);
        ListNode l8 = new ListNode(9);
        ListNode l9 = new ListNode(9);
        ListNode l10 = new ListNode(9);
        ListNode l11 = new ListNode(9);
        ListNode l12 = new ListNode(9);
        ListNode l13 = new ListNode(9);
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;
        l8.next = l9;
        l9.next = l10;
        l10.next = l11;
        l11.next = l12;
        l12.next = l13;

        ListNode res = addTwoNumber(l1,l4);
        System.out.println();

    }

    private static ListNode addTwoNumber(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode head = res;
        int carry = 0;
        ListNode pre = null;
        while (l1!=null || l2!=null){
            int a = l1 != null ? l1.val : 0;
            int b = l2 != null ? l2.val : 0;
            res.val = (a+b+carry) % 10;
            carry = (a+b+carry)/10;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
            ListNode temp = new ListNode();
            res.next = temp;
            pre = res;
            res = res.next;
        }
        if (carry != 0){
            res.val = carry;
        }else {
            pre.next = null;
        }

        return head;
    }
}
