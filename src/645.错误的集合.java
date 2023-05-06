/*
 * @lc app=leetcode.cn id=645 lang=java
 *
 * [645] 错误的集合
 */

// @lc code=start
class SetMismatch_645 {
    public int[] findErrorNums(int[] nums) {
        int[] result=new int[2];
        for (int i = 0; i < nums.length-1; i++) {
           int value= nums[i+1]-nums[i];
           if(value<=0 || value>1){
                result[0]=nums[i+1];
                if(i==0){
                    result[1]=nums[i]+1;
                }else{
                    result[1]=nums[i]+1;
                }
                break;
           }
        }
        return result;
    }
}
// @lc code=end

