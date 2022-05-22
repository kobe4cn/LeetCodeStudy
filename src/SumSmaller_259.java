import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//259. 较小的三数之和
public class SumSmaller_259 {
    public int threeSumSmaller(int[] nums, int target) {
        int len = nums.length;
        int res = 0;

        long temp= Arrays.stream(nums).distinct().count();
        if(temp==1){
            if(nums[0]>target)
                return res;
        }
        for (int i = 0; i <= len - 3; i++) {
            int j = i + 1;
            while (j <= len - 2) {
                int k = j + 1;
                while (k <= len - 1) {
                    int count = nums[i] + nums[j] + nums[k];
                    if (count < target) {
                        res++;
                       // System.out.println(nums[i] + "+" + nums[j] + "+" + nums[k]);
                    }
                    k++;
                }
                j++;
            }
        }
        return res;
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
            int[] nums = stringToIntegerArray(line);
            line = in.readLine();
            int target = Integer.parseInt(line);

            int ret = new SumSmaller_259().threeSumSmaller(nums, target);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
