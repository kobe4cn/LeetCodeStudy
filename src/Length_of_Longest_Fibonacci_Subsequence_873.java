import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

//873. 最长的斐波那契子序列的长度
public class Length_of_Longest_Fibonacci_Subsequence_873 {
    public int lenLongestFibSubseq(int[] arr) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i],i);
        }
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                LinkedList<Integer> list=new LinkedList<>();
                list.add(arr[i]);
                list.add(arr[j]);
                int i1 = arr[i] + arr[j];
                while(map.containsKey(i1)){
                    int pre=list.getLast();
                    list.add(i1);
                    i1=pre+list.getLast();
                }
                max=Math.max(max,list.size());
            }
        }
        return max<3?0:max;
    }

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
            int[] arr = stringToIntegerArray(line);

            int ret = new Length_of_Longest_Fibonacci_Subsequence_873().lenLongestFibSubseq(arr);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
