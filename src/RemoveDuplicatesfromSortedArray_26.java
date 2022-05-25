import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//26. 删除有序数组中的重复项
public class RemoveDuplicatesfromSortedArray_26 {
    public int removeDuplicates(int[] numss) {
        int[] nums=numss;
        //nums=new int[0];
        int len = nums.length;
        List<Integer> list = new ArrayList<>();
        int i=0;
        while(i<nums.length){
            if (list.contains(nums[i])) {
                len--;
                //copy i之前的
                //copy i之后的
                //int newlen = 0;
                if (i + 1 < nums.length) {
                    int[] berfore = Arrays.copyOfRange(nums, 0, i);
                    int[] after = Arrays.copyOfRange(nums, i + 1, nums.length );
                    nums= Arrays.copyOf(berfore,berfore.length+after.length);
                    System.arraycopy(after,0,nums,berfore.length,after.length);
                }else{
                    nums = Arrays.copyOfRange(nums, 0, i);
                }
                i--;
            } else {
                list.add(nums[i]);
            }
            i++;
        }
//        numss=nums;
        System.arraycopy(nums,0,numss,0,nums.length);
        //Arrays.stream(nums).forEach(System.out::println);
        return len;
    }


    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }

        return output;
    }

    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for (int index = 0; index < length; index++) {
            int number = nums[index];
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayToString(int[] nums) {
        return integerArrayToString(nums, nums.length);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);

            int ret = new RemoveDuplicatesfromSortedArray_26().removeDuplicates(nums);
            String out = integerArrayToString(nums, ret);

            System.out.print(out);
        }
    }
}
