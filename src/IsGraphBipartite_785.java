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
        //为每个数字都需要图上颜色
        for (int i = 0; i < colors.length; i++) {
            if(colors[i]==0){
                if(!DFS(i,graph,1)){
                    return false;
                }
            }
        }
        return true;
    }
    //遍历每个父节点的子节点，一直往下遍历，直到子节点遍历完成
    public boolean DFS(int i, int[][] graph,int color ){
        colors[i]=color;
        for (int j = 0; j < graph[i].length; j++) {
            //如果子节点已经有颜色了，同时颜色又跟父节点相同，那就证明该二分图存在问题。因为两个又线的点应该是不同颜色的，同一个颜色之间不应该是线，这个是二分图的基本规定。

            if(colors[graph[i][j]]!=0){
                if(colors[graph[i][j]]==color){
                    return false;
                }
            }else{
                //如果该点没有颜色，那就以父节点的颜色，给子节点赋一个颜色，因为颜色是，0，1，2 数组初始化的时候默认所有的点都是0为没有颜色，所以可以拿3去减父节点的颜色
                //得到的值不是1就是2，如果DFS遍历出现false那就直接return false
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
