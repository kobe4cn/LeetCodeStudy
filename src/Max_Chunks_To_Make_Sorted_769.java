import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//769. 最多能完成排序的块
public class Max_Chunks_To_Make_Sorted_769 {
    public int maxChunksToSorted(int[] arr) {

        int max=0,count=0;
        for (int i = 0; i < arr.length; i++) {
           max=Math.max(max,arr[i]);
           if(max==i){
               count++;
           }

        }
        return count;
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

            int ret = new Max_Chunks_To_Make_Sorted_769().maxChunksToSorted(arr);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
