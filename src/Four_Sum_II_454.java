import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

//454. 四数相加 II
public class Four_Sum_II_454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer,Integer> map=new HashMap<>();
        //int count=0;
        for (int i:nums1
             ) {
            for (int i1: nums2
                 ) {
                int temp=i+i1;
                if(map.containsKey(temp)){
                    map.computeIfPresent(temp,(integer, integer2) -> ++integer2 );
                }else {
                    map.put(temp, 1);
                }
            }
        }
        int result=0;
        for (int i:nums3
             ) {
            for (int i1:nums4
                 ) {
                result+=map.getOrDefault(0-i-i1,0);
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

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums1 = stringToIntegerArray(line);
            line = in.readLine();
            int[] nums2 = stringToIntegerArray(line);
            line = in.readLine();
            int[] nums3 = stringToIntegerArray(line);
            line = in.readLine();
            int[] nums4 = stringToIntegerArray(line);

            int ret = new Four_Sum_II_454().fourSumCount(nums1, nums2, nums3, nums4);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
