import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//1441. 用栈操作构建数组
public class Build_an_Array_With_Stack_Operations_1441 {
    public List<String> buildArray(int[] target, int n) {
        List<String> list=new ArrayList<>();
        int j=1;
        for (int i = 0; i < target.length; i++) {
            while(j<=n){
                list.add("Push");
                if(j!=target[i]){
                    list.add("Pop");
                }else{
                    j++;
                    break;
                }
                j++;
            }
        }
        return list;
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

    public static String stringListToString(List<String> stringList) {
        StringBuilder sb = new StringBuilder("[");
        for (String item : stringList) {
            sb.append(item);
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] target = stringToIntegerArray(line);
            line = in.readLine();
            int n = Integer.parseInt(line);

            List<String> ret = new Build_an_Array_With_Stack_Operations_1441().buildArray(target, n);

            String out = stringListToString(ret);

            System.out.print(out);
        }
    }
}
