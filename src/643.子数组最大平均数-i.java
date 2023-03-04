/*
 * @lc app=leetcode.cn id=643 lang=java
 *
 * [643] 子数组最大平均数 I
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

// @lc code=start
class MaximumAverageSubarrayI_643 {
    public double findMaxAverage(int[] nums, int k) {

            int sum = 0;
            int n = nums.length;
            for (int i = 0; i < k; i++) {
                sum += nums[i];
            }
            int maxSum = sum;
            for (int i = k; i < n; i++) {
                sum = sum - nums[i - k] + nums[i];
                maxSum = Math.max(maxSum, sum);
            }
            return 1.0 * maxSum / k;
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

    public static String doubleToString(double input) {
        return new DecimalFormat("0.00000").format(input);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);
            line = in.readLine();
            int k = Integer.parseInt(line);

            double ret = new MaximumAverageSubarrayI_643().findMaxAverage(nums, k);

            String out = doubleToString(ret);

            System.out.print(out);
        }
    }
}
// @lc code=end

