import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//946. 验证栈序列
public class Validate_Stack_Sequences_946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        LinkedList<Integer> list = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();
        int js = 0;
        for (int i = 0; i < popped.length; i++) {
            if (js < pushed.length) {
                for (int j = js; j < pushed.length; ) {
                    if (list.size() > 0 && list.getLast() == popped[i]) {
                        list.removeLast();
                        js = j;
                        break;
                    } else if (popped[i] == pushed[j]) {
                        js = ++j;
                        break;
                    } else {
                        list.offer(pushed[j]);
                        js = ++j;
                    }
                }
            } else {
                if (list.size() > 0 && list.getLast() == popped[i]){
                    list.removeLast();
                }else{
                    return false;
                }
            }
        }

        if (list.size() == 0)
            return true;
        return false;
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

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] pushed = stringToIntegerArray(line);
            line = in.readLine();
            int[] popped = stringToIntegerArray(line);

            boolean ret = new Validate_Stack_Sequences_946().validateStackSequences(pushed, popped);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}
