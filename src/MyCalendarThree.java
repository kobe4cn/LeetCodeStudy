import java.util.Map;
import java.util.TreeMap;

//732. 我的日程安排表 III
public class MyCalendarThree {
    TreeMap<Integer,Integer> map;
    public MyCalendarThree() {
       map= new TreeMap<>();
    }

    public int book(int start, int end) {
        int max=0;
        int count=0;
        //定义差分数组，将数组的开始和结束，都放入map中，同时开始定义成1，结束定义成-1，之后再每次对于整个数组进行求和
        map.put(start,map.getOrDefault(start,0)+1);
        map.put(end,map.getOrDefault(end,0)-1);
        for (Map.Entry<Integer,Integer> entry:map.entrySet()

             ) {
            int freq=entry.getValue();
            //差分数组的核心是最终对于每个元素进行还原求和，求和的逻辑前一位加差分数组i位置的和
            //比如差分数组为   1 2 -1 -1 -1 1 -1
            //还原之后的数组是 1  3 2  1  0  1 0
            //                1+2=3，2+-1=2 以此类推


            count+=freq;
            max=Math.max(count,max);
        }

        return max;
    }
}
