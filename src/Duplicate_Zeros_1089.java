import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//1089. 复写零
public class Duplicate_Zeros_1089 {
    public void duplicateZeros(int[] arr) {
        for (int i =    0; i < arr.length; i++) {
            if (i!=arr.length-1 && arr[i] == 0) {
                int j=i+1;
                if (j < arr.length){
                    int[] ints = Arrays.copyOfRange(arr, j, arr.length - 1);
                    System.arraycopy(ints,0,arr,j+1,ints.length);
                    arr[j]=0;
                }
                i=j;
            }

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
            int[] arr = stringToIntegerArray(line);

            new Duplicate_Zeros_1089().duplicateZeros(arr);
            String out = integerArrayToString(arr);

            System.out.print(out);
        }
    }
}
