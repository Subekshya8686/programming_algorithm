public class DoublyLinkedList {
  public static class Node{
      int data;
      Node prev;
      Node next;

      Node(int data){
          this.data=data;
          this.next=null;
          this.prev=null;
      }
  }
  Node head=null;
  Node tail=null;
  void addNode(int data){
      Node newnode=new Node(data);
      if(head==null){
          head=tail=newnode;
      }
      else{
          tail.next=newnode;
          newnode.prev=tail;
          tail=newnode;
      }

  }

    public void printList(){
       Node current=head;
        while (current!=null){
            System.out.println(current.data);
            current=current.next;
        }
    }

}
