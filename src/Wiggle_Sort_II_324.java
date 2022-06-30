import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//324. 摆动排序 II
public class Wiggle_Sort_II_324 {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[] temp=new int[nums.length];
        System.arraycopy(nums,0,temp,0,nums.length);
        int j=temp.length-1;
        for (int i = 1; i < nums.length; i+=2) {
            nums[i]=temp[j--];
        }
        for (int i = 0; i < nums.length; i+=2) {
            nums[i]=temp[j--];
        }

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

    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for(int index = 0; index < length; index++) {
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

            new Wiggle_Sort_II_324().wiggleSort(nums);
            String out = integerArrayToString(nums);

            System.out.print(out);
        }
    }
}
