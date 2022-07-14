import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//474. 一和零
public class Ones_and_Zeroes_474 {
    public int findMaxForm(String[] strs, int m, int n) {
        if (strs.length==0)return 0;
        int[][] dp=new int[m+1][n+1];
        for (int i = 0; i < strs.length; i++) {

            int zero=0;
            int one=0;
            for (int j = 0; j < strs[i].length(); j++) {
                if(strs[i].charAt(j)=='1'){
                    one++;
                }else{
                    zero++;
                }
            }

            //dp[j][k]不将新String中的0和1放进去的情况，和将J和K的总容量中将新的String的0和1的总数扣减掉之后，该数组的值需要增加+1，因为新放进去了一个String

            for (int j = m; j >= zero; j--) {
                for (int k = n; k >=one ; k--) {
                    dp[j][k]=Math.max(dp[j][k],1+dp[j-zero][k-one]);
                }
            }

        }
        return dp[m][n];
    }

    public static String[] stringToStringArray(String line) {
        JsonArray jsonArray = JsonArray.readFrom(line);
        String[] arr = new String[jsonArray.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = jsonArray.get(i).asString();
        }
        return arr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String[] strs = stringToStringArray(line);
            line = in.readLine();
            int m = Integer.parseInt(line);
            line = in.readLine();
            int n = Integer.parseInt(line);

            int ret = new Ones_and_Zeroes_474().findMaxForm(strs, m, n);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
