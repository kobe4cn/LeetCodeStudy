import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//78. 子集
public class Subsets_78 {
    LinkedList<Integer> list;
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        list=new LinkedList<>();
        result=new ArrayList<>();
        result.add(new ArrayList<>());
        for (int i = 1; i <=nums.length ; i++) {
            backtracking(nums,i,0);
        }

        return result;
    }

    public void backtracking(int[] nums,int k,int startindex){
        if(list.size()==k){
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = startindex; i < nums.length; i++) {
            list.add(nums[i] );
            backtracking(nums,k,i+1);
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

            List<List<Integer>> ret = new Subsets_78().subsets(nums);

            String out = int2dListToString(ret);

            System.out.print(out);
        }
    }
}