public class FIb {
    int fibo(int n){
        int dp[]=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<dp.length;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
        
    }

    int fibonacii(int n, int [] memo){
        if(memo[n]>=0){
            return memo[n];
        }
        if(n==0||n==1){
            return n;
        }
        memo[n]= fibonacii(n-1,memo)+fibonacii(n-2,memo);
    return memo[n];
    }

    void fiboutil(int n){
    int memo[]=new int[n+2];
    for (int i=0;i<memo.length;i++){
        memo[i]=-1;
    }
        System.out.println(fibonacii(n,memo));
    }

    public static void main(String[] args) {
        FIb f=new FIb();
       f.fiboutil(50);
    }
}
