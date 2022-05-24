import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//20. 有效的括号
public class ValidParentheses_20 {
    public boolean isValid(String s) {
//        if(s.length()<=1){
//            return false;
//        }
        Stack<Character> stack = new Stack<>();
        for (char c:s.toCharArray()
             ) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || c != stack.pop()) return false;
        }
        if(!stack.isEmpty()){
            return  false;
        }
        return true;
    }

    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);

            boolean ret = new ValidParentheses_20().isValid(s);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}
