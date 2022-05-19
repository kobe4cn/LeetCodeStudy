import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//310. 最小高度树
public class MinimumHeightTrees_310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> returnlist = new ArrayList<>();
        Map<Integer, List<Integer>> keymap = new HashMap<>();
        if (n==1){
            returnlist.add(0);
            return returnlist;
        }
        for (int[] ints:edges
             ) {
            if (keymap.containsKey(ints[0])) {
                List<Integer> list = keymap.get(ints[0]);
                list.add(ints[1]);
                keymap.put(ints[0], list);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(ints[1]);
                keymap.put(ints[0],list);
            }
            if (keymap.containsKey(ints[1])) {
                List<Integer> list = keymap.get(ints[1]);
                list.add(ints[0]);
                keymap.put(ints[1], list);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(ints[0]);
                keymap.put(ints[1],list);
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            //int level=Integer.MAX_VALUE;
            List<Integer> deplistofroot = new ArrayList<>();
            List<Integer> usedlist = new ArrayList<>();
            DFS(i, keymap, 0, deplistofroot, usedlist);
            int deep = deplistofroot.stream().max(Integer::compareTo).get();

            if (deep < min) {
                min = deep;
                returnlist.clear();
                returnlist.add(i);
            } else if (deep == min) {
                returnlist.add(i);
            }
            System.out.println("root: " + i + " deep: " + deep);
        }
        return returnlist;
    }

    public void DFS(int n, Map<Integer, List<Integer>> keymap, int maxlevel, List<Integer> list1, List<Integer> usedlist) {
        usedlist.add(n);
        List<Integer> list = new ArrayList<>(keymap.get(n));
        list.removeAll(usedlist);
        for (int i = 0; i < list.size(); i++) {
            int key = list.get(i);
            DFS(key, keymap, maxlevel + 1, list1, usedlist);
        }
        list1.add(maxlevel);
        maxlevel = 0;
        return;
    }

    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static int[][] stringToInt2dArray(String input) {
        JsonArray jsonArray = JsonArray.readFrom(input);
        if (jsonArray.size() == 0) {
            return new int[0][0];
        }

        int[][] arr = new int[jsonArray.size()][];
        for (int i = 0; i < arr.length; i++) {
            JsonArray cols = jsonArray.get(i).asArray();
            arr[i] = stringToIntegerArray(cols.toString());
        }
        return arr;
    }

    public static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for (int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int n = Integer.parseInt(line);
            line = in.readLine();
            int[][] edges = stringToInt2dArray(line);

            List<Integer> ret = new MinimumHeightTrees_310().findMinHeightTrees(n, edges);

            String out = integerArrayListToString(ret);

            System.out.print(out);
        }
    }
}
