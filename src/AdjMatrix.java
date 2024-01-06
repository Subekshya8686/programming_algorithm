import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AdjMatrix {
    int v;
    int graph[][];
    AdjMatrix(int v){
        this.v=v;
        graph=new int[v][v];
    }

    void printMatrix(){
        for(int i=0;i<v;i++){
            for(int j=0;j<v;j++){
                System.out.print(graph[i][j]+" ");
            }
            System.out.println();
        }

    }

    void printGraph(){
        for(int i=0;i<v;i++){
            System.out.print(i+" is connected to=");
            for(int j=0;j<v;j++){
                if(graph[i][j]!=0){
                    System.out.print(j+",");
                }

            }
            System.out.println();
        }
    }

    List<Integer> getAdjNodes(int i){
        List<Integer> adjlist=new ArrayList<>();
        for(int j=0; j<v;j++){
            if(graph[i][j]!=0){
                adjlist.add(j);
            }
        }
        return adjlist;
    }

    void addEdge(int source, int destination,int w){
        graph[source][destination]=w;
        graph[destination][source]=w;
    }

    void BFS(int rootnode){
        boolean [] visited=new boolean[v];
        Queue q= new Queue(v);
        q.enqueue(rootnode);
        visited[rootnode]=true;

        while(!q.isEmpty()){
            int x=q.dequeue();
            System.out.println(x);
            for(int i=0;i<v;i++){
                if(graph[x][i]!=0){
                    if(!visited[i]){
                        q.enqueue(i);
                        visited[i]=true;
                    }
                }
            }
        }
    }
    void dfsHelper(int rootnode,boolean [] visited){
        System.out.println(rootnode);
        visited[rootnode]=true;
        for(int i=0;i<v;i++){
            if(graph[rootnode][i]!=0){
                if(!visited[i]){
                    dfsHelper(i,visited);
                }
            }
        }
    }

    void dfs(int rootnode){
        boolean [] visited=new boolean[v];
        dfsHelper(rootnode,visited);
    }

    void dfs2(int rootnode){
        boolean visited[]=new boolean[v];
        Stack<Integer> stk=new Stack<>();
        stk.push(rootnode);
        while (!stk.isEmpty()){
            int x=stk.peek();
            stk.pop();
            if(!visited[x]){
                System.out.println(x);
                visited[x]=true;
            }
            for(int i=0;i<v;i++){
                if(graph[x][i]!=0){
                    if(!visited[i]){
                        stk.push(i);
                    }
                }
            }
        }
    }

    int shortestDistBFS(int source, int destination){
        Queue queue=new Queue(v);
        boolean visited[]=new boolean[v];
        int dist[]=new int[v];
        int prevpath[]=new int[v];

        for(int i=0;i<v;i++){
            dist[i]=Integer.MAX_VALUE;
            prevpath[i]=-1;
        }
        dist[source]=0;
        queue.enqueue(source);
        visited[source]=true;
        while (!queue.isEmpty()){
            int x=queue.dequeue();
            for (int i=0;i<v;i++){
                if(graph[x][i]!=0){
                    if(!visited[i]){
                        if(dist[x]+1<dist[i]){
                            dist[i]=dist[x]+1;
                            prevpath[i]=x;
                        }
                        queue.enqueue(i);
                        visited[i]=true;
                    }
                }
            }
        }
        //print path

        return dist[destination];

    }

    int dijakstra(int source, int destination){
        int dist[]=new int[v];
        int prevpath[]=new int[v];
        boolean visited[]=new boolean[v];

        for(int i=0;i<v;i++){
            dist[i]=Integer.MAX_VALUE;
            prevpath[i]=-1;
        }

        dist[source]=0;
        for(int i=0;i<v;i++){
            int u=findMinVertex(dist, visited);
            visited[u]=true;
            for(int j=0;j<v;j++){
                if(graph[u][j]!=0){
                    if( dist[u]!=Integer.MAX_VALUE&&!visited[j] && dist[u]+graph[u][j]<dist[j]){
                        dist[j]= dist[u]+graph[u][j];
                        prevpath[j]=u;
                    }
                }
            }
        }
        //print path using prev path do by your self
        int current=destination;
        Stack<Integer> stk=new Stack<>();
        stk.push(current);
        while (prevpath[current]!=-1){
            current=prevpath[current];
            stk.push(current);
        }

        //printing path
        System.out.println("printing path to destination");
        for(int i=0;i<stk.size();i++){
            System.out.println(stk.pop());
        }

return  dist[destination];


    }

    int findMinVertex(int [] dist, boolean [] visited){
        int minvertex=-1;
        for (int i=0;i<dist.length;i++){
          if(dist[i]!=Integer.MAX_VALUE &&(minvertex==-1 || dist[i] <dist[minvertex])&& !visited[i] ){
              minvertex=i;
          }
        }
        return minvertex;
    }


    public static void main(String[] args) {
        AdjMatrix adj=new AdjMatrix(6);
        adj.addEdge(0,1,4);
        adj.addEdge(0,3,2);
        adj.addEdge(1,2,20);
        adj.addEdge(2,5,5);
        adj.addEdge(0,5,100);
        adj.addEdge(3,1,1);
        adj.addEdge(3,4,5);
        adj.addEdge(4,5,5);

        adj.printGraph();
        adj.printMatrix();
        System.out.println("traversing BFS");
        adj.BFS(0);
    }
}
