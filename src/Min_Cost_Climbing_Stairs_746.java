import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//746. 使用最小花费爬楼梯
public class Min_Cost_Climbing_Stairs_746 {
    public int minCostClimbingStairs(int[] cost) {
        int dp0=cost[0];
        int dp1=cost[1];
        for (int i = 2; i < cost.length; i++) {
            int dpi=Math.min(dp0,dp1)+cost[i];
            dp0=dp1;
            dp1=dpi;
        }
        return Math.min(dp0,dp1);
    }

    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] cost = stringToIntegerArray(line);

            int ret = new Min_Cost_Climbing_Stairs_746().minCostClimbingStairs(cost);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
