/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
import java.util.*;
class Solution {
    public Node copyRandomList(Node head) {
    HashMap<Node, Node> mapping = new HashMap<>();
    Node curr = head;
      while (curr!=null)
      {
          Node copy_node = new Node(curr.val);
          mapping.put(curr, copy_node);
          curr=curr.next;
      }
    curr=head;
    while (curr!=null)
    {
        mapping.get(curr).next = mapping.get(curr.next);
        mapping.get(curr).random = mapping.get(curr.random);
        curr=curr.next;
    }
    return mapping.get(head);  
    }
}