public class LinkedList {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data= data;
            this.next= null;
        }
    }

    Node head= null;
    Node tail=null;
    void addNode(int data){
        Node newnode = new Node(data);
        if(head== null){
            head = newnode;
            tail=head;
        }
        else {
            tail.next=newnode;
            tail=newnode;
//            Node current=head;
//            while(current.next!=null){
//                current=current.next;
//            }
//            current.next=newnode;
        }
    }
    void addHeadFirst(int  data){
        Node newnode=new Node(data);
        newnode.next=head;
        head=newnode;

    }

    public void printList(){
        Node current=head;
        while (current!=null){
            System.out.println(current.data);
            current=current.next;
        }
    }

    public static void main(String[] args) {
        LinkedList list= new LinkedList();
        list.addNode(10);
    }
}
