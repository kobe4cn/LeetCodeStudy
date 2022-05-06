
import java.util.*;

public class MeetingRoomII_253  {

    public static void main(String[] args) {
        int[][] temp={{1,4},{2,8},{5,7},{5,9},{3,4}};
        System.out.println(minMeetingRooom(temp));
    }
    public static int minMeetingRooom (int[][] intervals){
        //将数组按照第一位排序
        Arrays.sort(intervals,(int[] a, int[] b) -> a[0]-b[0] );
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>();
        priorityQueue.add(intervals[0][1]);
        for (int i = 1; i <intervals.length ; i++) {
            //Queue中的每个元素就是一个会议室当前的最早结束时间，所以只要大于这个结束时间的，该房间就可以被使用，所以将这个Queue的元素poll掉，然后添加更新的会议结束时间
            if(intervals[i][0]>=priorityQueue.peek()){
                priorityQueue.poll();
            }
            priorityQueue.add(intervals[i][1]);

        }
        return priorityQueue.size();
    }





}


