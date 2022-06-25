import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//53. 最大子数组和
public class Maximum_Subarray_53 {
    public int maxSubArray(int[] nums) {
        int max=Integer.MIN_VALUE;
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            //如果和小于0，后面要加入进去的数字都比max大了，那就直接用后面加进去的数字就好了
            if(sum<0 && nums[i]>max){
                sum=nums[i];
                max=nums[i];
            }
            else {
                sum+=nums[i];
                max = Math.max(sum, max);
                //如果sum已经是负数了，就应该将这个之前加进去的数字都抛弃掉，从队列后面的值在开始，反正之前已经保存过了最大值

                if(sum<=0){
                    sum=0;
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

            int ret = new Maximum_Subarray_53().maxSubArray(nums);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
