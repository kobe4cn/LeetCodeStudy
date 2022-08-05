import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Minimum_Subsequence_1403 {
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> list=new ArrayList<>();
//        int[] temp=nums;
        int sum = Arrays.stream(nums).sum();
        Arrays.sort(nums);

        int count=0;
        int len=nums.length-1;

        while(len>=0 && sum>=count) {
            sum-=nums[len];
            count+=nums[len];
            list.add(nums[len] );
            len--;
        }
        return list;

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

    public static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for(int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);

            List<Integer> ret = new Minimum_Subsequence_1403().minSubsequence(nums);

            String out = integerArrayListToString(ret);

            System.out.print(out);
        }
    }
}
