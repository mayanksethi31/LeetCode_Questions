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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0 || lists == null) return null;
        ListNode l1;
        ListNode l2;
        List < ListNode > listing = new ArrayList < > ();

        for (ListNode nodes: lists) listing.add(nodes);
        
        while ((listing.size()) > 1) {
        List < ListNode > merge = new ArrayList < > ();
        for (int i = 0; i < listing.size(); i += 2) {
            l1 = listing.get(i);
            if ((i + 1) < listing.size()) l2 = listing.get(i + 1);
            else l2 = null;
            merge.add(mergeList(l1, l2));
        }
        listing = merge;
}
return listing.get(0);
    }
    private ListNode mergeList(ListNode l1, ListNode l2)
    {
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
         while (l1!=null && l2!=null)
         {
             if (l1.val<l2.val)
             {
                 temp.next = l1;
                 l1 = l1.next;
             }
             else 
             { 
                temp.next = l2;
                l2 = l2.next;
             }
             temp = temp.next;
        }
             
             if (l1!=null)
             {
                temp.next = l1;  
             }
             if (l2!=null)
             {
                temp.next = l2;  
             }
             return dummy.next;
         
    }
}