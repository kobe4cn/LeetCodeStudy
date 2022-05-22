import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

//136. 只出现一次的数字
public class SingleNumber_136 {
    public int singleNumber(int[] nums) {
        final int[] num = {-1};
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                int temp=map.get(nums[i])+1;
                map.put(nums[i],temp);
            }else{
                map.put(nums[i],1);
            }
        }
        map.forEach((integer, integer2) -> {
            if(integer2==1){
                num[0] =integer;
            }
        } );
        return num[0];
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

            int ret = new SingleNumber_136().singleNumber(nums);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
