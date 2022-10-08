import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//870. 优势洗牌
public class Advantage_Shuffle_870 {
    public int[] advantageCount(int[] nums1, int[] nums2) {

            int n = nums1.length;
            int[][] index = new int[n][2];
            for(int i = 0; i < n; i++) {
                index[i][0] = nums2[i];
                index[i][1] = i;
            }
            Arrays.sort(nums1);
            Arrays.sort(index, (a, b) -> b[0] - a[0]);
            int left = 0, right = n - 1;
            for(int i = 0; i < n; i++) {
                if(nums1[right] > index[i][0]) {
                    nums2[index[i][1]] = nums1[right];
                    right--;
                } else {
                    nums2[index[i][1]] = nums1[left];
                    left++;
                }
            }
            return nums2;
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
            int[] nums1 = stringToIntegerArray(line);
            line = in.readLine();
            int[] nums2 = stringToIntegerArray(line);

            int[] ret = new Advantage_Shuffle_870().advantageCount(nums1, nums2);

            String out = integerArrayToString(ret);

            System.out.print(out);
        }
    }
}
