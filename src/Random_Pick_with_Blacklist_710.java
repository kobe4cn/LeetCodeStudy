import java.util.*;

//710. 黑名单中的随机数
public class Random_Pick_with_Blacklist_710 {
    PriorityQueue<Map.Entry<Integer,Integer>> queue=new PriorityQueue<>((o1, o2) -> o1.getValue()-o2.getValue());

    public Random_Pick_with_Blacklist_710(int n, int[] blacklist) {
        List<Integer> list=new ArrayList<>();
        for (int i: blacklist
             ) {
            list.add(i);
        }
        for (int i = 0; i < n; i++) {

            if(!list.contains(i)){
                queue.offer(Map.entry(i,0));
            }
        }
    }

    public int pick() {
        Map.Entry<Integer, Integer> poll = queue.poll();
        queue.offer(Map.entry(poll.getKey(),poll.getValue()+1));
        return poll.getKey();
    }


    public static void main(String[] args) {
        int[] blacklist = {2,1};
        Random_Pick_with_Blacklist_710 solution = new Random_Pick_with_Blacklist_710(4, blacklist);
        System.out.println( solution.pick()); // 返回0，任何[0,1,4,6]的整数都可以。注意，对于每一个pick的调用，
        // 0、1、4和6的返回概率必须相等(即概率为1/4)。
        System.out.println( solution.pick());  // 返回 4
        System.out.println( solution.pick());  // 返回 1
        System.out.println( solution.pick());  // 返回 6
        System.out.println( solution.pick());  // 返回 1
        System.out.println( solution.pick()); // 返回 0
        System.out.println( solution.pick());  // 返回 4


    }
}
