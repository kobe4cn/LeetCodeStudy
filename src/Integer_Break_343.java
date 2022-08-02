import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//343. 整数拆分
public class Integer_Break_343 {
    public int integerBreak(int n) {
        int[] dp=new int[n+1];
        dp[2]=1;
        for (int i = 3; i <=n ; i++) {
            for (int j = 1; j <i-1 ; ++j) {
                dp[i]=Math.max(dp[i],Math.max(j*(i-j),j*dp[i-j]));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int n = Integer.parseInt(line);

            int ret = new Integer_Break_343().integerBreak(n);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
