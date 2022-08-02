import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//122. 买卖股票的最佳时机 II
public class Best_Time_to_Buy_and_Sell_Stock_II_122 {
    public int maxProfit(int[] prices) {

        int profit=0;
        //贪心算法，局部最优，只要隔天有正价差就卖，卖的当天的价格，只要卖掉后面那天比卖掉当天的价格高就立刻买入，后面一天继续再卖，做到每天都最优

        for (int i = 0; i < prices.length; i++) {
          // buy=prices[i];
           if(i+1 < prices.length && prices[i]<prices[i+1]){
               profit+=prices[i+1]-prices[i];
           }
        }
        return profit;
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
            int[] prices = stringToIntegerArray(line);

            int ret = new Best_Time_to_Buy_and_Sell_Stock_II_122().maxProfit(prices);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
