import java.util.Scanner;

/*
 * Local Var //created inside a func
 * Instance Var //created inside the class 
 * Static Var //inside class 
 */

class Node{
    int val;
    Node next;
    Node(){
        this.val=0;
        this.next=null;
    }
    Node(int key){
        this.val=key;
        this.next=null;
    }    
    Node(int key,Node next_addr){
        this.val=key;
        this.next=next_addr;
    }    
}
class LinkedList{
    Node head;
    LinkedList(){
        this.head=null;
    }
    public void insert_begin(int val){
        Node curr=new Node(val);
        if(head==null){
            head=curr;
        }
        else{
            curr.next=head;
            head=curr;
        }
    }
    public void delete_begin() {
        if(head==null){
            System.out.println("Already Empty!");
        }
        head= head.next;
    }
    public void traverse(){
        Node temp=head;
        while(temp!=null){
            System.out.println(temp.val);
            temp=temp.next;
        }
    }
    
    public void delete_at(int pos){
        Node temp=head;
        int l=1;
        while(temp !=null && l<pos-1){
            temp=temp.next;
            l++;
        }
        //temp pth
        //curr->next=temp->next
        //temp->next=curr
        //temp.next
        Node next_=null;
        if(temp.next.next!=null){
            next_=temp.next.next;
        }
        temp.next=next_;
    }
    public void insert_at(int key,int pos){
        Node temp=head;
        int l=1;
        while(temp !=null && l<pos-1){
            temp=temp.next;
            l++;
        }
        //temp pth
        //curr->next=temp->next
        //temp->next=curr
        //temp.next
        Node next_=null;
        if(temp.next!=null){
            next_=temp.next;
        }

        Node curr= new Node(key,next_);
        temp.next=curr;
    }
}

public class Linked{
    public static void main(String[] args) {
        LinkedList L=new LinkedList();
        System.out.println("INSERTING AT BEGIN");
        L.insert_begin(2);
        L.insert_begin(3);
        L.insert_begin(5);
        L.traverse();
        System.out.println("DELETE AT BEGIN");
        L.delete_begin();
        L.traverse();
        
        System.out.println("INSERTING AT 2nd pos");
        L.insert_at(4, 2);
        L.traverse();
        System.out.println("INSERTING AT 3rd pos");
        L.insert_at(6, 3);
        L.traverse();
        System.out.println("DELETING AT 3rd pos");
        L.delete_at(3);;
        L.traverse();
    }
}