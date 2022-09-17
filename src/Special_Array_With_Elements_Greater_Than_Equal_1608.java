import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//1608. 特殊数组的特征值
public class Special_Array_With_Elements_Greater_Than_Equal_1608 {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        //int x=-1;
        for (int i = nums.length-1; i>=0; i--) {
            int length=(nums.length-1)-i+1;
            if(nums[i]>length){

                if(i==0){
                    return length;
                }
                if(i-1>=0 && nums[i-1]<length){
                    return length;
                }
            }else if(nums[i]==length){
                if(i-1>=0 && nums[i-1]==length){
                    return -1;
                }
                return nums[i];

            }else if(nums[i]<length){
                return -1;
            }
        }
        return -1;
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

            int ret = new Special_Array_With_Elements_Greater_Than_Equal_1608().specialArray(nums);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
