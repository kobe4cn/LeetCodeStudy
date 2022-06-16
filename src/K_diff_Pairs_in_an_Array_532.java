import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//532. 数组中的 k-diff 数对
public class K_diff_Pairs_in_an_Array_532 {
    public int findPairs(int[] nums, int k) {
        List<String> list=new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int abs = Math.abs(nums[i] - nums[j]);
                if(abs==k){
                    String temp=nums[i]+","+nums[j];
                    if(!list.contains(temp)){
                        list.add(temp);
                    }
                }
            }
        }
        return list.size();
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
            int k = Integer.parseInt(line);

            int ret = new K_diff_Pairs_in_an_Array_532().findPairs(nums, k);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
