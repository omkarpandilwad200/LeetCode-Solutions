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

class Solution {
    public Node copyRandomList(Node head) {
        Node head2=new Node (-11);
        Node temp2=head2;
        Node temp1=head;
        //deepcopy creation
        while(temp1!=null){
            Node t=new Node(temp1.val);
            temp2.next=t;
            temp2=t;
            temp1=temp1.next;
        }
        head2=head2.next;
        temp2=head2;
        temp1=head;

        //Alternate connections
        Node t=new Node(-12);
        while(temp1!=null){
            t.next=temp1;
            temp1=temp1.next;
            t=t.next;
            t.next=temp2;
            temp2=temp2.next;
            t=t.next;
        }

        temp2=head2;
        temp1=head;

        //assing Random Pointer

        while(temp1!=null){
            if(temp1.random==null){
                temp2.random=null;
            }
            else{
                temp2.random=temp1.random.next; 
            }
            temp1=temp2.next;

            if(temp1!=null){
                 temp2=temp1.next;
            }
           

        }

        temp2=head2;
        temp1=head;
        while(temp1!=null&&temp2!=null){

            temp1.next=temp2.next;
            temp1=temp1.next;
            if(temp1==null){
                break;
            }
            temp2.next=temp1.next;
            if(temp2==null){
                break;
            }
            temp2=temp2.next;
        }
        temp1=head;
        temp2=head2;
        return head2;

        
    }
}