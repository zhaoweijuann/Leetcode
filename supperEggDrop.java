import java.util.HashMap;
import java.util.Map;

public class supperEggDrop {

    public static void main(String[] args) {
        int k = 2;
        int n = 2;
        int res =  eggDrop(k,n);
        System.out.println(res);
    }

    private static int eggDrop(int k, int n) {
        //k 鸡蛋数
        //n 楼高
        int[][] dp = new int[k+1][n+1];
        for (int i = 1; i <= k; i++){
            dp[i][1] = 1;
        }
        for (int i = 1; i <= n; i++){
            dp[1][i] = i;
        }
        for (int i = 2; i <= k; i++){
            for (int j = 1; j <= n; j++){
                int left = 1;
                int right = j;
                while(left+1 < right){
                    int mid = (left+right)/2;
                    int down = dp[i-1][mid-1];
                    //j-mid  从mid+1层到j层
                    int up = dp[i][j-mid];
                    if (down > up){
                        right = mid;
                    }else if (down < up){
                        left = mid;
                    }else {
                        left = right = mid;
                    }
                }
                int leftVal = Math.max(dp[i-1][left-1],dp[i][j-left]);
                int rightVal = Math.max(dp[i-1][right-1],dp[i][j-right]);
                dp[i][j] = 1 + Math.min(leftVal,rightVal);
            }
        }
        return dp[k][n];
    }



    public static int supperEgg(int k, int n){
        int res = 1;
        int start = 1;
        int end = n;
        int mid = (start+end)/2;
        while (start != end && k!=0){
            k--;
            end = mid - 1;
            mid = (start+end)/2;
            res++;
        }
        return res;
    }






}
