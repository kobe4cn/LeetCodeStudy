import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//1800. 最大升序子数组和
public class Maximum_Ascending_Subarray_Sum_1800 {
    public int maxAscendingSum(int[] nums) {
        int max=Integer.MIN_VALUE;
        int count=0;
        if(nums.length==1){
            return nums[0];
        }
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){
                count+=nums[i-1];
                //count+=nums[i];
                if(i==nums.length-1){
                    count+=nums[i];
                    max=Integer.max(count,max);
                }
            }else{
                count+=nums[i-1];


                max=Integer.max(max,count);
                count=0;
                if(i==nums.length-1){
                    count=nums[i];
                    max=Integer.max(max,count);
                }
            }
        }
        return max;
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

            int ret = new Maximum_Ascending_Subarray_Sum_1800().maxAscendingSum(nums);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
