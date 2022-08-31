import java.util.Arrays;

//1464. 数组中两元素的最大乘积
public class Maximum_Product_of_Two_Elements_in_Array_1464 {
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int length= nums.length;
        return (nums[length-1]-1)*(nums[length-2]-1);
    }
}
