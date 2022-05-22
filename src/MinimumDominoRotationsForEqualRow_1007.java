import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//1007. 行相等的最少多米诺旋转
public class MinimumDominoRotationsForEqualRow_1007 {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length;
        int[] nums1 = new int[7];
        int[] nums2 = new int[7];
        for(int curr:tops) nums1[curr]++;
        for(int curr:bottoms) nums2[curr]++;
        int max1 = 0,num1 = 0;
        int max2 = 0,num2 = 0;
        for (int i = 1; i < 7; i++) {
            if (nums1[i] > max1) {
                max1 = nums1[i];
                num1 = i;
            }
            if (nums2[i] > max2) {
                max2 = nums2[i];
                num2 = i;
            }
        }
        int taget = max1 > max2? num1:num2;
        if (nums1[taget] + nums2[taget] < n) return -1;
        for (int i = 0; i < n; i++) {
            if (tops[i] != taget && bottoms[i] != taget) return -1;
        }
        int ans = Math.max(nums1[taget],nums2[taget]);
        return n - ans;
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
            int[] tops = stringToIntegerArray(line);
            line = in.readLine();
            int[] bottoms = stringToIntegerArray(line);

            int ret = new MinimumDominoRotationsForEqualRow_1007().minDominoRotations(tops, bottoms);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
