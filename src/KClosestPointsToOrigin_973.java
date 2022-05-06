import java.util.*;
import java.util.stream.Collectors;


public class KClosestPointsToOrigin_973 {
    public static void main(String[] args) {
        int[][] points={{0,1},{1,0}};
        System.out.println(Arrays.toString(kClosest(points,2)));
    }
    public static int[][] kClosest(int[][] points, int k) {
        //循环所有的点的，从中取出点的坐标
        HashMap<String,int[]> pointMap=new HashMap<String, int[]>();
        List<Double> list=new ArrayList<>();
        //a-b是正序列，b-a是倒叙
        PriorityQueue<int[]> priorityQueue=new PriorityQueue<>((a, b)-> {
            return   (a[0] * a[0] + a[1] * a[1]) - (b[0] * b[0] + b[1] * b[1]);
        }
        );
        for (int i = 0; i < points.length; i++) {
            int[] point=points[i];
            //point的length应该为2，二维坐标
            if (point.length == 2) {
                //勾股定理，两点间的直线距离
                //x point[0],y point[1]
                priorityQueue.add(point);
            }
        }

        int[][] res=new int[k][2];
        for (int i = 0; i < k; i++) {
            res[i]=priorityQueue.poll();
        }
        return res;

    }
}
