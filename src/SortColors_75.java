import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

//75. 颜色分类
public class SortColors_75 {
    public void sortColors(int[] nums) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            switch (nums[i]) {
                case 0:
                    list.addFirst(nums[i]);
                    break;
                case 1:
                    if(list.size()>0) {
                        int temp = list.indexOf(2);
                        if(temp>=0) {
                            list.remove(temp);
                            list.add(2);
                            list.add(temp, 1);
                        }else{
                            list.add(nums[i]);
                        }
                    }else if(list.size()==0){
                        list.add(nums[i]);
                    }
                    break;
                case 2:
                    list.addLast(nums[i]);
                    break;
            }
        }

        int[] temp=list.stream().mapToInt(Integer::intValue).toArray().clone();
        //指针的问题吗？一定要做arraycopy才有效
        System.arraycopy(temp,0,nums,0,temp.length);
    }

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

    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for (int index = 0; index < length; index++) {
            int number = nums[index];
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayToString(int[] nums) {
        return integerArrayToString(nums, nums.length);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);

            new SortColors_75().sortColors(nums);
            String out = integerArrayToString(nums);

            System.out.print(out);
        }
    }
}
