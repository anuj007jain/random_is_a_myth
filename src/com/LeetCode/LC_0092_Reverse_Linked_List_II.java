package com.LeetCode;

public class LC_0092_Reverse_Linked_List_II {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode curr = head;
        ListNode prev = head;
        ListNode next = head;

        int c = 1;

        if (m == 1) {
            while (c < n) {
                prev = curr;
                if(c == 1){
                    curr = curr.next;
                } else {
                    curr = next;
                }
                if(curr != null) {
                    next = curr.next;
                }
                curr.next = prev;
                c++;
            }
            if (n != 1) {
                head.next = next;
            }
            System.out.println(curr.val);
            return curr;
        }

        while(c < m) {
            prev = curr;
            curr = curr.next;
            next = curr.next;
            c++;
        }

        /*System.out.println("Prev: "+prev.val);
        System.out.println("Curr: "+curr.val);
        System.out.println("Next: "+next.val);*/

        ListNode start = prev; //start = 1
        ListNode end = curr;

        //prev = 2, curr = 3, next = 4
        while(c < n) {
            prev = curr;
            curr = next;
            next = curr.next;
            curr.next = prev;
            c++;
            /*System.out.println("Prev: "+prev.val);
            System.out.println("Curr: "+curr.val);
            System.out.println("Next: "+next.val);*/
        }
        start.next = curr;
        end.next = next;
        return head;

    }

    public static void main(String[] args) {
        LC_0092_Reverse_Linked_List_II lc_092_rllii = new LC_0092_Reverse_Linked_List_II();
        ListNode head = new ListNode(3);
        head.next = new ListNode(5);
        //head.next.next = new ListNode(3);
        lc_092_rllii.reverseBetween(head, 1, 2);

    }

}
