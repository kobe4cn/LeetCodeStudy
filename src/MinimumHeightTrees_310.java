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
//        Map<Integer, List<Integer>> keymap = new HashMap<>();
//        Arrays.stream(edges).forEach(ints -> {
//            if (keymap.containsKey(ints[0])) {
//                List<Integer> list = keymap.get(ints[0]);
//                list.add(ints[1]);
//                keymap.put(ints[0], list);
//            }else{
//                List<Integer> list = new ArrayList<>();
//                list.add(ints[1]);
//                keymap.put(ints[0],list);
//            }
//            if (keymap.containsKey(ints[1])) {
//                List<Integer> list = keymap.get(ints[1]);
//                list.add(ints[0]);
//                keymap.put(ints[1], list);
//            }else{
//                List<Integer> list = new ArrayList<>();
//                list.add(ints[0]);
//                keymap.put(ints[1],list);
//            }
//        });
        //init
//        for (int i = 0; i < n; i++) {
//            getMapValue(i,edges,keymap);
//        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
//             int level=Integer.MAX_VALUE;
            List<Integer> deplistofroot = new ArrayList<>();
            List<Integer> usedlist = new ArrayList<>();
//
            DFS(i, edges, keymap, 0, deplistofroot, usedlist);
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

    public void DFS(int n, int[][] edges, Map<Integer, List<Integer>> keymap, int maxlevel, List<Integer> list1, List<Integer> usedlist) {
//        int level=level1;
        usedlist.add(n);
//        if (!keymap.containsKey(n)) {
//            getMapValue(n, edges, keymap);
//        }
        List<Integer> list = new ArrayList<>(keymap.get(n));
        list.removeAll(usedlist);
//        if(list==null){
//
//            //level=Math.min(maxlevel,level);
//            list1.add(maxlevel);
//            maxlevel=0;
//            return;
//        }
        for (int i = 0; i < list.size(); i++) {
            int key = list.get(i);
            //if(key==root) continue;
//            if(key==n){
//                list1.add(maxlevel);
//                //level=Math.min(maxlevel,level);
//                maxlevel=0;
//                return;
//            }
            DFS(key, edges, keymap, maxlevel + 1, list1, usedlist);
        }
        list1.add(maxlevel);
        //level=Math.min(maxlevel,level);
        maxlevel = 0;
        return;
    }


    public void getMapValue(int key, int[][] edges, Map<Integer, List<Integer>> keymap) {
        List<Integer> list = new ArrayList<>();
//        Arrays.stream(edges).sorted(new Comparator<int[]>() {
//            @Override
//            public int compare(int[] e1, int[] e2) {
//                if (e1[0]==e2[0]) return e1[1]-e2[1];   // e1[1]-e2[1]表示对于第二列元素进行升序排序
//                return e1[0]-e2[0];
//            }
//        }).forEach(ints -> {
//
//            if(ints[0] == key){
//                list.add(ints[1]);
//
//            }
//            if(ints[1] == key){
//                list.add(ints[0]);
//
//            }
//        });
//        keymap.put(key,list);


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
