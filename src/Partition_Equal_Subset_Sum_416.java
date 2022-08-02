import java.util.Arrays;

//416. 分割等和子集
public class Partition_Equal_Subset_Sum_416 {
    public boolean canPartition(int[] nums) {
        long count = Arrays.stream(nums).sum();
        if(count%2==1) return false;
        int target=(int)count/2;
        int[] dp=new int[target+1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = target;j>=nums[i]; j--) {
                dp[j] = Math.max(dp[j],dp[j-nums[i]]+nums[i] );
            }
        }
        return dp[target]==target;
    }
}
