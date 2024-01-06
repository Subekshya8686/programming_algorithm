public class AdjLIst {
    int v;
    LinkedList list[];

    AdjLIst(int v){
        this.v=v;
        list=new LinkedList[v];
        for(int i=0;i<v;i++){
            list[i]=new LinkedList();
        }
    }

    void addEdge(int source, int destination){

        list[source].addNode(destination);
        list[destination].addNode(source);
    }

    void printGraph(){
        for(int i=0;i<v;i++){
            System.out.print(i +" is connected to =");
            LinkedList.Node current=list[i].head;
            while(current!=null){
                System.out.print(current.data+", ");
                current=current.next;
            }
            System.out.println();
        }
    }

    void BFS(int rootnode){
        boolean [] visited=new boolean[v];
        Queue q= new Queue(v);
        q.enqueue(rootnode);
        visited[rootnode]=true;

        while(!q.isEmpty()){
            int x=q.dequeue();
            System.out.println(x);
            LinkedList.Node current=list[x].head;
            while(current!=null){
                if(!visited[current.data]){
                    q.enqueue(current.data);
                    visited[current.data]=true;
                }
            }
        }
    }


    public static void main(String[] args) {
        AdjLIst adj=new AdjLIst(5);
        adj.addEdge(0,1);
        adj.addEdge(0,2);
        adj.addEdge(0,4);
        adj.addEdge(2,3);
        adj.addEdge(1,4);
        adj.addEdge(4,3);
        adj.printGraph();
    }

}
