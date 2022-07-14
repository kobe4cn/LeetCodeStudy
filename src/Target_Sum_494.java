import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//494. 目标和
public class Target_Sum_494 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if((sum+target)%2!=0) return 0;

        int tar=(sum+target)/2;
        if(tar<0) tar=-tar;
        int[] dp=new int[tar+1];
        dp[0]=1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = tar; j>=nums[i] ; j--) {
                dp[j]+=dp[j-nums[i]];
            }
        }
        return dp[tar];

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
            int[] nums = stringToIntegerArray(line);
            line = in.readLine();
            int target = Integer.parseInt(line);

            int ret = new Target_Sum_494().findTargetSumWays(nums, target);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
