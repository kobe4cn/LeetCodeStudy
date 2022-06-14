import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//1051. 高度检查器
public class HeightChecker_1051 {
    public int heightChecker(int[] heights) {
        int count=0;
        int[] result=Arrays.copyOf(heights,heights.length);
        Arrays.sort(heights);
        for (int i = 0; i < heights.length; i++) {
            if(result[i]!=heights[i]){
                count++;
            }
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
            int[] heights = stringToIntegerArray(line);

            int ret = new HeightChecker_1051().heightChecker(heights);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
