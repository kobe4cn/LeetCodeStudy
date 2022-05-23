import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//121. 买卖股票的最佳时机
public class BestTimetoBuyandSellStock_121 {
    public int maxProfit(int[] prices) {
//        System.out.println(prices.length);
//        prices=Arrays.stream(prices).distinct().toArray();
//
//        System.out.println(prices.length);
       if(prices.length<=1){
           return 0;
       }
       int min=prices[0];int max=0;
        for (int i = 0; i < prices.length; i++) {
            max=Math.max(max,prices[i]-min);
            min=Math.min(min,prices[i]);
        }
        return max;
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

            int ret = new BestTimetoBuyandSellStock_121().maxProfit(prices);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
