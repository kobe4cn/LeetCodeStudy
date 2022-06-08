import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//875. 爱吃香蕉的珂珂
public class Koko_Eating_Bananas_875 {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int result = Integer.MAX_VALUE;
        if (piles.length == h) {
            return piles[piles.length - 1];
        } else if (h > piles.length) {
            int hour = 0;
            double time = (double) h / piles.length;
            double k = Math.ceil(piles[piles.length - 1] / time);
            while (hour <= h) {
                int temp = (int) k + 1;
                result = Math.min(result, temp);
                hour = 0;
                for (int pile : piles
                ) {
                    hour += Math.ceil((double) pile / k);
                }
                k--;
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
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] piles = stringToIntegerArray(line);
            line = in.readLine();
            int h = Integer.parseInt(line);

            int ret = new Koko_Eating_Bananas_875().minEatingSpeed(piles, h);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
