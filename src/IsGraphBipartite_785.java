import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//785. 判断二分图
public class IsGraphBipartite_785 {
    int[] colors;
    public boolean isBipartite(int[][] graph) {
        //0 未然,1 黑,2 白
       // Map<Integer,List<String>> map=new HashMap<>();
        colors=new int[graph.length];

        if(graph.length==1){
            return true;
        }
        //map.put(0,"w");
        for (int i = 0; i < colors.length; i++) {
            if(colors[i]==0){
                if(!DFS(i,graph,1)){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean DFS(int i, int[][] graph,int color ){
        colors[i]=color;
        for (int j = 0; j < graph[i].length; j++) {
            if(colors[graph[i][j]]!=0){
                if(colors[graph[i][j]]==color){
                    return false;
                }
            }else{
                if(!DFS(graph[i][j],graph,3-color)){
                    return false;
                }
            }
        }
        return true;
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

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[][] graph = stringToInt2dArray(line);

            boolean ret = new IsGraphBipartite_785().isBipartite(graph);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}
