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
   public ListNode deleteDuplicates(ListNode head) { 
    ListNode temp = head; 
    ListNode t = head;
    ListNode s = new ListNode(-11); 
    ListNode f = s; 
    int count = 0; 
    
    while (temp != null) { 
        // FIX 1: Search the entire rest of the list OR the list behind it to find duplicates.
        // To keep your structure, we check the rest of the list for matching values.
        t = head; 
        while (t != null) { 
            // FIX 2: Compare values (.val) and ensure we aren't comparing the node to itself
            if (temp != t && temp.val == t.val) { 
                count = 1; 
                break; 
            } 
            t = t.next; 
        } 
        
        if (count == 0) { 
            f.next = temp; 
            f = f.next; 
        } 
        temp = temp.next; 
        count = 0; 
    } 
    f.next = null; 
    return s.next; 
   }
}
