//1224. 最大相等频率
public class Maximum_Equal_Frequency_1224 {
//    public int maxEqualFreq(int[] nums) {
//        Map<Integer, Integer> map=new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (i!=nums.length-1){
//                if(map.containsKey(nums[i])){
//                    map.computeIfPresent(nums[i],(integer, integer2) -> integer2++ );
//                }else{
//                    map.computeIfAbsent(nums[i],integer -> 1 );
//                }
//            }
//        }
//        Iterator<Integer> iterator = map.values().iterator();
//        Map<Integer,Integer> freq=new HashMap<>();
//
//        while(iterator.hasNext()){
//            Integer next = iterator.next();
//            if(freq.containsKey(next)){
//                map.computeIfPresent(next,(integer, integer2) -> integer2++);
//            }
//        }
//    }
}
