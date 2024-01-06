import java.util.HashMap;

public class LRUCaching {
    public static class Node{
        int key;
        int value;
        Node next;
        Node prev;

        Node(int key, int value){
            this.key=key;
            this.value=value;
            this.prev=this.next=null;
        }
    }
    int capacity;
    HashMap<Integer,Node> map;

    LRUCaching(int capacity){
        this.capacity=capacity;
        map=new HashMap<>();
    }

    public void put(int key, int value){
      if(map.containsKey(key)){
         remove(map.get(key));
          //remove that node and resinsert
      }
      else if(map.size()==capacity){
          remove(tail);
      }
      else {
          Node newnode=new Node(key,value);
          insert(newnode);
      }
    }

    int get(int key){
        Node node=map.get(key);
        if(node==null){
            return -1;
        }
        remove(node);
        insert(node);
        return node.value;
    }
    Node head;
    Node tail;
    void insert(Node newnode){
        map.put(newnode.key,newnode);
      if(head==null){
          head=tail=newnode;
      }
      else{
        newnode.next=head;
        head.prev=newnode;
        head=newnode;
      }
    }

    void remove(Node node){
        map.remove(node.key);
        if(node==head){
            head.next.prev=null;
            Node temp=head.next;
            head.next=null;
            head=temp;
        }
        else if (node == tail) {
           tail.prev.next=null;
           Node temp=tail.prev;
           tail.prev=null;
           tail=temp;
        }
        else{
            node.prev.next=node.next;
            node.next.prev=node.prev;
            node.next=node.prev=null;
        }
    }
}
