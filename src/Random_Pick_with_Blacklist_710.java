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

    class Solution {

        private final int n;

        private final Random random = new Random();

        private final Map<Integer, Integer> map;

        public Solution(int n, int[] blacklist) {
            // 尝试通过二分来找出黑名单的数, 二分失败
            // 用评论区看到的方法, 假设黑名单长度为m
            // 假设[0:n-m)有x个黑名单, 那么[n-m:n)有m-x个黑名单, 则说明[n-m:n)中有m-(m-x)=x个白名单
            // 因此可以将x个黑名单映射到[n-m:n)的白名单中, 然后只需要找[0:n-m)中的数即可, 再判断当前数
            // 是否映射到了[n-m:n)的白名单中
            this.n = n - blacklist.length;
            this.map = new HashMap<>(blacklist.length);
            // 先将黑名单数加入到set中
            Set<Integer> blacklistSet = new HashSet<>();
            for (int black : blacklist) {
                blacklistSet.add(black);
            }
            int rightRegionIndex = this.n;
            for (int black : blacklist) {
                if (black < this.n) {
                    while (blacklistSet.contains(rightRegionIndex)) {
                        rightRegionIndex++;
                    }
                    this.map.put(black, rightRegionIndex++);
                }
            }
        }

        public int pick() {
            int randomValue = this.random.nextInt(this.n);
            Integer value = this.map.get(randomValue);
            return value == null ? randomValue : value;
        }

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
