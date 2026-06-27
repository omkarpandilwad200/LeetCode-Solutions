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
    public ListNode reverseList(ListNode head){
        ListNode curr=head;
        ListNode pre=null;
        ListNode aft=null;
        while(curr!=null){
            aft=curr.next;
            curr.next=pre;
            pre=curr;
            curr=aft;
        }
        return pre;
    }
    public int pairSum(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;

        while(fast.next!=null&& fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode temp=reverseList(slow.next);
        slow.next=temp;
        ListNode p1=head;
        ListNode p2=slow.next;
        int max=Integer.MIN_VALUE;

        while(p2!=null){
        int sum=p1.val+p2.val;
            if(sum>max){
                max=sum;
            }
            p1=p1.next;
            p2=p2.next;
        }
        return max;
    }
}