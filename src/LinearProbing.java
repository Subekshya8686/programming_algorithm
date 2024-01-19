public class LinearProbing {
    String [] key;
    String [] values;
    int size;
    LinearProbing(int size){
        this.size=size;
        key=new String[size];
        values=new String[size];
    }

    int hash(String key){
        int keys=Integer.parseInt(key);
        return (2*keys+3)%10;
    }

    void insert(String k, String v){
        int temp=hash(k);
        int i=temp;
        int x=1;
        do{
         if(key[i]==null){
             key[i]=k;
             values[i]=v;
             return;
         }
         if(key[i]==k){
             values[i]=v;
             return;
         }
         i=(i+1)%10;

        }
        while (i!=temp);
    }

}
