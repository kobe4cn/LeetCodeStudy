import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SearchinRotatedSortedArray_33 {
    //暴力破解
    public static int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==target){
                return i;
            }
        }
        return -1;
    }
    //另外一种算法，内存占用更少
//    public static int search(int[] nums, int target) {
//        if(nums.length==0){
//            return -1;
//        }
//
//        if(!Arrays.stream(nums).anyMatch(value -> value == target)){
//            return -1;
//        }
//        if(nums.length==1){
//            return 0;
//        }
//        int left=0;
//        int right=nums.length-1;
//        while(left<=right){
//            if(target>=nums[left]){
//                if(target==nums[left]){
//                    return left;
//                }else if(left+1<nums.length){
//                    if(nums[left]==nums[left+1]){
//                        return left;
//                    }
//                    if(nums[left]>nums[left+1]){
//                        return -1;
//                    }
//                }
//                    left++;
//
//
//            }
//            else if(target<=nums[right]){
//                if(target==nums[right]){
//                    return right;
//                }else if(right-1>0){
//                    if(nums[left]==nums[left+1]){
//                        return left;
//                    }
//                    if(nums[right]<nums[right-1]){
//                        return -1;
//                    }
//                }
//                    right--;
//
//            }
//        }
//        return -1;
//    }

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

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);
            line = in.readLine();
            int target = Integer.parseInt(line);

            int ret = search(nums, target);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }

}
