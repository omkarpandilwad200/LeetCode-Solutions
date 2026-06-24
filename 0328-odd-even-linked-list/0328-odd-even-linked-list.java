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
    public ListNode oddEvenList(ListNode head) {

               ListNode temp=head;
        ListNode even=new ListNode(1);
        ListNode odd=new ListNode(2);
        ListNode e=even;
        ListNode o=odd;

        int count=0;

        while(temp!=null){
            if(count==0){
                e.next=temp;
                e=e.next;
                count=1;
             
            }
            else{
                o.next=temp;
                o=o.next;
                count=0;
               
               
            }
            temp=temp.next;
        }


            o.next=null;
        
        e.next=odd.next;
        return even.next ;
    }  
        
    }
