import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
//77. 组合
public class Combinations_77 {
    LinkedList<Integer> list;
    List<List<Integer>> result;
    public List<List<Integer>> combine(int n, int k) {
        list=new LinkedList<>();
        result=new ArrayList<>();
        backtracking(n,k,1);
        return result;
    }
    public void backtracking(int n,int k,int startindex){
        if(list.size()==k){
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = startindex; i <=n ; i++) {
            list.add(i);
            backtracking(n,k,i+1);
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
            int n = Integer.parseInt(line);
            line = in.readLine();
            int k = Integer.parseInt(line);

            List<List<Integer>> ret = new Combinations_77().combine(n, k);

            String out = int2dListToString(ret);

            System.out.print(out);
        }
    }

}
