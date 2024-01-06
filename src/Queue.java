public class Queue {
    int queue[];
    int front=-1;
    int rear=-1;
    int size;

    Queue(int size){
        this.size=size;
        queue=new int[size];
    }

    void enqueue(int data){
      if(isFull()){
          System.out.println("queue overflow");
      }
      else{
          if(front==-1 && rear==-1){
              front=rear=0;
              queue[rear]=data;
          }
          else{
              queue[++rear]=data;
          }
      }
    }

    int dequeue(){
       if(isEmpty()){
           System.out.println("queue underflpw");
           return -9999;
       }
       if(front==rear){
           int temp=front;
           front=rear=-1;
           return queue[temp];
       }
//       int temp=front;
//       front++;
//       return  queue[front];
       return  queue[front++];

    }

    boolean isEmpty(){
        return  front==-1 && rear==-1;
    }
    boolean isFull(){
        return rear==size-1;
    }

    public static void main(String[] args) {
        Queue q=new Queue(5);
        q.enqueue(10);
        q.enqueue(20);
        System.out.println(q.dequeue());
    }
}
