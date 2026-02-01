/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
         if (head.next == null && n == 1) {
            return null;
        }
        ListNode temp=head;
        int c=1;
        while(temp.next!=null){
            temp=temp.next;
            c++;
       }
       if(n==c)
       return  head.next;
       ListNode curr=head;
       for(int i=1;i<c-n;i++){
         curr=curr.next;

       }
       curr.next=curr.next.next;
       return head;
    }
}