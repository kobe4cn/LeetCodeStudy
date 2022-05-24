import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//18. 四数之和
public class Sum_18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        int len = nums.length;
        if (len < 4) {
            return list;
        }
        for (int i = 0; i <= len - 4; i++) {
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int j = i + 1;
            while (j <= len - 3) {
                if(j>i+1 && nums[j]==nums[j-1]){
                    j++;
                    continue;
                }
                int k = j + 1;
                while (k <= len - 2) {
                    int l = k + 1;
                    while (l <= len - 1) {
//                        if(nums[l]==nums[l-1]){
//                            l++;
//                            continue;
//                        }
                        int count = nums[i] + nums[j] + nums[k] + nums[l];
                        if (count == target) {
//                            System.out.println(nums[i] +"+"+ nums[j] +"+"+ nums[k] + "+"+nums[l]);
                            List<Integer> list1 = new ArrayList<>();
                            list1.add(nums[i]);
                            list1.add(nums[j]);
                            list1.add(nums[k]);
                            list1.add(nums[l]);
                            list1= list1.stream().sorted().toList();
                                if(!list.contains(list1)){
                                    list.add(list1);
                                }
                        }
                        l++;
                    }
                    k++;
                }
                j++;
            }
        }
        return list;
    }
//        List<List<Integer>> list = new ArrayList<>();
//        int len = nums.length;
//        if (len < 4) {
//            return list;
//        }
//        for (int i = 0; i <= len - 4; i++) {
//            int j = i + 1;
//            while (j <= len - 3) {
//                int k = j + 1;
//                while (k <= len - 2) {
//                    int l = k + 1;
//                    while (l <= len - 1) {
//                        int count = nums[i] + nums[j] + nums[k] + nums[l];
//                        if (count == target) {
//                            List<Integer> list1 = new ArrayList<>();
//                            list1.add(nums[i]);
//                            list1.add(nums[j]);
//                            list1.add(nums[k]);
//                            list1.add(nums[l]);
////                            if(!list.containsAll(list1)){
////                                list.add(list1);
////                            }
//
//                            boolean b = list.stream().anyMatch(integerList -> integerList.containsAll(list1));
//                            if (!b) {
//                                list.add(list1);
//                            }
//                        }
//                        k++;
//                    }
//                    j++;
//                }
//            }
//        }
//        return list;


    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
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
        for (int index = 0; index < length; index++) {
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
        for (List<Integer> list : nums) {
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
            line = in.readLine();
            int target = Integer.parseInt(line);

            List<List<Integer>> ret = new Sum_18().fourSum(nums, target);

            String out = int2dListToString(ret);

            System.out.print(out);
        }
    }
}
