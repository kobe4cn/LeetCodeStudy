import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//1200. 最小绝对差
public class Minimum_Absolute_Difference_1200 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        //绝对值最小只有在最近的两位之间发生，所以遍历后面一位相减就可以了

        List<List<Integer>> list=new ArrayList<>();
        Arrays.sort(arr);
        int min=Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int j=i+1;
            if(j<arr.length) {
                int abs = Math.abs(arr[i] - arr[j]);
                if (abs < min) {
                    min = abs;
                    list.clear();
                    List<Integer> temp = new ArrayList<>();
                    temp.add(arr[i]);
                    temp.add(arr[j]);
                    list.add(temp);
                } else if (abs == min) {
                    min = abs;
                    List<Integer> temp = new ArrayList<>();
                    temp.add(arr[i]);
                    temp.add(arr[j]);
                    list.add(temp);
                }
            }
        }

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
            int[] arr = stringToIntegerArray(line);

            List<List<Integer>> ret = new Minimum_Absolute_Difference_1200().minimumAbsDifference(arr);

            String out = int2dListToString(ret);

            System.out.print(out);
        }
    }
}
