import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

//218. 天际线问题
public class TheSkylineProblem_218 {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        List<int[]> buildlines = new ArrayList<>();
        //将数据进行转换，把之前的二维数组，转换成，起始点（x,-y)和结束点（x,y)的数据，以便之后基于起始点和结束点的先后顺序排列。
        //同时将起始点的高度标注成负值是为了与结束点区别，以便从后面的queue中将最高点，如果横线结束了之后从队列中移除，使高度差发生变化，寻找下一个高度差

        for (int[] points : buildings) {
            buildlines.add(new int[]{points[0], -points[2]});
            buildlines.add(new int[]{points[1], points[2]});
        }
        buildlines.sort((o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            } else {
                return o1[1] - o2[1];
            }
        });
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        maxHeap.add(0);
        int preHighest = 0;
        for (int[] points : buildlines) {
            if(points[1]<0){
                maxHeap.add(-points[1]);
            }else{
                maxHeap.remove(points[1]);
            }
            int currentHeight=maxHeap.peek();
            if(currentHeight!=preHighest){
                res.add(Arrays.asList(points[0],currentHeight));
                preHighest=currentHeight;
            }
        }
        return res;
    }
}
