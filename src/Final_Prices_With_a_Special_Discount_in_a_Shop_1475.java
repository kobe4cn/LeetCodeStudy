import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//1475. 商品折扣后的最终价格
public class Final_Prices_With_a_Special_Discount_in_a_Shop_1475 {
    public int[] finalPrices(int[] prices) {
        int[] result=new int[prices.length];
        Arrays.fill(result,-1);
        for (int i = 0; i < prices.length; i++) {
            int j=i;
            while(j+1< prices.length){
                if(prices[i]>=prices[j+1]){
                    result[i]=prices[i]-prices[j+1];
                    break;
                }
                j++;
            }
            if(result[i]<0) {
                result[i] = prices[i];
            }
        }
        return result;
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
            int[] prices = stringToIntegerArray(line);

            int[] ret = new Final_Prices_With_a_Special_Discount_in_a_Shop_1475().finalPrices(prices);

            String out = integerArrayToString(ret);

            System.out.print(out);
        }
    }
}
