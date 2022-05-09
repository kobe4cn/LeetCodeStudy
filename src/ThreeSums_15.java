import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ThreeSums_15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> retunlist=new ArrayList<>();
        int len=nums.length;
        for (int i = 0; i < len-2; i++) {
            int firstvalue=nums[i];
            int left=i+1;
            int right=len-1;
            while(left<right){
                int value=firstvalue+nums[left]+nums[right];
                if (value == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    if(!retunlist.contains(list)){
                        retunlist.add(list);
                    }
                    left++;
                    right--;
                }else if(value>0){
                    right--;
                }else if(value<0){
                    left++;
                }

            }
        }
        return retunlist;

    }
//    public static List<List<Integer>> threeSum(int[] nums) {
////        nums= Arrays.stream(nums).distinct().toArray();
//
//        List<List<Integer>> retunlist=new ArrayList<>();
//
//        for (int i = 0; i < nums.length; i++) {
//            int firstvalue=nums[i];
//            for (int j = i+1; j < nums.length; j++) {
//
//                for (int k = j+1; k < nums.length; k++) {
//                    List<Integer> list=new ArrayList<>();
//
//                        int value=firstvalue+nums[j]+nums[k];
//                        if (value == 0) {
//                            list.add(firstvalue);
//                            list.add(nums[j]);
//                            list.add(nums[k]);
//                            retunlist.add(list.stream().sorted().toList());
//                        }
//                }
//
//            }
//        }
//        return retunlist.stream().distinct().collect(Collectors.toList());
//
//    }

    /////////////////////////////////////
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

    public static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for(int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }

    public static String int2dListToString(List<List<Integer>> nums) {
        StringBuilder sb = new StringBuilder("[");
        for (List<Integer> list: nums) {
            sb.append(integerArrayListToString(list));
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);

            List<List<Integer>> ret = threeSum(nums);

            String out = int2dListToString(ret);

            System.out.print(out);
        }
    }
}
