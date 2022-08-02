import java.io.IOException;

//256. 粉刷房子
public class PaintHouse_256 {
    public int minCost(int[][] costs) {
        if (costs == null && costs.length == 0) {
            return 0;
        }
        //将上一层的结果直接加入到下一层中，每次都找到最优解
        for (int i = 1; i < costs.length; i++) {
            costs[i][0] = costs[i][0] + Math.min(costs[i - 1][1], costs[i - 1][2]);
            costs[i][1] = costs[i][1] + Math.min(costs[i - 1][0], costs[i - 1][2]);
            costs[i][2] = costs[i][2] + Math.min(costs[i - 1][1], costs[i - 1][0]);
        }
        int n=costs.length-1;
        return Math.min(costs[n][2],Math.min(costs[n][0],costs[n][1]));
    }


    public static void main(String[] args) throws IOException {

        int[][] costs = {{17, 2, 17}, {16, 16, 5}, {14, 3, 19}};
//        int[][] costs={{7,6,2}};
//        int[][] costs = {{5, 8, 6}, {19, 14, 13}, {7, 5, 12}, {14, 15, 17}, {3, 20, 10}};
//        int[][] costs={{3,5,3},{6,17,6},{7,13,18},{9,10,18}};
//        int[][] costs={{6,4,13},{10,9,15},{14,15,11},{17,15,9},{7,10,13},{18,9,4},{5,20,12}};
        //int[][] costs={{13,8,17},{6,8,19},{5,1,7},{5,18,2},{12,3,4},{12,7,10},{14,16,7},{19,17,19}};
      //int[][] costs = {{5, 8, 6}, {19, 14, 13}, {7, 5, 12}, {14, 15, 17}, {3, 20, 10}};
        int ret = new PaintHouse_256().minCost(costs);


        String out = String.valueOf(ret);

        System.out.println(out);
    }

}
