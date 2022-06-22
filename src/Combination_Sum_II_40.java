import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//40. 组合总和 II
public class Combination_Sum_II_40 {
    Deque<Integer> list=new LinkedList<>();
    List<List<Integer>> result=new ArrayList<>();
    int sum=0;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        boolean[] flag=new boolean[candidates.length];
        backtracking(candidates,target,0,flag);
        return result;
    }

    public void backtracking(int[] candidates,int target,int startindex,boolean[] flag) {

            if (sum== target) {
                    result.add(new ArrayList<>(list));
                    return;

            }

        for (int i = startindex; i < candidates.length && candidates[i]+sum<=target; i++) {

                if (i>0 && candidates[i] == candidates[i - 1]  && !flag[i-1]) {
                        continue;
                }
                flag[i] = true;
                sum+=candidates[i];
                list.push(candidates[i]);
                backtracking(candidates, target, i + 1,flag);

                int temp=list.pop();
            flag[i]=false;
                sum-=temp;
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
            int[] candidates = stringToIntegerArray(line);
            line = in.readLine();
            int target = Integer.parseInt(line);

            List<List<Integer>> ret = new Combination_Sum_II_40().combinationSum2(candidates, target);

            String out = int2dListToString(ret);

            System.out.print(out);
        }
    }
}
