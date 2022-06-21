import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//216. 组合总和 III
public class Combination_Sum_III_216 {
    LinkedList<Integer> list=new LinkedList<>();
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(k,n,1);
        return result;
    }
    public void backtracking(int k,int n,int startindex){
        if(list.size()==k){
            if(list.stream().reduce((integer, integer2) -> integer+integer2).get()==n){
                result.add(new ArrayList<>(list));
            }

        }
        for (int i = startindex; i <=9; i++) {
            list.add(i);
            backtracking(k,n,i+1);
            list.removeLast();
        }
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
            int k = Integer.parseInt(line);
            line = in.readLine();
            int n = Integer.parseInt(line);

            List<List<Integer>> ret = new Combination_Sum_III_216().combinationSum3(k, n);

            String out = int2dListToString(ret);

            System.out.print(out);
        }
    }
}
