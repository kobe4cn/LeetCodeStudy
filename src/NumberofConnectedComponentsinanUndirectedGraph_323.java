import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//323. 无向图中连通分量的数目
public class NumberofConnectedComponentsinanUndirectedGraph_323 {
    public int countComponents(int n, int[][] edges) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>(Comparator.comparingInt(o -> o));

        for (int[] ints : edges
        ) {
            if (map.containsKey(ints[0])) {
                map.get(ints[0]).add(ints[1]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(ints[1]);
                map.put(ints[0], list);
            }
            if (map.containsKey(ints[1])) {
                map.get(ints[1]).add(ints[0]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(ints[0]);
                map.put(ints[1], list);
            }
        }
        for (int i = 0; i < n; i++) {
            if(!map.containsKey(i)){
                map.put(i,new ArrayList<>());
            }
        }
        int i = 0;
        Queue<Integer> queue = new LinkedList<>();
        Iterator<Integer> iterator = map.keySet().iterator();
//        int[] check = new int[n];

//        for (int j = 0; j < check.length; j++) {
//            if(check[j]==0) {
        while (iterator.hasNext()) {
            queue.add(iterator.next());
            i++;
            while (!queue.isEmpty()) {
                int key = queue.remove();
                if (map.containsKey(key)) {
                    List<Integer> integers = map.get(key);
                    integers.forEach(integer -> {queue.add(integer);
                        //check[integer]=1;
                    });
                    map.remove(key);
                    //check[key] = 1;
                }
            }
            iterator = map.keySet().iterator();
        }
        //long count = Arrays.stream(check).filter(value -> value == 0).count();
        return i;
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

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int n = Integer.parseInt(line);
            line = in.readLine();
            int[][] edges = stringToInt2dArray(line);

            int ret = new NumberofConnectedComponentsinanUndirectedGraph_323().countComponents(n, edges);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
