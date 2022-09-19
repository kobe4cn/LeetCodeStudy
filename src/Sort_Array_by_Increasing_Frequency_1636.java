import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

//1636. 按照频率将数组升序排序
public class Sort_Array_by_Increasing_Frequency_1636 {
    public int[] frequencySort(int[] nums) {
        Map<Integer,Integer> map=new LinkedHashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer integer = map.getOrDefault(nums[i], 0);
            map.put(nums[i],++integer);
        }
        LinkedHashMap<Integer, Integer> collect = map.entrySet().stream().sorted((entry1, entry2) -> {

            if(entry1.getValue()==entry2.getValue()){
                return entry2.getKey()-entry1.getKey();
            }else {
               return entry1.getValue() - entry2.getValue();
            }
        }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(oldValue, newValue) -> oldValue, LinkedHashMap::new));
        List<Integer> list=new ArrayList<>();
        Iterator<Map.Entry<Integer, Integer>> iterator = collect.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer, Integer> next = iterator.next();
            for (int i = 0; i < next.getValue(); i++) {
                list.add(next.getKey());
            }
        }
        return list.stream().filter(integer -> integer!=null).mapToInt(i->i).toArray();
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

            int[] ret = new Sort_Array_by_Increasing_Frequency_1636().frequencySort(nums);

            String out = integerArrayToString(ret);

            System.out.print(out);
        }
    }
}
