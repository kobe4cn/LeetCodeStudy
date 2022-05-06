import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;
import java.util.stream.Collectors;

public class TwoSum_1 {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(twoSum(new int[]{7,6,2,15},9)));

    }
    public static int[] twoSum(int[] nums,int target){
        HashMap<Integer,Integer> hashMap=new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target-nums[i]) ) {
                return new int[]{hashMap.get(target - nums[i]),i};


            }else{
                hashMap.put(nums[i],i);
            }
        }
        return new int[]{};
    }
}
