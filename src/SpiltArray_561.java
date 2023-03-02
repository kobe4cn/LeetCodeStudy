import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=561 lang=java
 *
 * [561] 数组拆分
 */

// @lc code=start
class SpiltArray_561 {
    public int arrayPairSum(int[] nums) {
        int count=0;
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length-1;) {
            //System.out.println(nums[i]+"/"+nums[i+1]);
           count+= Math.min(nums[i], nums[i+1]);
           i+=2;
        }
        return count;
    }
}
// @lc code=end

