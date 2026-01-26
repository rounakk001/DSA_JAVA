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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode fast=head;
        ListNode  slow=head;

        ListNode firstNode=null;
        ListNode secondNode=null;

        //firstNode ke liye
        for(int i=1;i<k;i++){
             fast=fast.next;
        }

        firstNode=fast;
         

        ListNode temp=fast;

        //lastNode ke liye
        while(temp.next!=null){
            temp=temp.next;
            slow=slow.next;  
        }
        secondNode=slow;


        int tempval=firstNode.val;
        firstNode.val=secondNode.val;
        secondNode.val=tempval;

        return head;

    }
}