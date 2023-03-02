import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * @lc app=leetcode.cn id=1122 lang=java
 *
 * [1122] 数组的相对排序
 */

// @lc code=start
class RelativeSortArray_1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map=new TreeMap<>((o1, o2) -> o1-o2);
        for (int i = 0; i < arr1.length; i++) {
            map.computeIfPresent(arr1[i], (integer,integer1)->++integer1);
            map.computeIfAbsent(arr1[i], Integer->1);
        }
        List<Integer> result=new ArrayList<>();
        for (int i = 0; i < arr2.length; i++) {
            int size=map.get(arr2[i]);
            for (int j = 0; j < size; j++) {
                result.add(arr2[i]);
            }
            map.remove(arr2[i]);
        }
        Iterator it=map.keySet().iterator();
            while(it.hasNext()) {
                Integer in=(Integer)it.next();
               int len= map.get(in);
               for (int j = 0; j < len; j++) {
                  result.add(in);
               }
            }
        int[] arr=new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            arr[i]=result.get(i);
            
        }
        return arr;

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
            int[] arr1 = stringToIntegerArray(line);
            line = in.readLine();
            int[] arr2 = stringToIntegerArray(line);

            int[] ret = new RelativeSortArray_1122().relativeSortArray(arr1, arr2);

            String out = integerArrayToString(ret);

            System.out.print(out);
        }
    }

}
// @lc code=end

