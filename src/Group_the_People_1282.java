import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//1282. 用户分组
public class Group_the_People_1282 {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer,List<Integer>> map=new HashMap<>();
        List<List<Integer>> list=new ArrayList<>();
        for (int i = 0; i < groupSizes.length; i++) {
            if(map.containsKey(groupSizes[i])){
                List<Integer> list1 = map.get(groupSizes[i]);
                if(list1.size()<groupSizes[i]){
                    list1.add(i);
                    map.put(groupSizes[i],list1 );
                }else{
                    list.add(list1);
                    list1=new ArrayList<>();
                    list1.add(i);
                    map.put(groupSizes[i], list1);
                }
            }else {
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                map.put(groupSizes[i], temp);
            }
        }
        list.addAll(map.values());
        return list;
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

    public static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for(int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }

    public static String int2dListToString(List<List<Integer>> nums) {
        StringBuilder sb = new StringBuilder("[");
        for (List<Integer> list: nums) {
            sb.append(integerArrayListToString(list));
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] groupSizes = stringToIntegerArray(line);

            List<List<Integer>> ret = new Group_the_People_1282().groupThePeople(groupSizes);

            String out = int2dListToString(ret);

            System.out.print(out);
        }
    }
}
