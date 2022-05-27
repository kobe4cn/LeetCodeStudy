//209. 长度最小的子数组
public class MinimumSizeSubarraySum_209 {
    public int minSubArrayLen(int target, int[] nums) {
        int left=0,sum=0;
        int result=Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            while(sum>=target){
                result=Math.min(result,i-left+1);
                //因为数组是从前往后一部分加入到合里面的，所以一旦大于target之后，就尝试着从左边抛弃掉一位
                //去判断该队列是不是最小的
                sum-=nums[left++];
            }
        }
        return result==Integer.MAX_VALUE?0:result;


        ///////////////////////////////

    }



}
