import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//46. 全排列
public class Permutations_46 {

    LinkedList<Integer> list=new LinkedList<>();
    List<List<Integer>> result=new ArrayList<>();
     public List<List<Integer>> permute(int[] nums) {
            backtracking(nums,list);
            return result;
    }
    public void backtracking(int[] nums,LinkedList<Integer> list){
        if (list.size() ==nums.length) {
            //if(!result.contains(new ArrayList<>(list)))
            result.add(new ArrayList<>(list));

        }
        for (int i = 0; i < nums.length ; i++) {
            if(list.contains(nums[i])) continue;
            list.add(nums[i]);
            backtracking(nums,list);
            list.removeLast();
        }
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
            int[] nums = stringToIntegerArray(line);

            List<List<Integer>> ret = new Permutations_46().permute(nums);

            String out = int2dListToString(ret);

            System.out.print(out);
        }
    }
}
