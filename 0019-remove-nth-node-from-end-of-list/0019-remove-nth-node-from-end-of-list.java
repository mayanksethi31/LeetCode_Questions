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
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) 
    {
        ListNode prev=null;
        ListNode delete=head;
        ListNode pointer=null;

        for (int i=0;i<n;i++)
        {
            delete=delete.next;
        }
        pointer=delete;
        delete=head;


        while (pointer!=null)
        
        {   
            prev=delete;
            delete=delete.next;
            pointer=pointer.next;
        }

    if(head==delete)
    {
        head=head.next;
    }
    else
    {prev.next=delete.next;}


        

    return head;


    }
}