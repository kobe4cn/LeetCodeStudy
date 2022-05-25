import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//323. 无向图中连通分量的数目
public class NumberofConnectedComponentsinanUndirectedGraph_323 {
    public int countComponents(int n, int[][] edges) {
        SortedMap<Integer, List<Integer>> map = new TreeMap<>((o1, o2) -> o1-o2);

        for (int[] ints : edges
        ) {
            if (map.containsKey(ints[0])) {
                map.get(ints[0]).add(ints[1]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(ints[1]);
                map.put(ints[0], list);
            }
        }
        int i = 0;
        Queue<Integer> queue = new LinkedList<>();
        //Iterator<Integer> iterator = map.keySet().iterator();
        int[] check = new int[n];

        for (int j = 0; j < check.length; j++) {
            if(check[j]==0) {
                queue.add(j);
                i++;
                while (!queue.isEmpty()) {
                    int key = queue.remove();
                    if (map.containsKey(key)) {
                        List<Integer> integers = map.get(key);
                        integers.forEach(integer -> queue.add(integer));
                        map.remove(key);
                        check[key] = 1;
                    }else{
                        check[key]=1;
                    }
                }
            }
        }

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
