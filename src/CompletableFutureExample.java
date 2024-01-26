import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {
    public static void main(String[] args) {
         int [] numlist={1,2,3,4};
        CompletableFuture<Integer> sum=CompletableFuture.supplyAsync(()->calcSum(numlist));
        CompletableFuture<Integer> sumSq=sum.thenApplyAsync(result->result*result);
        CompletableFuture<Void> printresult=sumSq.thenAcceptAsync(result-> System.out.println("res="+result));

        System.out.println("tttttt");
        printresult.join();
    }

    public static  int calcSum(int [] numList){
        try{
            Thread.sleep(1000);
        }
        catch (Exception ee){ee.printStackTrace();}
        int sum=0;
    return  Arrays.stream(numList).sum();
    }
}
