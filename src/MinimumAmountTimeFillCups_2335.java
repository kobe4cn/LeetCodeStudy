import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//2335. 装满杯子需要的最短总时长
public class MinimumAmountTimeFillCups_2335 {
    public int fillCups(int[] amount) {
        Arrays.sort(amount);
        int count = 0;
        while (amount[2]>0){
            //Arrays.stream(amount).sorted();
            if(amount[2]>0){
                amount[2]--;
            }
            if(amount[1]>0){
                amount[1]--;
            }
            count++;
            Arrays.sort(amount);
        }
        return count;
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
            int[] amount = stringToIntegerArray(line);

            int ret = new MinimumAmountTimeFillCups_2335().fillCups(amount);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
