import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//167. 两数之和 II - 输入有序数组
public class TwoSumIIInputArrayIsSorted_167 {
    public int[] twoSum(int[] numbers, int target) {
        // 因为已经是有顺序的，所以只要判断下比target大还是小，来移动i和j
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int value = numbers[left] + numbers[right];
            if(value>target){
                right--;
            }else if(value<target){
                left++;
            }else if (value==target){
                int[] ints={left+1,right+1};
                return ints;
            }
        }
        return new int[0];

        //第二种暴力法
//        for (int i = 0; i < numbers.length; i++) {
//            int k = i + 1;
//            while (k < numbers.length) {
//                if (numbers[i] + numbers[k] == target) {
//                    int[] temp = {i+1, k+1};
//                    return temp;
//                }
//                k++;
//            }
//        }
//        return new int[0];
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
            int[] numbers = stringToIntegerArray(line);
            line = in.readLine();
            int target = Integer.parseInt(line);

            int[] ret = new TwoSumIIInputArrayIsSorted_167().twoSum(numbers, target);

            String out = integerArrayToString(ret);

            System.out.print(out);
        }
    }
}
