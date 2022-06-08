import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

//347. 前 K 个高频元素
public class Top_K_Frequent_Elements_347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        PriorityQueue<Map.Entry<Integer,Integer>> queue=new PriorityQueue<>((o1, o2) -> o2.getValue()-o1.getValue());
        for (int i:nums
             ) {
           if(map.containsKey(i)){
              map.computeIfPresent(i,(integer, integer2) -> ++integer2);

            }else{
               map.computeIfAbsent(i,integer -> 1);
           }
        }

        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer,Integer> entry:entries
             ) {
            queue.offer(entry);
        }
        int[] result=new int[k];
        for (int i = 0; i < k; i++) {
            result[i]=queue.poll().getKey();
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

    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for(int index = 0; index < length; index++) {
            int number = nums[index];
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayToString(int[] nums) {
        return integerArrayToString(nums, nums.length);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);
            line = in.readLine();
            int k = Integer.parseInt(line);

            int[] ret = new Top_K_Frequent_Elements_347().topKFrequent(nums, k);

            String out = integerArrayToString(ret);

            System.out.print(out);
        }
    }
}
