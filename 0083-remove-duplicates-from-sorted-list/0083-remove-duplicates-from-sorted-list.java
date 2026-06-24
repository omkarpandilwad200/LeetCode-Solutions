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
        ListNode ans= new ListNode(-1111);
        ListNode f=head;
        ListNode t=ans;
            
        while(f!=null ){
            
            if( t.val!=f.val ){
                t.next=f;
                t=t.next;
                //s=s.next;
              
            }
                f=f.next;
        }
        t.next=null;
        return ans.next;
        
    }
}