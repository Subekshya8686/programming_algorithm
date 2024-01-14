public class DisjointSet {
   int size[];
   int parent [];
   int v;

    DisjointSet(int v){
        this.v=v;
        size=new int[v];
        parent=new int[v];
        for(int i=0;i<v;i++){
            parent[i]=-1;
        }
    }

    void isCycleDetected(int u, int v){
        int u_abs=find(u);
        int v_abs=find(v);
        if(u_abs==v_abs){
            System.out.println("cycle detected");
            return;
        }
        union(u_abs,v_abs);
    }


    int find(int vertex){
        if(parent[vertex]==-1){
           return vertex;
        }
       return parent[vertex]=find(parent[vertex]);

    }

    void union(int u_abs, int v_abs){
        if(size[u_abs]>size[v_abs]){
            parent[v_abs]=u_abs;
        }
        else if(size[u_abs]<size[v_abs]){
            parent[u_abs]=v_abs;
        }
        else {
            parent[u_abs]=v_abs;
            size[v_abs]++;
        }
    }

    public static void main(String[] args) {
        DisjointSet s=new DisjointSet(5);
        s.isCycleDetected(0,1);
        s.isCycleDetected(0,3);
        s.isCycleDetected(1,4);
        s.isCycleDetected(3,4);
    }



}
