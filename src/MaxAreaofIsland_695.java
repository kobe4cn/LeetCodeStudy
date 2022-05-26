import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//695. 岛屿的最大面积
public class MaxAreaofIsland_695 {
    public int maxAreaOfIsland(int[][] grid) {
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j <grid[0].length ; j++) {
                Queue<int[]> queue=new LinkedList<>();
                if(grid[i][j]==1){
                    int[] temp={i,j};
                    queue.add(temp);
                }
                //将查询的到1放进queue
                int count=0;
                while(!queue.isEmpty()){
                    int[] ints = queue.remove();
                    int y=ints[0];
                    int x=ints[1];
                    grid[y][x]=2;
//                    判断que这个值的上下左右是否是1，如果是继续放进Q
                    //左
                    if(x-1>=0 && grid[y][x-1]==1){
                        int[] temp={y,x-1};
                        grid[y][x-1]=2;
                        queue.add(temp);
                    }
                    //上
                    if(y-1>=0 && grid[y-1][x]==1){
                        int[] temp={y-1,x};
                        grid[y-1][x]=2;
                        queue.add(temp);
                    }
                    //右
                    if(x+1<grid[0].length && grid[y][x+1]==1){
                        int[] temp={y,x+1};
                        grid[y][x+1]=2;
                        queue.add(temp);
                    }
                    //下
                    if(y+1<grid.length && grid[y+1][x]==1){
                        int[] temp={y+1,x};
                        grid[y+1][x]=2;
                        queue.add(temp);
                    }

                    count++;
                }
                if(count>0) {
                    list.add(count);
                }
            }
        }
        return list.size()!=0?list.stream().max(Integer::compareTo).get():0;
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

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[][] grid = stringToInt2dArray(line);

            int ret = new MaxAreaofIsland_695().maxAreaOfIsland(grid);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
