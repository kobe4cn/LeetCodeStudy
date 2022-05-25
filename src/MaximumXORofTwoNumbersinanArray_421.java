import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//421. 数组中两个数的最大异或值
public class MaximumXORofTwoNumbersinanArray_421 {
    public int findMaximumXOR(int[] nums) {
//        int asInt = Arrays.stream(nums).max().getAsInt();
        //System.out.println(asInt);


        if(nums.length<=1){
            return 0;
        }
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
//            int temp=asInt^nums[i];
//            max=Math.max(temp,max);
            int k=i+1;
            while(k<nums.length){
                int temp=nums[i]^nums[k];
                System.out.println(nums[i]+"^"+nums[k]+"="+temp);
                max=Math.max(temp,max);
                k++;
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

            int ret = new MaximumXORofTwoNumbersinanArray_421().findMaximumXOR(nums);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
