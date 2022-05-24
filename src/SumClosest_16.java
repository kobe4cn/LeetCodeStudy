import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumClosest_16 {
    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        int res = 0;
        int small=Integer.MAX_VALUE;
        for (int i = 0; i <= len - 3; i++) {
            int j = i + 1;
            while (j <= len - 2) {
                int k = j + 1;
                while (k <= len - 1) {
                    int count = nums[i] + nums[j] + nums[k];

                    if (count < target) {
                        int temp=target-count;
                        if(temp<small){
                            small=temp;
                            res=count;
                        }
                        //res++;
                        // System.out.println(nums[i] + "+" + nums[j] + "+" + nums[k]);
                    }else{
                        int temp=count-target;
                        if(temp<small){
                            small=temp;
                            res=count;
                        }
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
            int[] nums = stringToIntegerArray(line);
            line = in.readLine();
            int target = Integer.parseInt(line);

            int ret = new SumClosest_16().threeSumClosest(nums, target);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
