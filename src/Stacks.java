public class Stacks{
    char stk[];
    int top=-1;
    int size;
    Stacks(int size){
        this.size=size;
        stk = new char[size];
    }
    void push(char data){
        if(isFull()){
            System.out.println("Stack overflow");
        }
        else{
            top++;
            stk[top]=data;
        }
    }

    char pop(){
        if(isEmpty()){
            System.out.println("Stack underflow");
            return 'a';
        }
        return stk[top--];
    }

    char peek(){
        if(isFull()){
            System.out.println("Stack overflow");
        }
        return stk[top--];
    }

    boolean isFull(){
        return top==stk.length-1;
    }

    boolean isEmpty(){
        return top==-1;
    }
}