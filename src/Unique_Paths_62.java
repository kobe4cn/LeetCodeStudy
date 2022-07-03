import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//62. 不同路径
public class Unique_Paths_62 {
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i == j && i==0) {
                    dp[i][j] =1;
                }else{
                    if(i-1<0 && j-1>=0){
                       dp[i][j] = dp[i][j-1];
                    }else if(j-1<0 && i-1>=0){
                        dp[i][j] =dp[i-1][j];
                    }else
                    dp[i][j] =dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int m = Integer.parseInt(line);
            line = in.readLine();
            int n = Integer.parseInt(line);

            int ret = new Unique_Paths_62().uniquePaths(m, n);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
