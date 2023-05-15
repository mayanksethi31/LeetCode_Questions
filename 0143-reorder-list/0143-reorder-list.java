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
import java.util.*;
class Solution
{
    public void reorderList(ListNode head) 
    {
        
    ListNode slow = head;
    ListNode fast = head.next;
    if (fast!=null)
    {
    while (fast.next!=null)
    { 
            slow=slow.next;
            if (fast.next.next==null)
            {
                break;
            }
            fast=fast.next.next;    
    }

       ListNode prev=null;
       ListNode current=slow.next;
       slow.next=null;
       ListNode next;

    while (current!=null)
    {
       next=current.next;
       current.next=prev;
       prev=current;
       current=next;
    }

    current=head;
    head = head.next;

    
while (prev!=null ) 
{

    current.next=prev;
    prev=prev.next;

    current=current.next;
    current.next=head;

    current=current.next;
    if (prev==null)
    {break;}
    head = head.next;
    

}
if (head!=null)
    {head = head.next;
    current=current.next;}
        
    if (head!=null)
    {current.next=head;}
    }
   
}
}