/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null){
            return null;
        }

        ListNode slow=head;
        ListNode fast=head;

        Boolean Cycle=false;

      while(fast !=null && fast.next!=null){
        slow=slow.next;
        fast=fast=fast.next.next;
        if(slow==fast){
           Cycle=true;
           break;
        }
      }

      if(!Cycle){
        return null;
      }

      ListNode start=head;

      while( start!=slow){
        start=start.next;
        slow=slow.next;
      }
      return start;

    }
}